package gameObjs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;


public class Ball extends View {

    int dWidth, dHeight;
    int x, y, radio;
    int xSpeed, ySpeed;
    Paint paint;

    public Ball(Context context, int dispW, int dispH) {
        super(context);

        dWidth = dispW;
        dHeight = dispH;

        x = dWidth / 2;
        y = dHeight / 2;

        radio = 50;


        xSpeed = -2;
        ySpeed = -2;



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
        if ((nextPosX >= dWidth - radio) || (nextPosX <= 0)){
            xSpeed = -xSpeed;
        }
        if ((nextPosY >= dHeight - radio) || (nextPosY <= 0)) {
            ySpeed = -ySpeed;
        }
        x += xSpeed;
        y += ySpeed;

    }
}
