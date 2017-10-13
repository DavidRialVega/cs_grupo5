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

import java.util.Timer;
import java.util.TimerTask;

import gameObjs.Lienzo;

public class GameMainActivity extends AppCompatActivity {

    Lienzo lienzo;

    boolean estaEnPausa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lienzo = new Lienzo(this);
        setContentView(lienzo);



        estaEnPausa = false;

    }

    int i = 0;

    final Handler handler = new Handler();
    Timer timer = new Timer();

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            handler.post(new Runnable() {
                public void run() {
                    try {
                        lienzo.move();
                        lienzo.invalidate();
                    } catch (Exception e) {
                        Log.e("error", e.getMessage());
                    }
                }
            });
        }
    };

    protected  void onResume()
    {
        super.onResume();


        timer.schedule(task, 0, 1);  //ejecutar en intervalo de 3 segundos.

//        while (!estaEnPausa){
//            lienzo.move();
//            lienzo.invalidate();

//        Log.d("hola", i + "");
//
//        i++;
    }


}
