package com.example.movierental;

import java.util.ArrayList;

public class bstSelGenre1 {
    String genreName;
    int totalState1 ;
    //
    static public ArrayList<bstSelGenre1> bestSellingGenreT1 = new ArrayList<>() ;

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public int getTotalState1() {
        return totalState1;
    }

    public void setTotalState1(int totalState1) {
        this.totalState1 = totalState1;
    }

    public static ArrayList<bstSelGenre1> getBestSellingGenreT1() {
        return bestSellingGenreT1;
    }

    public static void setBestSellingGenreT1(ArrayList<bstSelGenre1> bestSellingGenreT1) {
        bstSelGenre1.bestSellingGenreT1 = bestSellingGenreT1;
    }

///////////////

    public bstSelGenre1(String genreName, int totalState1) {
        this.genreName = genreName;
        this.totalState1 = totalState1;
    }
}
