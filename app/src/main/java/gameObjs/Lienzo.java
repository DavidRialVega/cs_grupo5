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
    private PalaJugador jugador;
    //private Marcador scoreBoard;

    private int width, height;


    public Lienzo(Context context, int w, int h) {
        super(context);
        paint = new Paint();
        width = w;
        height = h;
        ball = new Ball(this.getContext(), width, height);
        jugador = new PalaJugador(this.getContext(), width, height);
    }

    public void reset () {
        ball = new Ball(this.getContext(), width, height);
        jugador = new PalaJugador(this.getContext(), width, height);
    }

    public void addPalo () {
        //listaPalos.add();
    }

    public void onDraw (Canvas canvas) {
        super.onDraw(canvas);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
        jugador.draw(canvas);
        ball.draw(canvas);
    }

    public void move(){
        /*
        if (ball.move(jugador))
        {
            reset();
        }
        */
        boolean reset = ball.move(jugador);
        if(reset){
            reset();
        }
    }
    public void movePlayer (int x, int y){
        jugador.move(x, y);
        Log.println(Log.WARN, "movement", x + " " + y);
    }

}
