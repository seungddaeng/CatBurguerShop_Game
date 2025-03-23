package edu.upb.lp.progra.catBurgerShop;

public class GatitoGorritoDecorator extends GatoDecorator {
    public GatitoGorritoDecorator(GatoPrincipal gatoDecorado) {
        super(gatoDecorado);
    }

    @Override
    public void venganza() {
        gatoDecorado.venganza();
        getController().tabla();
    }
}