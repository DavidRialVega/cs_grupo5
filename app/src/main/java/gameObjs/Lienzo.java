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

    private int width;
    private int height;
    boolean gameOver;
    boolean win;

    public Lienzo(Context context, int w, int h) {
        super(context);
        paint = new Paint();
        width = w;
        height = h;
        ball = new Ball(this.getContext(), width, height);
        jugador = new PalaJugador(this.getContext(), width, height);

        gameOver = false;
        win = false;
    }

    public void reset () {
        gameOver = false;
        win = false;
        ball = new Ball(this.getContext(), width, height);
        jugador = new PalaJugador(this.getContext(), width, height);
    }


    @Override
    public void onDraw (Canvas canvas) {
        super.onDraw(canvas);
        if (!gameOver) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.WHITE);
            canvas.drawPaint(paint);
            jugador.draw(canvas);
            ball.draw(canvas);
            paint.setTextSize((float)height/20);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setColor(Color.RED);
            canvas.drawText("Balas: " + jugador.balasRestantes(), (float)width / 2, (float)height / 15, paint);

        } else {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.WHITE);
            canvas.drawPaint(paint);
            paint.setAntiAlias(true);
            paint.setTextSize((float)height/8);
            paint.setTextAlign(Paint.Align.CENTER);
            if (win){
                paint.setColor(Color.GREEN);
                canvas.drawText("VICTORIA!", (float)width / 2, (float)height / 2, paint);
                win = false;
            } else {
                paint.setColor(Color.BLUE);
                canvas.drawText("GAME OVER...", (float)width / 2, (float)height / 2, paint);
            }
        }
    }

    public boolean isGameOver (){
        return gameOver;
    }

    public void move(){
        win = jugador.moveBullets(ball);
        boolean reset = ball.move(jugador);
        if(reset || ((jugador.balasRestantes() <= 0) && (jugador.todasBalasFuera()) )){
            gameOver = true;
        } else if (win){
            gameOver = true;
        }
    }
    public void movePlayer (int x, int y){
        jugador.move(x, y);
        Log.println(Log.WARN, "movement", x + " " + y);
    }

    public void shootBullet (int xFin, int yFin){
        if (jugador.shoot(xFin, yFin)){
            gameOver = true;
        }
    }

}
