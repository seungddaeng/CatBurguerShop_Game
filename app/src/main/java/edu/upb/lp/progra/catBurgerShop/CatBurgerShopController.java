package edu.upb.lp.progra.catBurgerShop;

import android.os.Handler;
import android.os.Looper;

public class CatBurgerShopController {
    private CatBurgerShopView view;
    private CatBurgerShopModel model;
    private final Handler handler = new Handler(Looper.getMainLooper());
    public void mostrarEstadoGatito(String estado) {
        view.mostrarEstadoGatito(estado);
    }

    public CatBurgerShopController(CatBurgerShopView view) {
        this.view = view;
        this.model = new CatBurgerShopModel(this);
    }
    public void handleCellClick(int vertical, int horizontal) {
        try {
            model.clic(vertical, horizontal);
        } catch (TeQuisistePasarDeListoYNoPudisteException e) {
            view.malaOrden();
            model.limpiarHamburguesa();
        }
    }
    public void reiniciarJuego() {
        model = new CatBurgerShopModel(this);
        view.reinicio();
    }

    //metodos de model
    public CatBurgerShopModel getModel() {
        return model;
    }
    public CatBurgerShopView getView() {
        return view;
    }
    public void comparashon() {
        model.comparashon();
    }
    public void actualizarTiempo(int tiempo) {
        view.actualizarTiempo(tiempo);
    }

    public void quitarPuntos(){
        model.quitarPuntos();
    }

    public boolean isGameOver() {
        return model.isGameOver();
    }

    //metodos de view

    public void ready(int v, int h) {
        view.ready(v,h);
    }

    public void clickIngredientes(int horizontal) {
        view.clickIngredientes(horizontal);
    }

    public void executeLater(Runnable r, int ms) {
        view.executeLater(r,ms);
    }

    public void dibujarJuego() {
        view.dibujarJuego();
    }

    public void buenaHamborguesa() {
        view.buenaHamborguesa();
    }

    public void actualizarScore(int score) {
        view.actualizarScore(score);
    }

    public void borrarGatito(int v, int h) {
        view.borrarGatito(v,h);
    }

    public void dibujarGatito(int v, int h, int valor) {
        view.dibujarGatito(v,h,valor);
    }

    public void gameOver() {
        handler.post(() -> view.gameOver());
    }
    public void desclickIngredientes(int horizontal) {
        view.desclickIngredientes(horizontal);
    }

    public void dibujarPedido(String pedidoAleatorio) {
        view.dibujarPedido(pedidoAleatorio);
    }

    public void maullar() {
        view.maullar();
    }

    public void tabla() {
        view.tabla();
    }

    public void quitarPuntos(int score) {
        view.quitarPuntos(score);
    }

    public void hacerPedido() {
        model.hacerPedido();
    }
}
