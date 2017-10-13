package gameObjs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;


//Esta clase crea un nuevo hilo para no sobrecargar a la vista original durante el juego

public class Lienzo extends View  {

    Ball bola;
    Paint paint;



    public Lienzo(Context context) {
        super(context);
        paint = new Paint();
        bola = new Ball(context);
        Log.i("dime", getWidth() + " " + getHeight());
    }


    public void onDraw (Canvas canvas) {
        super.onDraw(canvas);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawPaint(paint);

        bola.draw(canvas);

        //invalidate();
    }

    public void move(){
        bola.move();
    }




}
