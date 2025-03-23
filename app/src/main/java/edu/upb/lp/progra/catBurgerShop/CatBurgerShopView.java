package edu.upb.lp.progra.catBurgerShop;

import android.content.Context;
import android.content.Intent;

import edu.upb.lp.androidInternalFiles.StartActivity;
import edu.upb.lp.progra.adapterFiles.AndroidLibrary;
import edu.upb.lp.progra.adapterFiles.AppConnector;

public class CatBurgerShopView implements AppConnector {
    private AndroidLibrary library;
    private CatBurgerShopController controller;

    private String mensajeEstado = "";


    public void mostrarEstadoGatito(String estado) {
        String[] partes = estado.split("", 2);
        String linea1 = partes.length > 0 ? partes[0] + "" : "";
        String linea2 = partes.length > 1 ? partes[1] : "";


        library.setTextOnCell(0, 1, linea1);
        library.setTextOnCell(0, 2, linea2);


        executeLater(() -> {
            library.setTextOnCell(0, 1, "");
            library.setTextOnCell(0, 2, "");
            mensajeEstado = "";
        }, 2000);
    }

    public CatBurgerShopView(AndroidLibrary library) {
        this.library = library;
        this.controller = new CatBurgerShopController(this);
    }

    @Override
    public void onButtonPressed(String name) {
        // No se usa en este juego
    }

    @Override
    public void onCellPressed(int vertical, int horizontal) {
        if (controller.isGameOver()) {
            // Si el juego ha terminado, reiniciar al hacer clic en cualquier parte
            controller.reiniciarJuego();
        } else {
            controller.handleCellClick(vertical, horizontal);
        }
    }

    @Override
    public void initialiseInterface() {
        library.configureScreen(1, 1, 0, 0, false, 0);
        library.setImageOnCell(0, 0, "catburgershop");
    }

    public void dibujarJuego() {
        library.configureScreen(4, 7, 0, 0, false, 0);
        for (int v = 0; v < 4; v++) {
            for (int h = 0; h < 7; h++) {
                library.setImageOnCell(v, h, "f" + v + h);
            }
        }
        library.setTextOnCell(0, 0, "Score: 0");
        controller.getModel().startTimer();
    }

    public void clickIngredientes(int horizontal) {
        library.setImageOnCell(3, horizontal, "p3" + horizontal);
    }

    public void desclickIngredientes(int horizontal) {
        if (horizontal == 1) {
            library.setImageOnCell(3, 1, "f31");
        } else if (horizontal == 2) {
            library.setImageOnCell(3, 2, "f32");
        } else if (horizontal == 3) {
            library.setImageOnCell(3, 3, "f33");
        } else if (horizontal == 4) {
            library.setImageOnCell(3, 4, "f34");
        } else if (horizontal == 5) {
            library.setImageOnCell(3, 5, "f35");
        }
    }

    public void borrarGatito(int v, int h) {
        library.setImageOnCell(v, h, "f" + v + h);
    }

    public void ready(int v, int h) {
        library.setImageOnCell(2, h, "preparing");
        controller.comparashon(); // El controlador lo maneja
    }

    public void dibujarGatito(int v, int h, int valor) {
        if (valor == 1) {
            library.setImageOnCell(v, h, "cat13");
        } else if (valor == 2) {
            library.setImageOnCell(v, h, "cat14");
        } else if (valor == 3) {
            library.setImageOnCell(v, h, "cat15");
        } else {
            library.setImageOnCell(v, h, "cat12");
        }
    }

    public void executeLater(Runnable r, int ms) {
        library.executeLater(r, ms);
    }

    public void malaOrden() {
        library.showTemporaryMessage("Es muy grande:(");
    }

    public void maullar() {
        library.showTemporaryMessage("Esa no es m hambourguesa >:[");
    }

    public void buenaHamborguesa() {
        library.showTemporaryMessage("Gracias :D");
    }

    public void dibujarPedido(String pedido) {
        library.setImageOnCell(0, 3, pedido);
    }

    public void actualizarScore(int score) {
        library.setTextOnCell(0, 0, "Score:" + score);
    }

    public void tabla() {
        for (int h = 1; h <= 5; h++) {
            library.setImageOnCell(3, h, "s" + 3 + h);
        }
    }

    public void quitarPuntos(int score) {
        library.setTextOnCell(0, 0, "Score:" + score);
    }

    public void gameOver() {
        // Configurar la pantalla de "gameover"
        library.configureScreen(1, 1, 0, 0, false, 0);
        library.setImageOnCell(0, 0, "gameover");

        // Hacer que la celda de "gameover" sea clickeable
        library.setOnCellClickListener(0, 0, () -> {
            // Ir a StartActivity
            Context context = library.getContext();
            Intent intent = new Intent(context, StartActivity.class);
            context.startActivity(intent);
        });
    }

    public void reinicio() {
        // Reiniciar la interfaz de usuario
        library.configureScreen(1, 1, 0, 0, false, 0);
        library.setImageOnCell(0, 0, "catburgershop");

        // No llamar a reiniciarJuego() aquí
    }
    public void actualizarTiempo(int tiempo) {
        library.setTextOnCell(0, 1, "Time: " + tiempo);
    }
    public Context getContext() {
        return library.getContext();
    }
    public CatBurgerShopController getController() {
        return controller;
    }
}
