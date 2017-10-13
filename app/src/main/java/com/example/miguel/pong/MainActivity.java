package com.example.miguel.pong;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bStart = (Button) findViewById(R.id.bStart);
        bStart.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v){
                    Intent gameActv = new Intent(MainActivity.this, GameMainActivity.class);
                    startActivity(gameActv);
                    }
                }
        );

    }

}
