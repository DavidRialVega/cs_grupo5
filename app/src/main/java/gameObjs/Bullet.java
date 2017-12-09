package gameObjs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by ivanm on 09/12/2017.
 */

public class Bullet extends View {

    private Paint paint;
    private int xSpeed, ySpeed, x, y, rad, v, dWidth, dHeight;
    private RectF rect;
    private boolean fueraDePantalla;

    private double angle;
    public Bullet (Context context, int dispW, int dispH, int x, int y, int xFin, int yFin) {
        super(context);
        this.x = x;
        this.y = y;
        angle = Math.atan2(yFin - y, xFin - x);
        fueraDePantalla = false;
        dWidth = dispW;
        dHeight = dispH;
        paint = new Paint();
        rad = 20;
        v = 3;
    }

    public boolean move (Ball ball) {
        x =(int) Math.cos(angle)*v;
        y = (int) Math.sin(angle) * v;
        y = y + ySpeed;

        if ((y < 0) || (y + rad > dHeight) || (x < 0) || (x + rad > dWidth)) { //Si no se sale de los bordes horizontales se mueve
            fueraDePantalla = true;
        }

        rect.set(x, y , x+rad, y+ rad);

        if (rect.intersect(ball.getRect())) {
            return true;
        }
        return false;
    }

    public void draw (Canvas canvas) {
        super.draw(canvas);
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        canvas.drawOval(rect, paint);
    }
    public boolean isOnScreen (){
        return !fueraDePantalla;
    }
}
