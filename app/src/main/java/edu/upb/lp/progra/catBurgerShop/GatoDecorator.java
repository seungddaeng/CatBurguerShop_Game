package edu.upb.lp.progra.catBurgerShop;

public abstract class GatoDecorator extends GatoPrincipal {
    protected GatoPrincipal gatoDecorado;

    public GatoDecorator(GatoPrincipal gatoDecorado) {
        super(gatoDecorado.getController(), gatoDecorado.getValor());
        this.gatoDecorado = gatoDecorado;
    }

    @Override
    public void moverAIzquierda() {
        gatoDecorado.moverAIzquierda();
    }

    @Override
    public void pararGato() {
        gatoDecorado.pararGato();
    }

    @Override
    public void empezarAMoverAIzquierda() {
        gatoDecorado.empezarAMoverAIzquierda();
    }

    @Override
    public void executeLater(Runnable r, int ms) {
        gatoDecorado.executeLater(r, ms);
    }

    @Override
    public void setH(int h) {
        gatoDecorado.setH(h);
    }

    @Override
    public abstract void venganza();
}