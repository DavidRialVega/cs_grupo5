package gameObjs;

import android.content.Context;

public class JugadorPalaDch extends PalaGeneral{

    private int ySpeed = 1;
    public JugadorPalaDch(Context context, int posX, int posY) {
        super(context, posX, posY);
    }

    public void move (int xBall, int yBall, int widthCamp, int heightCamp){
        //No va de momento
       /* if (xBall > widthCamp / 2){ // en enemigo empieza a moverse cuando la bola pasa de mitad de campo. Movimiento muy simple
            int y = this.getPosY() + this.getH() / 2;
            if ((y < yBall) && (this.getPosY() + this.getH() + ySpeed <= heightCamp) ){
                this.setY(this.getPosY() + ySpeed);
            } else {
                if (this.getPosY() >= 0) {
                    this.setY(y - ySpeed);
                }
            }

        }*/
    }

}
