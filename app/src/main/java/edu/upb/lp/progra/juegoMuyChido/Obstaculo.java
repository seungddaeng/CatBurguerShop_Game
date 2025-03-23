package edu.upb.lp.progra.juegoMuyChido;

import java.util.Random;

public class Obstaculo {

    private RayoRacingGame game;
    private int v = 0;
    private int h = 2;
    private BajadorDeObstaculo bajador = new BajadorDeObstaculo(this);

    public Obstaculo(RayoRacingGame game) {
        this.game = game;
    }


    public void bajar() {
        game.borrarObstaculo(v, h);
        if (v == 2) {
            Random rnd = new Random();
            if (rnd.nextBoolean()) {
                h = 1;
            } else {
                h = 2;
            }
            v = 0;
        } else {
            v++;
        }
        game.dibujarObstaculo(v, h);
    }

    public void executeLater(Runnable r, int ms) {
        game.executeLater(r, ms);
    }

    public void empezarABajar() {
        bajador.start();
    }

    public void detenerse() {
        bajador.stop();
    }
}
