package com.example.movierental;

import java.util.ArrayList;

public class Store {
    private int storeID ;
    private int addressID ;
    private int status ;

    static public ArrayList<Store> allStores = new ArrayList<>() ;

////////////////////////////////////// Set & Get  //////////////////////////////////////


    public int getStoreID () { return storeID; }

    public void setStoreID(int storeID) { this.storeID = storeID; }

    public int getAddressID() { return addressID; }

    public void setAddressID(int addressID) { this.addressID = addressID; }

    public int getStatus() { return status; }

    public void setStatus(int status) { this.status = status; }

    public static ArrayList<Store> getAllStores() { return allStores; }

    public static void setAllStores(ArrayList<Store> allStores) { Store.allStores = allStores; }

///////////////////////////////////////////////////////////////////////////////////////////////

    public Store(int storeID,int addressID, int status) {
        this.storeID = storeID;
        this.addressID = addressID;
        this.status = status ;
    }
}
