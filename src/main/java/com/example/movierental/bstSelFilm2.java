package com.example.movierental;

import java.util.ArrayList;

public class bstSelFilm2 {
    String title ;
    int totalState2 ;
    //
    static public ArrayList<bstSelFilm2> bestSellingFilmT2 = new ArrayList<>() ;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalState2() {
        return totalState2;
    }

    public void setTotalState2(int totalState2) {
        this.totalState2 = totalState2;
    }

    public static ArrayList<bstSelFilm2> getBestSellingFilmT2() {
        return bestSellingFilmT2;
    }

    public static void setBestSellingFilmT2(ArrayList<bstSelFilm2> bestSellingFilmT2) {
        bstSelFilm2.bestSellingFilmT2 = bestSellingFilmT2;
    }

/////////////////////////////


    public bstSelFilm2(String title, int totalState2) {
        this.title = title;
        this.totalState2 = totalState2;
    }
}
