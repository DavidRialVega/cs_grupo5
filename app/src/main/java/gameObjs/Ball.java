package gameObjs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;


public class Ball extends View {

    private int dWidth, dHeight;
    private int x, y, rad;
    private int xSpeed, ySpeed;
    private Paint paint;

    public Ball(Context context, int dispW, int dispH) {
        super(context);

        dWidth = dispW;
        dHeight = dispH;

        x = dWidth / 2;
        y = dHeight / 2;

        rad = 50;


        xSpeed = -2;
        ySpeed = -2;

        paint = new Paint();
    }

    public int getPosX () {
        return x;
    }
    public int getPosY() {
        return y;
    }

    public void draw(Canvas canvas){
        super.draw(canvas);
        paint.setColor(Color.GRAY);
        paint.setAntiAlias(true);
        RectF ball = new RectF(x, y , x+rad, y+ rad);
        canvas.drawOval(ball, paint);
    }

    public boolean move(PalaGeneral left, PalaGeneral right){

        int nextPosX = x + xSpeed;
        int nextPosY = y + ySpeed;

       //Choques laterales
        if ((nextPosX >= dWidth - rad) || (nextPosX <= 0)){

            xSpeed = - xSpeed; // borrar cuando se implementen los movimientos
            // Para cuando se implementen los movimientos, al salir por los bordes se reseten los jugadores y la bola
            //return true;
        }

        //Choques superiores
        if ((nextPosY >= dHeight - rad) || (nextPosY <= 0)) {
            ySpeed = -ySpeed;
        }

        //Choques palas
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
        return  false;
    }
}
