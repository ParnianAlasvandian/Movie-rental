package com.example.movierental;

import java.util.ArrayList;

public class bstSelActor3 {
    String firstName ;
    int totalState3 ;


    static public ArrayList<bstSelActor3> bestSellingActorT3 = new ArrayList<>() ;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getTotalState3() {
        return totalState3;
    }

    public void setTotalState3(int totalState3) {
        this.totalState3 = totalState3;
    }

    public static ArrayList<bstSelActor3> getBestSellingActorT3() {
        return bestSellingActorT3;
    }

    public static void setBestSellingActorT3(ArrayList<bstSelActor3> bestSellingActorT3) {
        bstSelActor3.bestSellingActorT3 = bestSellingActorT3;
    }

  /////////////////////////////////


    public bstSelActor3(String firstName, int totalState3) {
        this.firstName = firstName;
        this.totalState3 = totalState3;
    }
}
