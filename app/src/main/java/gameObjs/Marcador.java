package gameObjs;

//El marcador aún no se muestra en la pantalla

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class Marcador extends View{


    private Paint paint;
    private int x, y, puntosDer, puntosIzq;

    public Marcador(Context context, int posX, int posY){
        super(context);
        x = posX;
        y = posY;
        puntosDer = 0;
        puntosIzq = 0;
    }

    public void sumarPuntos(){
        this.puntosDer =  puntosDer+1;
    }
    public void draw(Canvas canvas){
        super.draw(canvas);
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        canvas.drawText(puntosIzq + " || " +puntosDer, (float)x+10, (float)y+10, paint);
    }

}
