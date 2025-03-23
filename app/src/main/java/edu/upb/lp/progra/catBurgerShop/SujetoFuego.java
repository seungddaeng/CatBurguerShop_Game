package edu.upb.lp.progra.catBurgerShop;

public interface SujetoFuego {
    void agregarObservador(ObservadorEmpleado observador);
    void quitarObservador(ObservadorEmpleado observador);
    void notificarObservadores();
}
