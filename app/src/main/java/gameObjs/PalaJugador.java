package gameObjs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;

import java.util.ArrayList;

public class PalaJugador extends PalaGeneral{

    private int ySpeed;
    private int xSpeed;
    private int antX;
    private int antY;
    private int dWidth, dHeight;
    private RectF rect;
    private int maxBullets;
    Context c;

    private ArrayList<Bullet> bullets;

    public PalaJugador(Context context, int width, int height) {
        super(context);
        c = context;
        dHeight = height;
        dWidth = width;

        xSpeed = 15;
        ySpeed = xSpeed;

        setX(dWidth/2);
        setY(dHeight/2);
        antX = getPosX();
        antY = getPosY();

        rect = new RectF(getPosX(), getPosY(), getPosX() + getW(), getPosY() + getH());

        bullets = new ArrayList<>();
        maxBullets = 5;
    }

    public void move (int x, int y){

        int nextX, nextY;
        nextX = getPosX();
        nextY = getPosY();
        if (antX != x) {
            nextX = antX - x < 0 ? (getPosX() + xSpeed) : (getPosX() - xSpeed);
        }
        if (antY != y) {
            nextY = antY - y < 0 ? (getPosY() + ySpeed) : (getPosY() - ySpeed);
        }

        //Choques laterales
        if (nextX + getW()/2 >= dWidth ) {
            this.setX(20);   //Si se sale por la derecha aparece en la izq
        } else if (nextX <= 0) {
            this.setX(dWidth-getW()-20);    //si se sale por la izq aparece en la dch
        } else {
            setX(nextX ); //si no se sale por ningun lado
        }

        //Choques superiores
        if (nextY + getH() >= dHeight) {
            this.setY(20);       //si se sale por abajo
        } else if (nextY <= 0){
            this.setY(dHeight - this.getH()  - 20);   //si se sale por arriba
        } else {
            setY(nextY); //si no se sale
        }

        antX = x;
        antY = y;
        rect.set(getPosX(), getPosY(), (float)getPosX() + getW(), (float)getPosY() + getH());
    }

    public RectF getRect (){

        return this.rect;
    }

    public boolean shoot (int xFin, int yFin){
        if (bullets.size() < maxBullets){
            bullets.add(new Bullet(this.c, dWidth, dHeight, this.getPosX() + this.getW()/2, this.getPosY() + this.getH()/2, xFin, yFin ));
            return false;
        } else {
            return true;
        }
    }

    public boolean moveBullets (Ball ball) {
        for (Bullet bala : bullets){
            if (bala.move(ball)){
                return true;
            }
        }
        return  false;
    }
    @Override
    public void draw (Canvas canvas){
        super.draw(canvas);
        for (Bullet bala : bullets){
                bala.draw(canvas);

        }
    }

    public int balasRestantes (){
        return maxBullets - bullets.size();
    }

    public boolean todasBalasFuera(){
        int c = 0;
        for (Bullet bala: bullets){
            if (!bala.isOnScreen()){
                c++;
            }
        }
        return c == maxBullets;
    }

}
