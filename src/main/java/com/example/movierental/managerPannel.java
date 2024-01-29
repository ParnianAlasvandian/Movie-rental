package com.example.movierental;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.movierental.Store.*;
import static com.example.movierental.bstSelActor3.bestSellingActorT3;
import static com.example.movierental.bstSelFilm2.bestSellingFilmT2;
import static com.example.movierental.bstSelGenre1.bestSellingGenreT1;
import static com.example.movierental.customer.allCustomer;
import static com.example.movierental.filmCategory.filmCat;
import static com.example.movierental.inventory.allInventory;
import static com.example.movierental.payInfo.paymentINFO;
import static com.example.movierental.rental.allRequest;

public class managerPannel {

    @FXML
    private Button btn_activeRentlInfo;

    @FXML
    private Button btn_bestSel;

    @FXML
    private Button btn_checkCust;

    @FXML
    private Button btn_custInfo;

    @FXML
    private Button btn_edit;

    @FXML
    private Button btn_logout;

    @FXML
    private Button btn_peyment;

    @FXML
    private Button btn_registering;

    @FXML
    private Button btn_rentlInf;

    @FXML
    private Button btn_serach;

    @FXML
    private Button btn_view;

    @FXML
    private Label lbl1;

    @FXML
    private Rectangle rectrangle;

