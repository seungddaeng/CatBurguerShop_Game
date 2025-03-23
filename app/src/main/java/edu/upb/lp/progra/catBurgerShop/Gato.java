package edu.upb.lp.progra.catBurgerShop;//package edu.upb.lp.progra.catBurgerShop;
//
//public abstract class Gato {
//    protected CatBurgerShopModel game;
//    protected int v = 1;
//    protected int h = 6;
//    protected MovedorDeGatitos movedor = new MovedorDeGatitos(this);
//    protected int valor;
//
//    public Gato(CatBurgerShopModel game, int valor) {
//        this.game = game;
//        this.valor = valor;
//    }
//
//    public abstract void venganza();
//
//    public void moverAIzquierda() {
//        game.dibujarGatito(v, h, valor);
//        game.borrarGatito(v, h);
//        if (h >= 0) {
//            h--;
//            if (v == 1 && h == 3) {
//                movedor.stop();
//                game.hacerPedido();
//            }
//        }
//        game.dibujarGatito(v, h, valor);
//    }
//
//    public void pararGato() {
//        movedor.stop();
//    }
//
//    public void empezarAMoverAIzquierda() {
//        movedor.start();
//    }
//
//    public void executeLater(Runnable r, int ms) {
//        game.executeLater(r, ms);
//    }
//
//    public void setH(int h) {
//        this.h = h;
//    }
//}