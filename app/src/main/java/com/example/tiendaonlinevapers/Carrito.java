package com.example.tiendaonlinevapers;

import java.util.ArrayList;

public class Carrito {

    //POJO
    public static ArrayList<Item>lista = new ArrayList<>();

    public ArrayList<Item> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Item> lista) {
        this.lista = lista;
    }

    public static void anyadir(Item item){lista.add(item);}

    public static void eliminar(Item item){
        for (Item i: lista) {
            lista.remove(i);
        }
    }
}
