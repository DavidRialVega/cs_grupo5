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

    public RectF getRect(){
        return this.rect;
    }

    public void touched (){
        lifes--;
    }
*/
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


        xSpeed = 2;
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

    public boolean move(PalaJugador left){
        boolean toque;
        toque = false;
        int nextPosX = x + xSpeed;
        int nextPosY = y + ySpeed;

        //Choques laterales
        if ((nextPosX >= dWidth - rad) || (nextPosX <= 0)){
            xSpeed = -xSpeed;
        }

        //Choques superiores
        if ((nextPosY >= dHeight - rad) || (nextPosY <= 0)) {
            ySpeed = -ySpeed;
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
        return  toque;
    }
}
