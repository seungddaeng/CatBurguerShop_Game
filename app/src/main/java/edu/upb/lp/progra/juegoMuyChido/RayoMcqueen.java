package edu.upb.lp.progra.juegoMuyChido;


public class RayoMcqueen {
    private boolean izquierda = true;
    private RayoRacingConnector connector;
    private RayoRacingGame game;

    public RayoMcqueen(RayoRacingGame game) {
        this.game = game;
    }

    public void izquierda() {
        if (!izquierda) {
            game.borrarRayo(izquierda);
            izquierda = !izquierda;
            game.dibujarRayo(izquierda);
        }
    }

    public void derecha() {
        if (izquierda) {
            game.borrarRayo(izquierda);
            izquierda = !izquierda;
            game.dibujarRayo(izquierda);
        }
    }

    public boolean getIzquierda() {
        return izquierda;
    }
}