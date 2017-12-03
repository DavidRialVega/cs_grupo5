package com.example.miguel.pong;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.support.v4.view.MotionEventCompat;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import gameObjs.Lienzo;

public class GameMainActivity extends AppCompatActivity {

    private Lienzo lienzo;
    private boolean estaEnPausa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point ();
        display.getSize(size);

        lienzo = new Lienzo(this, size.x, size.y);
        setContentView(lienzo);



        estaEnPausa = false;

    }


    // Esta funcion hace que cada x tiempo se ejecuten los metodos move e invalidate del lienzo. Invalidate fuerza que la pantalla se repinte
    final Handler handler = new Handler();
    Timer timer = new Timer();

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            handler.post(new Runnable() {
                public void run() {
                    if (!estaEnPausa) {
                        try{
                            lienzo.move();
                            lienzo.invalidate();
                        } catch (Exception e) {
                            Log.e("error", e.getMessage());
                        }
                    }
                }
            });
        }
    };


    public boolean onTouchEvent(MotionEvent evento){
        int action = evento.getAction();
        int y =(int)evento.getY();
        int x = (int)evento.getX();
        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                break;
            case (MotionEvent.ACTION_MOVE):
                lienzo.movePlayer(x, y);
                break;
            case (MotionEvent.ACTION_UP):
                break;
        }
        
        return false;
    }
    protected  void onResume()
    {
        super.onResume();

        timer.schedule(task, 0, 2);  //ejecutar en intervalo de 0.002 segundos
    }


}
