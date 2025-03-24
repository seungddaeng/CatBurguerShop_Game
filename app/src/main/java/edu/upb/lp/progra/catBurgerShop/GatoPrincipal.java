package edu.upb.lp.progra.catBurgerShop;

public abstract class GatoPrincipal {
    private CatBurgerShopController controller;
    private int v = 1;
    private int h = 6;
    private MovedorDeGatitos movedor;
    private int valor;

    public GatoPrincipal(CatBurgerShopController controller, int valor) {
        this.controller = controller;
        this.valor = valor;
        this.movedor = new MovedorDeGatitos(this);
    }

    public CatBurgerShopController getController() {
        return controller;
    }
    public int getValor() {
        return valor;
    }

    public void moverAIzquierda() {
        controller.borrarGatito(v, h);

        if (h >= 0) {
            h--;
            if (v == 1 && h == 3) {
                movedor.stop();
                controller.hacerPedido();
            }
        }
        controller.dibujarGatito(v, h, valor);
    }

    public void pararGato() {
        movedor.stop();
    }

    public void empezarAMoverAIzquierda() {
        movedor.start();
    }

    public void executeLater(Runnable r, int ms) {
        controller.executeLater(r, ms);
    }

    public abstract void venganza();

    public void setH(int h) {
        this.h = h;
    }

    public int getH() {
        return h;
    }

    public int getV() {
        return v;
    }

}
