package gameObjs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;


public class Ball extends View {

    int x, y, radio;
    int xSpeed, ySpeed;
    Paint paint;

    public Ball(Context context) {
        super(context);

        x = 500 ;
        y = 500;


        xSpeed = -5;
        ySpeed = -5;

        radio = 150;


        paint = new Paint();
    }

    public void draw(Canvas canvas){
        super.draw(canvas);
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        Log.d("ball", x + " " + y);
        RectF ball = new RectF(x, y , x+radio, y+ radio);
        canvas.drawOval(ball, paint);
    }

    public void move(){

        int nextPosX = x + xSpeed;
        int nextPosY = y + ySpeed;

        Log.i("dim", getWidth() + " " + getHeight());
        if ((nextPosX <= getWidth()) || (nextPosX <= -getWidth())  ){
            xSpeed = -xSpeed;
        }
        if ((nextPosY <= getHeight()) || (nextPosY >= 0)) {
            ySpeed = -ySpeed;
        }
        x += xSpeed;
        y += ySpeed;

    }
}
