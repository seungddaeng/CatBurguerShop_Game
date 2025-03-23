package edu.upb.lp.progra.catBurgerShop;

public class Jugador implements ObservadorEmpleado{
    private String nombre;
    private CatBurgerShopController controller;

    public Jugador(String nombre, CatBurgerShopController controller) {
        this.nombre = nombre;
        this.controller = controller;
    }

    @Override
    public void actualizar(String estadoFuego) {
        controller.mostrarEstadoGatito(":\nOh no! está " + estadoFuego);
        System.out.println("💥 " + nombre + " fue notificado: GatitoFuego está " + estadoFuego);
    }
}