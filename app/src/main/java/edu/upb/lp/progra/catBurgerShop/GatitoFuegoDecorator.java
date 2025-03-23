package edu.upb.lp.progra.catBurgerShop;

public class GatitoFuegoDecorator extends GatoDecorator {
    public GatitoFuegoDecorator(GatoPrincipal gatoDecorado) {
        super(gatoDecorado);
    }

    @Override
    public void venganza() {
        gatoDecorado.venganza();
        getController().maullar();
    }
}