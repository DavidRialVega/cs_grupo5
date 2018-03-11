package gameObjs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
//import android.util.Log;
import android.view.View;

import java.util.Random;


public class Ball extends View {


    private int dWidth;
    private int dHeight;
    private int x;
    private int y;
    private int rad;
    private int xSpeed;
    private int ySpeed;
    private Paint paint;
    private boolean cubo;
    private RectF rect;

    public Ball(Context context, int dispW, int dispH) {
        super(context);

        dWidth = dispW;
        dHeight = dispH;

        x = dWidth / 4;
        y = dHeight / 4;

        rad = 80;

        cubo = false;
        xSpeed = 2;
        ySpeed = 2;

        rect = new RectF(x, y , x+rad, y+ rad);
        paint = new Paint();
    }

    public int getPosX () {
        return x;
    }
    public int getPosY() {
        return y;
    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        paint.setColor(Color.GRAY);
        paint.setAntiAlias(true);
        if (cubo) {
            canvas.drawRect(rect, paint);
        }
        else {
            canvas.drawOval(rect, paint);
        }
    }

    public boolean move(PalaJugador left){
        boolean toque;
        toque = false;
        int nextPosX = x + xSpeed;
        int nextPosY = y + ySpeed;

        // Para aparecer por cualquier lado;
        int numero = (int) (Math.random() * (dWidth-rad));
        int opcion = (int) (Math.random() * 4)+1;
        //Choques laterales
        if ((nextPosX >= dWidth - rad) || (nextPosX <= 0)){
            ySpeed=-ySpeed;
            if((nextPosX <= 0)) {
                if (opcion == 1) {
                    x = dWidth - rad;
                    y = numero + rad;
                }
                if (opcion == 2) {
                    x = numero + rad;
                    y = 0 + rad;
                }
                if (opcion == 3) {
                    x = numero + rad;
                    y = dHeight - rad;
                }
                if (opcion == 4) {
                    xSpeed = -xSpeed;
                }
            }
            else if((nextPosX >= dWidth - rad)){
                if (opcion == 1) {
                    xSpeed = -xSpeed;
                }
                if (opcion == 2) { // superior
                    x = numero + rad;
                    y = 0 + rad;
                }
                if (opcion == 3) { // inferior
                    x = numero + rad;
                    y = dHeight - rad;
                }
                if (opcion == 4) {
                    x = 0 + rad;
                    y = numero + rad;
                }
            }
        }
        opcion = (int) (Math.random() * 4)+1;
        //Choques superiores
        if ((nextPosY >= dHeight - rad) || (nextPosY <= 0)) {
            xSpeed = -xSpeed;
            if((nextPosY <= 0)){
                if (opcion == 1) {
                    x = dWidth - rad;
                    y = numero + rad;
                }
                if (opcion == 2) { // superior
                    x = numero + rad;
                    y = 0 + rad;
                }
                if (opcion == 3) { // inferior
                    ySpeed=-ySpeed;
                }
                if (opcion == 4) {
                    x = 0 + rad;
                    y = numero + rad;
                }
            }
            else if((nextPosY >= dHeight - rad)){
                if (opcion == 1) {
                    x = dWidth - rad;
                    y = numero + rad;
                }
                if (opcion == 2) { // superior
                    ySpeed = -ySpeed;
                }
                if (opcion == 3) { // inferior
                    x = numero + rad;
                    y = dHeight - rad;
                }
                if (opcion == 4) {
                    x = 0 + rad;
                    y = numero + rad;
                }
            }
        }
        if ((nextPosX >= dWidth - rad) || (nextPosX <= 0) || (nextPosY >= dHeight - rad) || (nextPosY <= 0)){
            if (cubo){
                cubo = false;
            }
            else {
                cubo = true;
            }
        }
        //Choques palas
        //Choque pala izq
        if ((nextPosX <= left.getPosX() + left.getW()) && (nextPosX  + rad >= left.getPosX()) ) //comprobacion de chqoue en las x
        {
            if ((nextPosY <= left.getPosY() + left.getH()) && (nextPosY >= left.getPosY())){  //comprobacion de choque en las y
                xSpeed = - xSpeed;
                toque=true;
            }
        }


        //avance de la bola
        x += xSpeed;
        y += ySpeed;
        rect.set(x, y , (float)x+rad, (float)y+ rad);
        return  toque;
    }

    public RectF getRect(){
        return this.rect;
    }
}
