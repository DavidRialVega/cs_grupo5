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
    private JugadorPalaIzq leftPlayer;
    private JugadorPalaDch rightPlayer;
    //private Marcador scoreBoard;

    private int width, height;

    public void reset () {
        //if ()
        ball = new Ball(this.getContext(), width, height);
        leftPlayer = new JugadorPalaIzq(this.getContext(), 100, height/2);
        rightPlayer = new JugadorPalaDch(this.getContext(), width - 100, height/2);
        //scoreBoard = new Marcador(this.getContext(), width/2, height/2);
    }



    public Lienzo(Context context, int w, int h) {
        super(context);
        paint = new Paint();
        width = w;
        height = h;

        reset();
    }

    public void onDraw (Canvas canvas) {
        super.onDraw(canvas);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);

        ball.draw(canvas);
        leftPlayer.draw(canvas);
        rightPlayer.draw(canvas);

    }

    public void move(){
        //Primero se mueven las barras y despues la pelota
        rightPlayer.move(ball.getPosX(), ball.getPosY(), width, height);

        boolean reset = false; // De momento se queda asi.
        if (reset){
            //scoreBoard.sumarPuntos();
            reset();
        }

    }
    public void moveBall(int y){ ball.move(y); }



}
