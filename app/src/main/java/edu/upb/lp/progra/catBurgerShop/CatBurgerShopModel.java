package edu.upb.lp.progra.catBurgerShop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class CatBurgerShopModel {
    private int score = 0;
    private boolean gameOver = false;
    private boolean inicio = true;
    private CatBurgerShopController controller;
    private Queue<GatoPrincipal> colaDeGatos = new LinkedList<>();
    private GatoPrincipal gatoEnPantalla = null;
    private Stack<String> hamborguesaDeseada = new Stack<>();
    private Stack<String> hamborguesaConstruida = new Stack<>();

    public CatBurgerShopModel(CatBurgerShopController controller) {
        this.controller = controller;
        colaDeGatitos();
    }

    public void colaDeGatitos() {
        GatitoFuegoDecorator fuego = new GatitoFuegoDecorator(new GatoBase(controller, 1));
        Jugador jugador = new Jugador("Player", controller);
        fuego.agregarObservador(jugador);

        colaDeGatos.offer(fuego);
        colaDeGatos.offer(new GatitoGorritoDecorator(new GatoBase(controller, 2)));
        colaDeGatos.offer(new GatitoLentecitosDecorator(new GatoBase(controller, 3)));
        colaDeGatos.offer(new GatitoVerdecitoDecorator(new GatoBase(controller, 4)));
    }

    public void clic(int vertical, int horizontal) throws TeQuisistePasarDeListoYNoPudisteException {
        // Verificamos el tamaño de la hamburguesa aquí
        if (hamborguesaConstruida.size() < 10) {
            if (!gameOver) {
                if (inicio) {
                    iniciarJuego();
                    inicio = false;
                    gatoEnPantalla = colaDeGatos.poll();
                    gatoEnPantalla.empezarAMoverAIzquierda();
                } else if (vertical == 3) {
                    manejarClickIngrediente(horizontal);  // Ya no necesitas verificar el tamaño aquí
                }
            }
            if (vertical == 2 && horizontal == 5) {
                controller.ready(3, 3);
                comparashon();
                siguienteGato();
            }
        } else {
            // Si la hamburguesa es demasiado grande, lanzamos la excepción correspondiente
            throw new TeQuisistePasarDeListoYNoPudisteException ("La hamburguesa no puede ser tan grande >:[");
        }
    }


    private void manejarClickIngrediente(int horizontal) {
        // Mapa de ingredientes
        Map<Integer, String> ingredientes = new HashMap<>();
        ingredientes.put(1, "palta");
        ingredientes.put(2, "pan");
        ingredientes.put(3, "carne");
        ingredientes.put(4, "tomate");
        ingredientes.put(5, "lechuga");

        // Agregamos el ingrediente a la hamburguesa
        hamborguesaConstruida.push(ingredientes.get(horizontal));

        controller.clickIngredientes(horizontal);
        controller.executeLater(new DesclickeadorDeIngredientes(this, horizontal), 300);
    }



    public void siguienteGato() {
        gatoEnPantalla.setH(6);
        colaDeGatos.offer(gatoEnPantalla);
        gatoEnPantalla = colaDeGatos.poll();
        gatoEnPantalla.empezarAMoverAIzquierda();
    }

    public void iniciarJuego() {
        controller.dibujarJuego();
    }

    public void comparashon() {
        boolean ingredientesEstanCorrectos = true;
        while (!hamborguesaDeseada.isEmpty() && ingredientesEstanCorrectos && !hamborguesaConstruida.isEmpty()) {
            if (!hamborguesaConstruida.peek().equals(hamborguesaDeseada.peek())) {
                ingredientesEstanCorrectos = false;
                llamarVenganza(false);
            } else {
                controller.buenaHamborguesa();
                incrementarScore();
            }
            hamborguesaConstruida.pop();
            hamborguesaDeseada.pop();
        }
        hamborguesaConstruida.clear();
        hamborguesaDeseada.clear();
    }

    private void incrementarScore() {
        score++;
        controller.actualizarScore(score);
    }

    public void llamarVenganza(boolean ingredientesEstanCorrectos) {
        if (!ingredientesEstanCorrectos) {
            gatoEnPantalla.venganza();
        }
    }

    public void borrarGatito(int v, int h) {
        controller.borrarGatito(v, h);
    }

    public void dibujarGatito(int v, int h, int valor) {
        controller.dibujarGatito(v, h, valor);
        if (score < 0) {
            gameOver = true;
            gatoEnPantalla.pararGato();
            controller.gameOver();
        }
    }

    public void executeLater(Runnable r, int ms) {
        controller.executeLater(r, ms);
    }

    public void desclickearIngrediente(int horizontal) {
        controller.desclickIngredientes(horizontal);
    }

    public void hacerPedido() {
        hamborguesaDeseada = pedidoNuevo();
    }

    public Stack<String> pedidoNuevo() {
        Map<String, List<String>> opcionesHamburguesas = new HashMap<>();
        opcionesHamburguesas.put("clasica", Arrays.asList("pan", "lechuga", "carne", "tomate", "palta", "pan"));
        opcionesHamburguesas.put("vegana", Arrays.asList("lechuga", "tomate", "palta", "tomate", "lechuga"));
        opcionesHamburguesas.put("carnivora", Arrays.asList("pan", "carne", "carne", "carne", "pan"));
        opcionesHamburguesas.put("vegetariana", Arrays.asList("pan", "lechuga", "tomate", "palta", "pan"));

        // Seleccionar un pedido aleatorio
        List<String> opciones = new ArrayList<>(opcionesHamburguesas.keySet());
        String pedidoAleatorio = opciones.get(new Random().nextInt(opciones.size()));

        controller.dibujarPedido(pedidoAleatorio);

        Stack<String> pedido = new Stack<>();
        pedido.addAll(opcionesHamburguesas.get(pedidoAleatorio));

        return pedido;
    }


    public void maullar() {
        controller.maullar();
    }

    public void tabla() {
        controller.tabla();
    }

    public void quitarPuntos() {
        score--;
        controller.quitarPuntos(score);
    }

    public void limpiarHamburguesa() {
        hamborguesaConstruida.clear();
    }
}