    @FXML
    void click_activeRentlInfo(MouseEvent event) throws IOException {
        //در اری لیست تمامی استورهای موجود را می آوریم
        MySQLConnection sql2 = new MySQLConnection() ;
        String s2 = String.format("select inventory_id, film_id,store_id\n" +
                "  from inventory\n" +
                "  where inventory_id not in (select inventory_id from rental)  and store_id = %s ",HelloApplication.storeID.get(0)) ;

        ResultSet res2 = sql2.ExecuteQuery(s2);

        if (res2==null)
            System.out.println("-Error !");
        else
            while (true)
            {
                try {
                    if (!res2.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    allInventory.add(new inventory(res2.getInt("inventory_id"),res2.getInt("film_id"),res2.getInt("store_id"))) ;
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }

        ////
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("activeRentlInfoPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void click_bestSel(MouseEvent event) throws IOException {
        // table 1
        MySQLConnection sql2 = new MySQLConnection() ;
        String s2 = String.format("SELECT c.name, COUNT(*) AS total_sales \n" +
                "                FROM film f \n" +
                "                JOIN film_category fc ON f.film_id = fc.film_id \n" +
                "                JOIN category c ON fc.category_id = c.category_id \n" +
                "                JOIN inventory i ON f.film_id = i.film_id \n" +
                "                JOIN rental r ON i.inventory_id = r.inventory_id \n" +
                "                where  staff_id = %s and store_id = %s \n" +
                "                GROUP BY c.category_id \n" +
                "                ORDER BY total_sales desc ",HelloApplication.id.get(0),HelloApplication.storeID.get(0)) ;

        ResultSet res2 = sql2.ExecuteQuery(s2);

        if (res2==null)
            System.out.println("-Error !");
        else
            while (true)
            {
                try {
                    if (!res2.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    bestSellingGenreT1.add(new bstSelGenre1(res2.getString("name"),res2.getInt("total_sales"))) ;
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }

            /// table 2

        MySQLConnection sql3 = new MySQLConnection() ;
        String s3 = String.format("SELECT f.title, COUNT(*) AS total_sales \n" +
                "                FROM film f \n" +
                "                JOIN inventory i ON f.film_id = i.film_id \n" +
                "                JOIN rental r ON i.inventory_id = r.inventory_id \n" +
                "                where  staff_id = %s and store_id = %s \n" +
                "                GROUP BY f.film_id \n" +
                "                ORDER BY total_sales DESC ",HelloApplication.id.get(0),HelloApplication.storeID.get(0)) ;

        ResultSet res3 = sql3.ExecuteQuery(s3);

        if (res3==null)
            System.out.println("-Error !");
        else
            while (true)
            {
                try {
                    if (!res3.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    bestSellingFilmT2.add(new bstSelFilm2(res3.getString("title"),res3.getInt("total_sales"))) ;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // table 3
        MySQLConnection sql4 = new MySQLConnection() ;
        String s4 = String.format("SELECT a.first_name , COUNT(*) AS total_sales \n" +
                "                FROM actor a \n" +
                "                JOIN film_actor fa ON a.actor_id = fa.actor_id \n" +
                "                JOIN film f ON fa.film_id = f.film_id \n" +
                "                JOIN inventory i ON f.film_id = i.film_id \n" +
                "                JOIN rental r ON i.inventory_id = r.inventory_id \n" +
                "\t\t\t\twhere  staff_id = %s and store_id = %s \n" +
                "                GROUP BY a.actor_id \n" +
                "                ORDER BY total_sales DESC",HelloApplication.id.get(0),HelloApplication.storeID.get(0)) ;

        ResultSet res4 = sql4.ExecuteQuery(s4);

        if (res4==null)
            System.out.println("-Error !");
        else
            while (true)
            {
                try {
                    if (!res4.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    bestSellingActorT3.add(new bstSelActor3(res4.getString("first_name"),res4.getInt("total_sales"))) ;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        ////////////////////////
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("managerBestSelPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void click_checkCust(MouseEvent event) throws IOException {
        MySQLConnection sql2 = new MySQLConnection() ;
        String s2 = String.format("select request_id, rental_date, inventory_id, customer_id, return_date, staff_id\n" +
                "  from reservation\n" +
                "  where staff_id = %s", HelloApplication.id.get(0)) ;
        ResultSet res2 = sql2.ExecuteQuery(s2);


        if (res2==null)
            System.out.println("-Error !");
        else
            while (true)
            {
                try {
                    if (!res2.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    allRequest.add(new rental(res2.getInt("request_id"),res2.getString("rental_date"),res2.getInt("inventory_id"),res2.getInt("customer_id"),res2.getString("return_date"),res2.getInt("staff_id") )  ) ;
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }

        ////
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("requestPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void click_custInfo(MouseEvent event) throws IOException {
        //در اری لیست تمامی استورهای موجود را می آوریم
        MySQLConnection sql2 = new MySQLConnection() ;
        String s2 = String.format("select customer_id, first_name, last_name, email, address_id\n" +
                "  from customer join (rental join inventory using( inventory_id) ) using (customer_id)\n" +
                "  where store_id = %s", HelloApplication.storeID.get(0)) ;
        ResultSet res2 = sql2.ExecuteQuery(s2);


        if (res2==null)
            System.out.println("-Error !");
        else
            while (true)
            {
                try {
                    if (!res2.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    allCustomer.add(new customer(res2.getInt("customer_id"),res2.getString("first_name"),res2.getString("last_name"),res2.getString("email"),res2.getInt("address_id"))) ;
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }

            ////
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("custInfoPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void click_edit(MouseEvent event) throws IOException {
        //در اری لیست تمامی استورهای این کاربر را می آوریم
        MySQLConnection sql2 = new MySQLConnection() ;
        String s2 = String.format("SELECT store_id,address_id FROM store natural join storeManagement  where manager_id = %s and store_id = %s", HelloApplication.id.get(0), HelloApplication.storeID.get(0)) ;
        ResultSet res2 = sql2.ExecuteQuery(s2);

        if (res2==null)
            System.out.println("-Error !");
        else
            while (true)
            {
                try {
                    if (!res2.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    managerStoresEnter.add(new Store(res2.getInt("store_id"),res2.getInt("address_id"))) ;
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }



        //
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("editInformationPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void click_peyment(MouseEvent event) throws IOException {
        MySQLConnection sql2 = new MySQLConnection() ;
        String s2 = String.format("select customer_id, first_name, last_name, address_id,  payment_id,  rental_id, amount, film_id , store_id ,staff_id \n" +
                "from customer join payment using (customer_id)  join rental using(customer_id , staff_id ,rental_id) join inventory using (inventory_id)\n" +
                "where staff_id = %s and store_id = %s", HelloApplication.id.get(0) , HelloApplication.storeID.get(0)) ;
        ResultSet res2 = sql2.ExecuteQuery(s2);


        if (res2==null)
            System.out.println("-Error !");
        else
            while (true)
            {
                try {
                    if (!res2.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    paymentINFO.add(new payInfo(res2.getInt("customer_id"),res2.getString("first_name"),res2.getString("last_name"),res2.getInt("address_id"),res2.getInt("payment_id"),
                            res2.getInt("rental_id"), res2.getInt("amount"),res2.getInt("film_id"),res2.getInt("store_id"),res2.getInt("staff_id"))  ) ;
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }

        ////
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("paymentInformation.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void click_registering(MouseEvent event) throws IOException {    // Registering the start and end of rent
        MySQLConnection sql2 = new MySQLConnection() ;
        String s2 = String.format("select rental_id, rental_date, inventory_id, customer_id, return_date, staff_id\n" +
                "from inventory join rental using(inventory_id)\n" +
                "where  staff_id = %s and store_id = %s", HelloApplication.id.get(0), HelloApplication.storeID.get(0)) ;
        ResultSet res2 = sql2.ExecuteQuery(s2);


        if (res2==null)
            System.out.println("-Error !");
        else
            while (true)
            {
                try {
                    if (!res2.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    allRequest.add(new rental(res2.getInt("rental_id"),res2.getString("rental_date"),res2.getInt("inventory_id"),res2.getInt("customer_id"),res2.getString("return_date"),res2.getInt("staff_id") )  ) ;
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }

            ////
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("managerClickRegisteingPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void click_rentlInf(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("errorManagerPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void click_search(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("searchPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void click_view(MouseEvent event) throws IOException {
        MySQLConnection sql2 = new MySQLConnection() ;
        String s2 = "SELECT category.name AS category_name, film.title AS film_title \n" +
                "         FROM film \n" +
                "         JOIN film_category ON film.film_id = film_category.film_id \n" +
                "         JOIN category ON film_category.category_id = category.category_id\n" +
                "         ORDER BY film_category.category_id" ;
        ResultSet res2 = sql2.ExecuteQuery(s2);


        if (res2==null)
            System.out.println("-Error !");
        else
            while (true)
            {
                try {
                    if (!res2.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    filmCat.add(new filmCategory(res2.getString("category_name"),res2.getString("film_title"))) ;
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }
            //
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("moviesListInEachCategory.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void click_logout(MouseEvent event) throws IOException {
        HelloApplication.id.clear();
        HelloApplication.storeID.clear();
        managerStores.clear();
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("loginPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

}
