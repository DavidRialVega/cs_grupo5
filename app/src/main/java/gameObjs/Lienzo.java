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
    private JugadorPalaIzq leftPlayer;
    private JugadorPalaDch rightPlayer;

    private int width, height;

    public void reset () {
        bola = new Ball(this.getContext(), width, height);
        leftPlayer = new JugadorPalaIzq(this.getContext(), 100, height/2);
        rightPlayer = new JugadorPalaDch(this.getContext(), width - 100, height/2);
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

        bola.draw(canvas);
        leftPlayer.draw(canvas);
        rightPlayer.draw(canvas);

    }

    public void move(){
        //Primero se mueven las barras y despues la pelota
        //leftPlayer.move(500, 500);
        rightPlayer.move(bola.getPosX(), bola.getPosY(), width, height);

        boolean reset = bola.move(leftPlayer, rightPlayer); //Se le pasan los jugadores para detectar las colisiones. Si se sale del campo por los lados se reinicia

        if (reset){
            reset();
        }

    }
    public void MoveLeft(int x, int y){ leftPlayer.move(x,y); }



}
