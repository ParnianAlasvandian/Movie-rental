package com.example.movierental;

import java.util.ArrayList;

public class inventory {
    int inventory_id ;
    int film_id ;
    int store_id ;
    //String last_update ;

    static public ArrayList<inventory> allInventory = new ArrayList<>() ;

////////////////////////////////////// Set & Get  //////////////////////////////////////


    public int getInventory_id() {return inventory_id;}

    public int getFilm_id() {return film_id;}

    public int getStore_id() {return store_id;}

    public static ArrayList<inventory> getAllInventory() { return allInventory;}

    public void setInventory_id(int inventory_id) {this.inventory_id = inventory_id;}

    public void setFilm_id(int film_id) {this.film_id = film_id;}

    public void setStore_id(int store_id) {this.store_id = store_id;}

    public static void setAllInventory(ArrayList<inventory> allInventory) {inventory.allInventory = allInventory; }

///////////////////////////////////////////////

    public inventory(int inventory_id, int film_id, int store_id) {
        this.inventory_id = inventory_id;
        this.film_id = film_id;
        this.store_id = store_id;
    }
}
