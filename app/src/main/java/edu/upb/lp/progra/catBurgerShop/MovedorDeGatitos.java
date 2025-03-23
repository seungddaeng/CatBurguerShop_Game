package edu.upb.lp.progra.catBurgerShop;

public class MovedorDeGatitos implements Runnable {
    private GatoPrincipal gatoPrincipal;
    private boolean running = false;

    public MovedorDeGatitos(GatoPrincipal gatoPrincipal) {
        this.gatoPrincipal = gatoPrincipal;
    }

    public void start() {
        running = true;
        gatoPrincipal.executeLater(this, 1500);
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        if (running) {
            gatoPrincipal.moverAIzquierda();
            gatoPrincipal.executeLater(this, 500);
        }
    }
}