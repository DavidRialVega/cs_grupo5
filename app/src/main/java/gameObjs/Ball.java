package gameObjs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;

import java.util.Random;


public class Ball extends View {

    /*private int dWidth, dHeight;
    private int x, y, rad;
    private int xSpeed, ySpeed;
    private Paint paint;
    private int lifes;
    private RectF rect;
    int [] color = {Color.rgb(200, 20, 20), Color.rgb(255, 217 , 15), Color.rgb(30, 180, 30)}; //Rojo, amarillo y verde

    public Ball(Context context, int dispW, int dispH) {
        super(context);

        dWidth = dispW;
        dHeight = dispH;
        rad = 65;


        Random r = new Random();
        if (r.nextBoolean()){ //Para elegir si ponerlo a la izq o la dch de la pantalla. True es izquierda y false derecha
            setX(r.nextInt((dWidth/2) - (dWidth/8)) ); // Zona "segura" en las inmediaciones de la pelota
        } else {
            setX(r.nextInt((dWidth/2) - (dWidth/8)) + (dWidth/2) + (dWidth/8) - (rad + 2)  );
        }

        setY(r.nextInt(dHeight - rad));

        xSpeed = (r.nextInt(6)/2) - 3;
        ySpeed = (r.nextInt(6)/2) - 3;

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
        paint.setColor(color[lifes-1]);
        paint.setAntiAlias(true);
        canvas.drawOval(rect, paint);
    }

    public boolean move (PalaJugador pala){
        if ((y > 0) && (y + rad < dHeight)) { //Si no se sale de los bordes horizontales se mueve
            this.y = y;
            rect.set(x, y , x+rad, y+ rad);
        }

        if (rect.intersect(pala.getRect())) {
            //ball.touched();
            return true;
        }
        return false;
    }



    public void touched (){
        lifes--;
    }
*/
    private int dWidth, dHeight;
    private int x, y, rad;
    private int xSpeed, ySpeed;
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

        int numero = (int) (Math.random() * (dWidth-rad)); // Para aparecer por cualquier lado;
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
            //ySpeed = -ySpeed;
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
        /*else // No puede chocar con dos palas a la vez
            //Choque pala derecha
            if ((nextPosX + rad >= right.getPosX()) && (nextPosX + rad <= right.getPosX() + right.getW())) { //comprobacion de chqoue en las x
                if ((nextPosY <= right.getPosY() + right.getH()) && (nextPosY >= right.getPosY())){  //comprobacion de choque en las y
                    xSpeed = - xSpeed;
                }
            }*/

        //avance de la bola
        x += xSpeed;
        y += ySpeed;
        rect.set(x, y , x+rad, y+ rad);
        return  toque;
    }

    public RectF getRect(){
        return this.rect;
    }
}
