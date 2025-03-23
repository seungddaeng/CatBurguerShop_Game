package edu.upb.lp.progra.juegoMuyChido;

import edu.upb.lp.progra.adapterFiles.AndroidLibrary;
import edu.upb.lp.progra.adapterFiles.AppConnector;

public class RayoRacingConnector implements AppConnector {
    private AndroidLibrary library;
    private RayoRacingGame game = new RayoRacingGame(this);

    public RayoRacingConnector(AndroidLibrary library) {
        this.library = library;
    }

    @Override
    public void onButtonPressed(String name) {

    }

    @Override
    public void onCellPressed(int vertical, int horizontal) {
        game.clic(vertical, horizontal);
    }

    @Override
    public void initialiseInterface() {

        library.configureScreen(1, 1, 0, 0, false, 0);
        library.setImageOnCell(0, 0, "rayoracing");
    }


    public void dibujarJuego() {
        library.configureScreen(3, 4, 0, 0, false, 0);
        for (int v = 0; v < 3; v++) {
            for (int h = 0; h < 4; h++) {
                library.setImageOnCell(v, h, "r" + v + h);
            }
        }
        library.setImageOnCell(2, 1, "rayoizquierda");
        library.setTextOnCell(0, 0, "Score: 0");
    }

    public void borrarRayo(int v, int h) {
        library.setImageOnCell(v, h, "r" + v + h);
    }

    public void dibujarRayo(boolean izquierda) {
        if (izquierda) {
            library.setImageOnCell(2, 1, "rayoizquierda");
        } else if (!izquierda) {
            library.setImageOnCell(2, 2, "rayoderecha");
        }
    }

    public void borrarObstaculo(int v, int h) {
        library.setImageOnCell(v, h, "r" + v + h);
    }

    public void dibujarObstaculo(int v, int h) {
        if (v == 0 && h == 1) {
            library.setImageOnCell(v, h, "roca01");
        } else if (v == 0 && h == 2) {
            library.setImageOnCell(v, h, "roca02");
        } else if (v == 1 && h == 1) {
            library.setImageOnCell(v, h, "roca11");
        } else if (v == 1 && h == 2) {
            library.setImageOnCell(v, h, "roca12");
        } else if (v == 2 && h == 1) {
            library.setImageOnCell(v, h, "roca21");
        } else if (v == 2 && h == 2) {
            library.setImageOnCell(v, h, "roca22");
        }
    }

    public void executeLater(Runnable r, int ms) {
        library.executeLater(r, ms);
    }

    public void gameOver() {
        library.configureScreen(1, 1, 0, 0, false, 0);
        library.setImageOnCell(0, 0, "francesco");
    }

    public void reinicio() {
        game = new RayoRacingGame(this);
       // initialiseInterface();
    }

    public void actualizarScore(int score) {
        library.setTextOnCell(0, 0, "Score:" + score);
    }
}