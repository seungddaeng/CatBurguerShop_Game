package edu.upb.lp.progra.catBurgerShop;

public class GatitoVerdecitoDecorator extends GatoDecorator {
    public GatitoVerdecitoDecorator(GatoPrincipal gatoDecorado) {
        super(gatoDecorado);
    }

    @Override
    public void venganza() {
        gatoDecorado.venganza();
        getController().quitarPuntos();
    }
}