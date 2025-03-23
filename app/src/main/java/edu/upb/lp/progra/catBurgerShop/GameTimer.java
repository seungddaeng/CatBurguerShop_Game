package edu.upb.lp.progra.catBurgerShop;

import android.os.Handler;
import android.os.Looper;

public class GameTimer {
    private int timeLeft;
    private Runnable onTimerEnd;
    private Runnable onTick;
    private boolean running;
    private Handler handler;

    public GameTimer(int initialTime, Runnable onTimerEnd, Runnable onTick) {
        this.timeLeft = initialTime;
        this.onTimerEnd = onTimerEnd;
        this.onTick = onTick;
        this.running = false;
        this.handler = new Handler(Looper.getMainLooper()); // Usar el hilo principal
    }

    public void start() {
        running = true;
        tick();
    }

    public void stop() {
        running = false;
    }

    private void tick() {
        if (running) {
            if (timeLeft > 0) {
                timeLeft--;
                handler.post(onTick); // Ejecutar onTick en el hilo principal
                // Ejecutar el siguiente tick después de 1 segundo
                handler.postDelayed(this::tick, 1000);
            } else {
                handler.post(onTimerEnd); // Ejecutar onTimerEnd en el hilo principal
            }
        }
    }

    public int getTimeLeft() {
        return timeLeft;
    }
}