package edu.upb.lp.progra.catBurgerShop;

public class GatitoLentecitosDecorator extends GatoDecorator {
    public GatitoLentecitosDecorator(GatoPrincipal gatoDecorado) {
        super(gatoDecorado);
    }

    @Override
    public void venganza() {
        gatoDecorado.venganza();
        getController().maullar();
    }
}