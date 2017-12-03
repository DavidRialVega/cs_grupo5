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

    private int dWidth, dHeight;
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

}
