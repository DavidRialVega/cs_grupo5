package gameObjs;

import android.content.Context;
import android.graphics.RadialGradient;

import java.util.Random;

public class PalaEnemiga extends PalaGeneral{

    private int ySpeed;
    private int xSpeed;
    private int dWidth, dHeight;

    public PalaEnemiga(Context context, int width, int height) {
        super(context);
        dHeight = height;
        dWidth = width;
        Random r = new Random();
        if (r.nextBoolean()){ //Para elegir si ponerlo a la izq o la dch de la pantalla. True es izquierda y false derecha
            setX(r.nextInt((dWidth/2) - (dWidth/8)) );
        } else {
            setX(r.nextInt((dWidth/2) - (dWidth/8)) + (dWidth/2) + (dWidth/8));
        }

        setY(r.nextInt(dHeight - getH()));
        xSpeed = (r.nextInt(6)/2) - 3;
        ySpeed = (r.nextInt(6)/2) - 3;


    }

    public void move (Ball ball){
        int nextPosX = getPosX() + xSpeed;
        int nextPosY = getPosY() + ySpeed;



        //Choques laterales
        if ((nextPosX > dWidth - getW()) || (nextPosX <= 0)){
            xSpeed = -xSpeed;
        }

        //Choques superiores
        if ((nextPosY >= dHeight - getH()) || (nextPosY <= 0)) {
            ySpeed = -ySpeed;
        }



        /*//Choques palas
        //Choque pala izq
        if ((nextPosX <= left.getPosX() + left.getW()) && (nextPosX  + rad >= left.getPosX())) //comprobacion de chqoue en las x
        {
            if ((nextPosY <= left.getPosY() + left.getH()) && (nextPosY >= left.getPosY())){  //comprobacion de choque en las y
                xSpeed = - xSpeed;
            }
        } else // No puede chocar con dos palas a la vez
            //Choque pala derecha
            if ((nextPosX + rad >= right.getPosX()) && (nextPosX + rad <= right.getPosX() + right.getW())) { //comprobacion de chqoue en las x
                if ((nextPosY <= right.getPosY() + right.getH()) && (nextPosY >= right.getPosY())){  //comprobacion de choque en las y
                    xSpeed = - xSpeed;
                }
            }

        //avance de la bola
        x += xSpeed;
        y += ySpeed;
        return  false;*/
        setX(getPosX() + xSpeed);
        setY(getPosY() + ySpeed);
    }

}
