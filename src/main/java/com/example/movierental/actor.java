package com.example.movierental;

import java.util.ArrayList;

public class actor {
    private String first_name ;
    private String last_name ;
    private int film_id ;
    private  String title ;
    static public ArrayList<actor> allActor = new ArrayList<>() ;


/////////////////////// SET & GET ////////////////////////////////
    public String getFirst_name() {return first_name;}

    public void setFirst_name(String first_name) {this.first_name = first_name;}

    public String getLast_name() { return last_name;}

    public void setLast_name(String last_name) {this.last_name = last_name;}

    public static ArrayList<actor> getAllActor() {return allActor;}

    public static void setAllActor(ArrayList<actor> allActor) {actor.allActor = allActor;}

    public int getFilm_id() {return film_id;}

    public void setFilm_id(int film_id) {this.film_id = film_id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

//////////////////////////////////////////////////////////////


    public actor(String first_name, String last_name, int film_id, String title) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.film_id = film_id;
        this.title = title;
    }
}
