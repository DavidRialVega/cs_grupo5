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

    public boolean move (Ball ball) { //Se le pasa la bola para comprobar las colisiones
        for (PalaEnemiga pala: enemyList) {
            if (pala.move(ball)) {
                return true;
            }
        }
        return false;
    }

    public void reset () { // Reinicia las posiciones de todas las palas de la lista
        int size = enemyList.size();
        enemyList = new ArrayList<>();
        for (int i =0 ; i < size; i++) {
            enemyList.add(new PalaEnemiga(context, dWidth, dHeight));
        }
    }

    public void draw (Canvas canvas){ // Dibuja todas las palas
        for (PalaEnemiga pala: enemyList) {
            pala.draw(canvas);
        }
    }

    public void add (){ //Anyade una pala nueva a la lista
        enemyList.add(new PalaEnemiga(context, dWidth, dHeight ));
    }
}
