package gameObjs;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class PalaGeneral extends View {

    private int x;
    private int y;
    private int width;
    private int height;
    private Paint paint;

    public PalaGeneral(Context context){
        super(context);

        width = 40;
        height = 200;
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

    protected void setY( int posY){

        y = posY;
    }
    protected  void setX (int posX) {
        x = posX;
    }


    @Override
    public void  draw (Canvas canvas) {
        super.draw(canvas);
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        RectF pala = new RectF(x, y, x + width, y + height);
        canvas.drawRect(pala, paint);
    }

}
