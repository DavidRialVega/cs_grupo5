package gameObjs;

import android.content.Context;

public class JugadorPalaDch extends PalaGeneral{

    private int ySpeed = 2;
    public JugadorPalaDch(Context context, int posX, int posY) {
        super(context, posX, posY);
    }

    public void move (int xBall, int yBall, int widthCamp, int heightCamp){
        if (xBall > (widthCamp  / 2) + 300){ // el enemigo empieza a moverse cuando la bola pasa de mitad de campo + 300 px. Movimiento muy simple
            int y = this.getPosY() + this.getH() / 2;  // se calcula a partir del centro de la pala
            if ((y <= yBall) && (this.getPosY() + this.getH() + ySpeed <= heightCamp - 10 )  ){ //Cuando la bola esta debajo de la pala
                this.setY(this.getPosY() + ySpeed);
            } else {
                if (this.getPosY() - ySpeed  >= 10) {  //Cuando la bola esta encima de la bola
                    this.setY(this.getPosY() - ySpeed);
                }
            }

        }
    }

}
