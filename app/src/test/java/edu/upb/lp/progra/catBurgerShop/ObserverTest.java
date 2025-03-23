package edu.upb.lp.progra.catBurgerShop;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class ObserverTest {

    class SujetoFuegoDummy implements SujetoFuego {
        private List<ObservadorEmpleado> observadores = new ArrayList<>();
        private String estado;

        @Override
        public void agregarObservador(ObservadorEmpleado o) {
            observadores.add(o);
        }

        @Override
        public void quitarObservador(ObservadorEmpleado observador) {
            observadores.remove(observador);
        }

        @Override
        public void notificarObservadores() {
            for (ObservadorEmpleado o : observadores) {
                o.actualizar("Estado actual: " + estado);
            }
        }

        public void setEstado(String estado) {
            this.estado = estado;
            notificarObservadores();
        }
    }

    class ObservadorEmpleadoDummy implements ObservadorEmpleado {
        private String ultimaNotificacion;

        public ObservadorEmpleadoDummy(String nombre) {}

        @Override
        public void actualizar(String mensaje) {
            ultimaNotificacion = mensaje;
        }

        public String getUltimaNotificacion() {
            return ultimaNotificacion;
        }
    }

    @Test
    public void testNotificacionObservadores() {
        SujetoFuegoDummy gatitoFuego = new SujetoFuegoDummy();
        ObservadorEmpleadoDummy empleado = new ObservadorEmpleadoDummy("GatitoFuego");

        gatitoFuego.agregarObservador(empleado);
        gatitoFuego.setEstado("Irritado");

        assertEquals("Estado actual: Irritado", empleado.getUltimaNotificacion());
    }
}