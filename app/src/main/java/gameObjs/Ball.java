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
    int [] color = {Color.rgb(200, 20, 20), Color.rgb(255, 217 , 15), Color.rgb(30, 180, 30)}; //Rojo, amarillo y verde

    public Ball(Context context, int dispW, int dispH) {
        super(context);

        dWidth = dispW;
        dHeight = dispH;


        x = dWidth / 2;
        y = dHeight / 2;

        rad = 65;

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

}
