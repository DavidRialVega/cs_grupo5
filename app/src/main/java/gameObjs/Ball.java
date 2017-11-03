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
    private int lifes;
    private RectF rect;

    public Ball(Context context, int dispW, int dispH) {
        super(context);

        dWidth = dispW;
        dHeight = dispH;

        x = dWidth / 2;
        y = dHeight / 2;

        rad = 50;

        rect = new RectF(x, y , x+rad, y+ rad);

        lifes = 3;
        paint = new Paint();
    }

    public int getPosX () {
        return x;
    }
    public int getPosY() {
        return y;
    }
    public int getLifes(){
        return lifes;
    }

    public void draw(Canvas canvas){
        super.draw(canvas);
        paint.setColor(Color.GRAY);
        paint.setAntiAlias(true);
        canvas.drawOval(rect, paint);
    }

    public void move (int y){
        if ((y > 0) && (y + rad < dHeight)) { //Si no se sale de los bordes horizontales se mueve
            this.y = y;
            rect.set(x, y , x+rad, y+ rad);
        }
    }

    public RectF getRect(){
        return this.rect;
    }

    public void touched (){
        lifes--;
    }

    /*public boolean move(PalaGeneral left, PalaGeneral right){

        int nextPosX = x + xSpeed;
        int nextPosY = y + ySpeed;

       //Choques laterales
        if ((nextPosX >= dWidth - rad) || (nextPosX <= 0)){
            return true;
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
    }*/


}
