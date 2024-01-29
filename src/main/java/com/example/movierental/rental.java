package com.example.movierental;

import java.util.ArrayList;

public class rental {
    private int request_id;    //rental_id
    private String rental_date;
    private int inventory_id;
    private int customer_id;
    private String return_date;
    private int staff_id;     // manager_id

    private String remaining_time ;

    static public ArrayList<rental> allRequest = new ArrayList<>() ;
    static public ArrayList<rental> viewActiveReqClose = new ArrayList<>() ;

    static public ArrayList<rental> custViewActiveMovie = new ArrayList<>() ;

///////////////////////////////////////////////////////////////////////


    public int getRequest_id() {return request_id;}

    public void setRequest_id(int request_id) {this.request_id = request_id;}

    public String getRental_date() {return rental_date;}

    public void setRental_date(String rental_date) {this.rental_date = rental_date;}

    public int getInventory_id() {return inventory_id;}

    public void setInventory_id(int inventory_id) {this.inventory_id = inventory_id;}

    public int getCustomer_id() {return customer_id;}

    public void setCustomer_id(int customer_id) {this.customer_id = customer_id;}

    public String getReturn_date() {return return_date;}

    public void setReturn_date(String return_date) {this.return_date = return_date;}

    public int getStaff_id() {return staff_id;}

    public void setStaff_id(int staff_id) {this.staff_id = staff_id;}

    public static ArrayList<rental> getAllRequest() {return allRequest;}

    public static void setAllRequest(ArrayList<rental> allRequest) {rental.allRequest = allRequest;}

    public static ArrayList<rental> getViewActiveReqClose() {return viewActiveReqClose;}

    public static void setViewActiveReqClose(ArrayList<rental> viewActiveReqClose) {rental.viewActiveReqClose = viewActiveReqClose;}

    public static ArrayList<rental> getCustViewActiveMovie() {return custViewActiveMovie;}

    public static void setCustViewActiveMovie(ArrayList<rental> custViewActiveMovie) {rental.custViewActiveMovie = custViewActiveMovie;}

    public String getRemaining_time() {return remaining_time;}

    public void setRemaining_time(String remaining_time) {this.remaining_time = remaining_time;}

    ////////////////////////////////////////////////////////////


    public rental(int request_id, String rental_date, int inventory_id, int customer_id, String return_date, int staff_id) {
        this.request_id = request_id;
        this.rental_date = rental_date;
        this.inventory_id = inventory_id;
        this.customer_id = customer_id;
        this.return_date = return_date;
        this.staff_id = staff_id;
    }

    public rental (int request_id, String rental_date, int inventory_id, int staff_id) {
        this.request_id = request_id;
        this.rental_date = rental_date;
        this.inventory_id = inventory_id;
        this.staff_id = staff_id;
    }

    public rental (String rental_date, String return_date,String remaining_time, int request_id) {
        this.request_id = request_id;
        this.rental_date = rental_date;
        this.return_date = return_date;
        this.remaining_time = remaining_time;
    }


}
