package com.example.movierental;

import java.util.ArrayList;

public class filmCategory {
    private String category_name ;
    private String film_title ;

    static public ArrayList<filmCategory> filmCat= new ArrayList<>() ;

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getFilm_title() {
        return film_title;
    }

    public void setFilm_title(String film_title) {
        this.film_title = film_title;
    }

    public static ArrayList<filmCategory> getFilmCat() {
        return filmCat;
    }

    public static void setFilmCat(ArrayList<filmCategory> filmCat) {
        filmCategory.filmCat = filmCat;
    }

 //////////////////


    public filmCategory(String category_name, String film_title) {
        this.category_name = category_name;
        this.film_title = film_title;
    }
}
