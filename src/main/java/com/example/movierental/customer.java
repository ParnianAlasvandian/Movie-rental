package com.example.movierental;

import java.util.ArrayList;

public class customer {
    private int customer_id ;
    private String first_name ;
    private String last_name ;
    private String email ;
    private int address_id ;

    static public ArrayList<customer> allCustomer = new ArrayList<>() ;


///////////////////////////////////////// Set & Get  //////////////////////////////////////
    public void setCustomer_id(int customer_id) {this.customer_id = customer_id;}

    public void setFirst_name(String first_name) {this.first_name = first_name;}

    public void setLast_name(String last_name) {this.last_name = last_name;}

    public void setEmail(String email) {this.email = email;}

    public void setAddress_id(int address_id) {this.address_id = address_id;}

    public static void setAllCustomer(ArrayList<customer> allCustomer) {customer.allCustomer = allCustomer;}

    public int getCustomer_id() {
        return customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public int getAddress_id() {
        return address_id;
    }

    public static ArrayList<customer> getAllCustomer() {
        return allCustomer;
    }

/////////////////////////////////////////////////////////////////////////////////////

    public customer(int customer_id, String first_name, String last_name, String email, int address_id) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.address_id = address_id;
    }

}
