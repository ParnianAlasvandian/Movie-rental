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

import static com.example.movierental.Store.custStorInfo;
import static com.example.movierental.customer.allCustomer;
import static com.example.movierental.film.*;
import static com.example.movierental.filmCategory.filmCat;
import static com.example.movierental.inventory.allInventory;
import static com.example.movierental.payInfo.customerPaymentINFO;
import static com.example.movierental.payInfo.paymentINFO;
import static com.example.movierental.rental.viewActiveReqClose;

public class customerPannel {

    @FXML
    private Button btn1;

    @FXML
    private Button btn10;

    @FXML
    private Button btn11;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Label lbl1;

    @FXML
    private Rectangle rectangle;

    @FXML
    void click_CustomerPaymentInfo(MouseEvent event) throws IOException {
        MySQLConnection sql2 = new MySQLConnection() ;
        String s2 = String.format("select customer_id, payment_id , staff_id, rental_id, payment_date  \n" +
                "from customer join payment as p using (customer_id)\n" +
                "where customer_id = %s ", HelloApplication.id.get(0) ) ;
        ResultSet res2 = sql2.ExecuteQuery(s2);
        System.out.println(HelloApplication.id.get(0));


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
                    customerPaymentINFO.add(new payInfo(res2.getInt("customer_id"),res2.getInt("payment_id"),res2.getInt("staff_id"),
                            res2.getInt("rental_id"), res2.getString("payment_date"))  ) ;
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }

        ////
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("customerPaymentInfo.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void click_RentalInfo(MouseEvent event) throws IOException {
        MySQLConnection sql2 = new MySQLConnection() ;
        String s2 ="SELECT film.title, COUNT(rental.rental_id) AS numberOfRents, AVG(rental.rate) AS average_rating \n" +
                "                FROM film \n" +
                "                JOIN inventory ON film.film_id = inventory.film_id \n" +
                "                JOIN rental ON inventory.inventory_id = rental.inventory_id \n" +
                "                GROUP BY film.film_id "  ;
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
                    customerRentalInfo.add(new film(res2.getString("film.title"),res2.getInt("numberOfRents"),res2.getInt("average_rating"))) ;
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }
        //

        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("rentalInfoPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void click_RentalReq(MouseEvent event) throws IOException {
        MySQLConnection sql2 = new MySQLConnection() ;
        String s2 = String.format("select inventory_id, film_id,store_id\n" +
                "  from inventory\n" +
                "  where inventory_id not in (select inventory_id from rental)") ;

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
            //
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("costRequestRent.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void click_StoreInfo(MouseEvent event) throws IOException {
        MySQLConnection sql2 = new MySQLConnection() ;
        String s2 ="select store_id, address_id , address\n" +
                "from store  join address using (address_id)"  ;
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
                    custStorInfo.add(new Store(res2.getInt("store_id"),res2.getInt("address_id"),res2.getString("address"))) ;
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }
        //

        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("custStoreInfo.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void click_ViewingListMov(MouseEvent event) throws IOException {
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
    void click_editProfileInfo(MouseEvent event) throws IOException {
        MySQLConnection sql2 = new MySQLConnection() ;
        String s2 = String.format("select customer_id, first_name, last_name, email, address_id\n" +
                "  from customer \n" +
                "  where customer_id = %s", HelloApplication.id.get(0)) ;
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
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("custEditInfo.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void click_history(MouseEvent event) throws IOException {
        MySQLConnection sql2 = new MySQLConnection() ;
        String s2 = String.format("SELECT title, rental_date ,release_year\n" +
                "                 FROM rental join inventory on rental.inventory_id = inventory.inventory_id \n" +
                "                 join film on inventory.film_id = film.film_id \n" +
                "                 WHERE rental.customer_id = %s",  HelloApplication.id.get(0) ) ;
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
                    customerRentalHistory.add(new film(res2.getString("title"),res2.getString("rental_date"),res2.getInt("release_year"))) ;
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }
        //
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("custRentalHistory.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void click_logout(MouseEvent event) throws IOException {
        //
        //
        //
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("loginPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void click_search(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("CustSearchPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void click_viewActiveMovie(MouseEvent event) throws IOException {
        // view active
        MySQLConnection sql2 = new MySQLConnection() ;
        String s2 ="select inventory_id, film_id,store_id\n" +
                "  from inventory\n" +
                "  where inventory_id not in (select inventory_id from rental)" ;

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
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("viewActiveMovie.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void click_viewActiveReqClose(MouseEvent event) throws IOException {
        MySQLConnection sql2 = new MySQLConnection() ;
        String s2 =String.format(" SELECT r.rental_id, r.rental_date, r.inventory_id, r.staff_id\n" +
                "FROM history as h,rental as r\n" +
                "where h.rental_id = r.rental_id and h.customer_id = r.customer_id = %s and status = 0",HelloApplication.id.get(0))  ;
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
                    viewActiveReqClose.add(new rental(res2.getInt("rental_id"),res2.getString("rental_date"),res2.getInt("inventory_id"),res2.getInt("staff_id"))) ;
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }
        //


        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("viewActiveReqClosePage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

}
