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
    private int xSpeed;
    private int ySpeed;
    private int x;
    private int y;
    private int rad;
    private int dWidth;
    private int dHeight;
    private RectF rect;
    private boolean fueraDePantalla;
    double v;
    int xFin;
    int yFin;

    //private double angle;
    public Bullet (Context context, int dispW, int dispH, int x, int y, int xFin, int yFin) {
        super(context);
        this.x = x;
        this.y = y;
        double angle = Math.atan2((double)yFin - y,(double) xFin - x);
        fueraDePantalla = false;
        dWidth = dispW;
        dHeight = dispH;
        paint = new Paint();
        rad = 20;
        v = 0.01;


        //xSpeed = (int) ( 1 + ((xFin - x) * v));
        xSpeed= calculateSpeedX(this.x);
        //ySpeed = (int) ( 1+ ((yFin - y) * v));
        ySpeed = calculateSpeedY(this.y);

        rect = new RectF(x, y, x+rad, y+rad);
    }

    public int calculateSpeedX(int x){
        int speedX;
        speedX = ((int) ( 1 + ((this.xFin - x) * this.v)));
        return speedX;
    }
    public int calculateSpeedY(int y){
        int speedY;
        speedY = ((int) ( 1 + ((this.yFin - x) * this.v)));
        return speedY;
    }

    public boolean offScreen (int x, int y){
        if ((y < 0) || (y + rad > dHeight) || (x < 0) || (x + rad > dWidth)) { //Si no se sale de los bordes horizontales se mueve
            return true;
        }
        return false;
    }

    public boolean move (Ball ball) {
        x += xSpeed;
        y += ySpeed;

        //if ((y < 0) || (y + rad > dHeight) || (x < 0) || (x + rad > dWidth)) { //Si no se sale de los bordes horizontales se mueve
        //    fueraDePantalla = true;
        //}
        fueraDePantalla=offScreen(x,y);

        rect.set(x, y , (float)x+rad, (float)y+ rad);

        if (rect.intersect(ball.getRect())) {
            return true;
        }
        return false;
    }

    @Override
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
