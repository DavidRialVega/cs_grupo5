package gameObjs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class PalaJugador extends PalaGeneral{

    private int ySpeed, xSpeed, antX, antY;
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

        //Choques con la pelota

        /*if (rect.intersect(ball.getRect())) {
            ball.touched();
            return true;
        }*/

        rect.set(getPosX(), getPosY(), getPosX() + getW(), getPosY() + getH());
    }

    public RectF getRect (){
        return this.rect;
    }

    public void shoot (int xFin, int yFin){
        if (bullets.size() < maxBullets){
            bullets.add(new Bullet(this.c, dWidth, dHeight, this.getPosX() + this.getW()/2, this.getPosY() + this.getH()/2, xFin, yFin ));
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

    public void draw (Canvas canvas){
        super.draw(canvas);
        for (Bullet bala : bullets){
            if (bala.isOnScreen()) {
                bala.draw(canvas);
            }
        }
    }

}
