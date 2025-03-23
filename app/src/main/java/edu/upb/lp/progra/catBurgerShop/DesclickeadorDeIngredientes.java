package edu.upb.lp.progra.catBurgerShop;

public class DesclickeadorDeIngredientes implements Runnable {
    private int horizontal;
    private CatBurgerShopModel game;

    public DesclickeadorDeIngredientes(CatBurgerShopModel game, int horizontal) {
        this.game = game;
        this.horizontal = horizontal;
    }

    @Override
    public void run() {
        game.desclickearIngrediente(horizontal);
    }
}