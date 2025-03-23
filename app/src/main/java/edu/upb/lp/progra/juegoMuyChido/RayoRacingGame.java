package edu.upb.lp.progra.juegoMuyChido;

public class RayoRacingGame {
    private RayoRacingConnector connector;
    private RayoMcqueen rayo = new RayoMcqueen(this);
    private Obstaculo obs = new Obstaculo(this);
    private boolean gameOver = false;
    private boolean inicio = true;
    private int score = 0;

    public RayoRacingGame(RayoRacingConnector connector) {
        this.connector = connector;
    }

    public void clic(int vertical, int horizontal) {
        if (!gameOver) {
            if (inicio) {
                inicio = false;
                connector.dibujarJuego();
                obs.empezarABajar();
            } else {
                if (vertical == 1 && horizontal == 0) {
                    rayo.izquierda();
                } else if (vertical == 1 && horizontal == 3) {
                    rayo.derecha();
                }
            }
        } else {
            connector.reinicio();
        }
    }


    public void borrarRayo(boolean izquierda) {
        if (izquierda) {
            connector.borrarRayo(2, 1);
        } else {
            connector.borrarRayo(2, 2);
        }
    }

    public void dibujarRayo(boolean izquierda) {

        connector.dibujarRayo(izquierda);
    }

    public void borrarObstaculo(int v, int h) {
        connector.borrarObstaculo(v, h);
    }

    public void dibujarObstaculo(int v, int h) {
        int hrayo;
        if (rayo.getIzquierda()) {
            hrayo = 1;
        } else {
            hrayo = 2;
        }
        if (v == 2 && h == hrayo) {
            connector.gameOver();
            obs.detenerse();
            gameOver = true;
        } else {
            connector.dibujarObstaculo(v, h);
            incrementarScore();
        }
    }

    private void incrementarScore() {
        score++;
        connector.actualizarScore(score);
    }

    public void executeLater(Runnable r, int ms) {
        connector.executeLater(r, ms);
    }
}