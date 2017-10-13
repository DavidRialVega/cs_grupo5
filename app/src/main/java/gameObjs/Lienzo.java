package gameObjs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;


//Esta clase crea un nuevo hilo para no sobrecargar a la vista original durante el juego

public class Lienzo extends View  {

    private Ball bola;
    private Paint paint;

    private int width, height;



    public Lienzo(Context context, int w, int h) {
        super(context);
        paint = new Paint();
        bola = new Ball(context, w, h);
        Log.i("dime", getWidth() + " " + getHeight());
        width = w;
        height = h;
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
