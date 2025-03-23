package edu.upb.lp.progra.catBurgerShop;

import java.util.Stack;

public class Hamborguesa {

    private final Stack<String> ingredientes;
    private CatBurgerShopModel game;

    private Stack<String> h = new Stack<>();
    private String imagen;

    public Hamborguesa(String imagen, Stack<String> ingredientes) {
        this.imagen = imagen;
        this.ingredientes = ingredientes;
    }

    public void hacerHamburguesa(){

    }

}
