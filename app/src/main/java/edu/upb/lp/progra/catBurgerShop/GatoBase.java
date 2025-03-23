package edu.upb.lp.progra.catBurgerShop;

public class GatoBase extends GatoPrincipal {
    public GatoBase(CatBurgerShopController controller, int valor) {
        super(controller, valor);
    }

    @Override
    public void venganza() {
        // Comportamiento base (no hace nada)
    }
}