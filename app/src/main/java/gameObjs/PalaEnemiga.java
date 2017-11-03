package gameObjs;

import android.content.Context;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.util.Log;

import java.util.Random;

public class PalaEnemiga extends PalaGeneral{

    private int ySpeed;
    private int xSpeed;
    private int dWidth, dHeight;
    private RectF rect;

    public PalaEnemiga(Context context, int width, int height) {
        super(context);
        dHeight = height;
        dWidth = width;

        Random r = new Random();
        if (r.nextBoolean()){ //Para elegir si ponerlo a la izq o la dch de la pantalla. True es izquierda y false derecha
            setX(r.nextInt((dWidth/2) - (dWidth/8)) ); // Zona "segura" en las inmediaciones de la pelota
        } else {
            setX(r.nextInt((dWidth/2) - (dWidth/8)) + (dWidth/2) + (dWidth/8) - (getW() + 2)  );
        }

        setY(r.nextInt(dHeight - getH()));

        xSpeed = (r.nextInt(6)/2) - 3;
        ySpeed = (r.nextInt(6)/2) - 3;

        rect = new RectF(getPosX(), getPosY(), getPosX() + getW(), getPosY() + getH());

    }

    public boolean move (Ball ball){
        int nextPosX = getPosX() + xSpeed;
        int nextPosY = getPosY() + ySpeed;
        rect.set(nextPosX, nextPosY, nextPosX + getW(), nextPosY + getH());

        //Choques laterales
        if ((nextPosX > dWidth - getW()) || (nextPosX <= 0)){
            xSpeed = -xSpeed;
        }

        //Choques superiores
        if ((nextPosY >= dHeight - getH()) || (nextPosY <= 0)) {
            ySpeed = -ySpeed;
        }

        //Choques con la pelota

        if (rect.intersect(ball.getRect())) {
            ball.touched();
            return true;
        }

        setX(getPosX() + xSpeed);
        setY(getPosY() + ySpeed);
        rect.set(getPosX(), getPosY(), getPosX() + getW(), getPosY() + getH());

        return false;
    }

}
