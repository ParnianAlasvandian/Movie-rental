package com.example.movierental;

import java.util.ArrayList;

public class Store {
    private int storeID ;
    private int addressID ;
    private int status ;
    private String address ;

    static public   ArrayList<Store> allStores = new ArrayList<>() ;
    static  public  ArrayList<Store> managerStores = new ArrayList<>() ;
    static  public  ArrayList<Store> managerStoresEnter = new ArrayList<>() ;
    static  public  ArrayList<Store> custStorInfo = new ArrayList<>() ;

////////////////////////////////////// Set & Get  //////////////////////////////////////


    public int getStoreID () { return storeID; }

    public void setStoreID(int storeID) { this.storeID = storeID; }

    public int getAddressID() { return addressID; }

    public void setAddressID(int addressID) { this.addressID = addressID; }

    public int getStatus() { return status; }

    public void setStatus(int status) { this.status = status; }

    public static ArrayList<Store> getAllStores() { return allStores; }

    public static void setAllStores(ArrayList<Store> allStores) { Store.allStores = allStores; }

    public static ArrayList<Store> getManagerStores() {return managerStores;}

    public static void setManagerStores(ArrayList<Store> managerStores) {Store.managerStores = managerStores;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public static ArrayList<Store> getManagerStoresEnter() {return managerStoresEnter;}

    public static void setManagerStoresEnter(ArrayList<Store> managerStoresEnter) {Store.managerStoresEnter = managerStoresEnter;}

    public static ArrayList<Store> getCustStorInfo() {return custStorInfo;}

    public static void setCustStorInfo(ArrayList<Store> custStorInfo) {Store.custStorInfo = custStorInfo;}

    ///////////////////////////////////////////////////////////////////////////////////////////////

    public Store(int storeID,int addressID, int status) {
        this.storeID = storeID;
        this.addressID = addressID;
        this.status = status ;
    }

    public Store(int storeID,int addressID) {
        this.storeID = storeID;
        this.addressID = addressID;
    }

    public Store(int storeID,int addressID, String address ) {
        this.storeID = storeID;
        this.addressID = addressID;
        this.address = address ;
    }




}
