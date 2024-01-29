package com.example.movierental;

import java.util.ArrayList;

public class film {
    private int film_id ;
    private String title ;
    private int actor_id ;
    private String nameGenre;
    private int release_year ;
    private String colLanguageName ;
    private String rentalDate;
    private int average_rating ;
    private int numberOfRents ;

    static public ArrayList<film> searchFilmGenre = new ArrayList<>() ;
    static public ArrayList<film> searchLanguage = new ArrayList<>() ;
    static public ArrayList<film> customerRentalHistory = new ArrayList<>() ;
    static public ArrayList<film> customerRentalInfo= new ArrayList<>() ;


////////////////////////////////////////////////////////////////////////////////


    public int getFilm_id() {return film_id;}

    public void setFilm_id(int film_id) {this.film_id = film_id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public int getActor_id() {return actor_id;}

    public void setActor_id(int actor_id) {this.actor_id = actor_id;}

    public static ArrayList<film> getSearchFilmGenre() {return searchFilmGenre;}

    public static void setSearchFilmGenre(ArrayList<film> searchFilmGenre) {film.searchFilmGenre = searchFilmGenre;}

    public int getRelease_year() {return release_year;}

    public void setRelease_year(int release_year) {this.release_year = release_year;}

    public String getNameGenre() {return nameGenre;}

    public void setNameGenre(String nameGenre) {this.nameGenre = nameGenre;}

    public String getColLanguageName() {return colLanguageName;}

    public void setColLanguageName(String colLanguageName) {this.colLanguageName = colLanguageName;}

    public static ArrayList<film> getSearchLanguage() {return searchLanguage;}

    public static void setSearchLanguage(ArrayList<film> searchLanguage) {film.searchLanguage = searchLanguage;}

    public String getRentalDate() {return rentalDate;}

    public void setRentalDate(String rentalDate) {this.rentalDate = rentalDate;}

    public static ArrayList<film> getCustomerRentalHistory() {return customerRentalHistory;}

    public static void setCustomerRentalHistory(ArrayList<film> customerRentalHistory) {film.customerRentalHistory = customerRentalHistory;}

    public double getAverage_rating() {return average_rating;}

    public void setAverage_rating(int average_rating) {this.average_rating = average_rating;}

    public int getNumberOfRents() {return numberOfRents;}

    public void setNumberOfRents(int numberOfRents) {this.numberOfRents = numberOfRents;}

    public static ArrayList<film> getCustomerRentalInfo() {return customerRentalInfo;}

    public static void setCustomerRentalInfo(ArrayList<film> customerRentalInfo) {film.customerRentalInfo = customerRentalInfo;}

/////////////////////////////////////////////////////////////////////////////////////////////////////////

    public film(int film_id, String title, int actor_id, String nameGenre, int release_year) {
        this.film_id = film_id;
        this.title = title;
        this.actor_id = actor_id;
        this.nameGenre = nameGenre;
        this.release_year = release_year;
    }

    public film(int film_id, String title, String colLanguageName, int release_year) {
        this.film_id = film_id;
        this.title = title;
        this.colLanguageName = colLanguageName ;
        this.release_year = release_year;
    }

    public film(String title, String rentalDate, int release_year) {
        this.title = title;
        this.rentalDate = rentalDate;
        this.release_year = release_year;
    }

    public film(String title, int numberOfRents, int average_rating) {
        this.title = title;
        this.numberOfRents = numberOfRents;
        this.average_rating = average_rating;
    }


}
