package edu.upb.lp.progra.catBurgerShop;

public class GameTimer {
    private int timeLeft;
    private Runnable onTimerEnd;
    private Runnable onTick;
    private boolean running;

    public GameTimer(int initialTime, Runnable onTimerEnd, Runnable onTick) {
        this.timeLeft = initialTime;
        this.onTimerEnd = onTimerEnd;
        this.onTick = onTick;
        this.running = false;
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
                onTick.run();
                // Ejecutar el siguiente tick después de 1 segundo
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                tick();
                            }
                        },
                        1000
                );
            } else {
                onTimerEnd.run();
            }
        }
    }

    public int getTimeLeft() {
        return timeLeft;
    }
}