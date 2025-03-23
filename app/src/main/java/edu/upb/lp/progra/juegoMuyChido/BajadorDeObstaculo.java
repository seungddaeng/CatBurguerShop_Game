package edu.upb.lp.progra.juegoMuyChido;

public class BajadorDeObstaculo implements Runnable {
    private Obstaculo obs;
    private boolean running = false;

    public BajadorDeObstaculo(Obstaculo obs) {
        this.obs = obs;
    }

    public void start() {
        running = true;
        obs.executeLater(this, 50);
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        if (running) {
            obs.bajar();
            obs.executeLater(this, 400);
        }
    }
}
