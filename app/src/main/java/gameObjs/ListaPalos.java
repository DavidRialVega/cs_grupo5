package gameObjs;

import android.content.Context;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

public class ListaPalos{
    private List<PalaEnemiga> enemyList;
    private Context context;
    private int dWidth, dHeight;

    public ListaPalos (Context context, int width, int height){
        dWidth = width;
        dHeight = height;
        this.context = context;
        enemyList = new ArrayList<>();
    }

    public void move (Ball ball) { //Se le pasa la bola para comprobar las colisiones
        for (PalaEnemiga pala: enemyList) {
            pala.move(ball);
        }
    }

    public void draw (Canvas canvas){
        for (PalaEnemiga pala: enemyList) {
            pala.draw(canvas);
        }
    }

    public void add (){
        enemyList.add(new PalaEnemiga(context, dWidth, dHeight ));
    }
}
