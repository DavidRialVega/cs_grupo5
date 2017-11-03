package gameObjs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;


//Esta clase crea un nuevo hilo para no sobrecargar a la vista original durante el juego

public class Lienzo extends View  {

    private Ball ball;
    private Paint paint;
    private ListaPalos listaPalos;
    //private Marcador scoreBoard;

    private int width, height;


    public Lienzo(Context context, int w, int h) {
        super(context);
        paint = new Paint();
        width = w;
        height = h;
        ball = new Ball(this.getContext(), width, height);
        listaPalos = new ListaPalos(this.getContext(), width, height);
    }

    public void reset () {
        if (ball.getLifes() > 0){
            ball.setX(width/2);
            ball.setY(height/2);
            listaPalos.reset();
        }
        else {
            ball = new Ball(this.getContext(), width, height);
            listaPalos = new ListaPalos(this.getContext(), width, height);
            addPalo();
        }
    }

    public void addPalo () {
        listaPalos.add();
    }

    public void onDraw (Canvas canvas) {
        super.onDraw(canvas);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);

        ball.draw(canvas);
        listaPalos.draw(canvas);

    }

    public void move(){

        if (listaPalos.move(ball))
        {
            reset();
        }

    }
    public void moveBall(int y){
        ball.move(y);
    }



}
