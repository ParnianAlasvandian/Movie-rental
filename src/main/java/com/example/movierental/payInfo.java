package com.example.movierental;

import java.util.ArrayList;

public class payInfo {

    int customer_id;
    String first_name;
    String last_name;
    int address_id ;
    int payment_id;
    int rental_id;
    int amount;
    int film_id ;
    int store_id ;
    int staff_id;
    String payment_date ;

    static public ArrayList<payInfo> paymentINFO = new ArrayList<>() ;
    static public ArrayList<payInfo> customerPaymentINFO = new ArrayList<>() ;


//////////////////////////////////////////////////////////////////


    public int getCustomer_id() {return customer_id;}

    public void setCustomer_id(int customer_id) {this.customer_id = customer_id;}

    public String getFirst_name() {return first_name;}

    public void setFirst_name(String first_name) {this.first_name = first_name;}

    public String getLast_name() {return last_name;}

    public void setLast_name(String last_name) {this.last_name = last_name;}

    public int getAddress_id() {return address_id;}

    public void setAddress_id(int address_id) {this.address_id = address_id;}

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getRental_id() {
        return rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public static ArrayList<payInfo> getPaymentINFO() {return paymentINFO;}

    public static void setPaymentINFO(ArrayList<payInfo> paymentINFO) {payInfo.paymentINFO = paymentINFO;}

    public String getPayment_date() {return payment_date;}

    public void setPayment_date(String payment_date) {this.payment_date = payment_date;}

    public static ArrayList<payInfo> getCustomerPaymentINFO() {return customerPaymentINFO;}

    public static void setCustomerPaymentINFO(ArrayList<payInfo> customerPaymentINFO) {payInfo.customerPaymentINFO = customerPaymentINFO;}

////////////////////////////////////////


    public payInfo(int customer_id, String first_name, String last_name, int address_id, int payment_id, int rental_id, int amount, int film_id, int store_id, int staff_id) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address_id = address_id;
        this.payment_id = payment_id;
        this.rental_id = rental_id;
        this.amount = amount;
        this.film_id = film_id;
        this.store_id = store_id;
        this.staff_id = staff_id;
    }


    public payInfo(int customer_id, int payment_id , int  staff_id, int rental_id, String payment_date){
        this.customer_id = customer_id;
        this.payment_id = payment_id;
        this.staff_id = staff_id;
        this.rental_id = rental_id;
        this.payment_date = payment_date ;

    }


}
