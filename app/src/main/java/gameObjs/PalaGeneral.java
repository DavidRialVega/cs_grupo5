package gameObjs;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;

public class PalaGeneral extends View {

    private int x, y, width, height;
    private Paint paint;

    public PalaGeneral(Context context, int posX, int posY){
        super(context);

        width = 40;
        height = 200;
        x = posX;
        y = posY - width/2;
        paint = new Paint();
    }

    public int getH() {
        return height;
    }

    public int getW (){
        return width;
    }

    public int getPosX(){
        return x;
    }

    public int getPosY(){
        return y;
    }

    public void setY( int posY){
        y = posY;
    }


    public void  draw (Canvas canvas){
        super.draw(canvas);
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        RectF pala = new RectF(x, y, x + width, y + height );
        canvas.drawRect(pala, paint);
    }


}
