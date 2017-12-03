package gameObjs;

import android.content.Context;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.util.Log;

import java.util.Random;

public class PalaJugador extends PalaGeneral{

    private int ySpeed, xSpeed, antX, antY;
    private int dWidth, dHeight;
    private RectF rect;

    public PalaJugador(Context context, int width, int height) {
        super(context);
        dHeight = height;
        dWidth = width;

        xSpeed = 10;
        ySpeed = xSpeed;

        setX(dWidth/2);
        setY(dHeight/2);
        antX = getPosX();
        antY = getPosY();

        rect = new RectF(getPosX(), getPosY(), getPosX() + getW(), getPosY() + getH());

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

}
