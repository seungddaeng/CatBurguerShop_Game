package edu.upb.lp.progra.catBurgerShop;
import java.util.ArrayList;
import java.util.List;

public class GatitoFuegoDecorator extends GatoDecorator implements SujetoFuego {
    private int fuegoLevel = 0;
    private List<ObservadorEmpleado> observadores = new ArrayList<>();

    public GatitoFuegoDecorator(GatoPrincipal gatoDecorado) {
        super(gatoDecorado);
    }

    @Override
    public void venganza() {
        gatoDecorado.venganza();
        getController().maullar();
        aumentarFuego(); //aumento de fuego
    }

    public void aumentarFuego() {
        notificarObservadores();
    }

    public String getEstadoFuego() {
        if (fuegoLevel == 1) {
            return "";
        }
        return "Irritado 😾";
    }

    @Override
    public void agregarObservador(ObservadorEmpleado observador) {
        observadores.add(observador);
    }

    @Override
    public void quitarObservador(ObservadorEmpleado observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        String estado = getEstadoFuego();
        for (ObservadorEmpleado o : observadores) {
            o.actualizar(estado);
        }
    }
}