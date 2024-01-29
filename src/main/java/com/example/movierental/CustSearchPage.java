package com.example.movierental;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.movierental.actor.allActor;
import static com.example.movierental.film.searchFilmGenre;
import static com.example.movierental.film.searchLanguage;

public class CustSearchPage {

    @FXML
    private Button btn1;

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
    private Label lbl1;

    @FXML
    private Rectangle rectangle;

    @FXML
    private TextField serchField;

    @FXML
    void click_ActorID(MouseEvent event) throws IOException {
        MySQLConnection sql2 = new MySQLConnection() ;
        String s2 = String.format(" select distinct  first_name, last_name, film_id , title\n" +
                " from (film_actor join inventory using (film_id) ) join actor using (actor_id) join film using (film_id)\n" +
                " where actor.actor_id = %s and film_actor.film_id = film.film_id \n", Integer.valueOf(serchField.getText())) ;
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
                    allActor.add(new actor(res2.getString("first_name"),res2.getString("last_name"),res2.getInt("film_id"),res2.getString("title"))) ;
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }

        //

        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("searchActorID.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void click_FilmLanguage(MouseEvent event) throws IOException {
        MySQLConnection sql2 = new MySQLConnection() ;
        String s2 = String.format("select distinct film_id, title, language.name, release_year\n" +
                "from (((film_actor join inventory using (film_id) ) join actor using (actor_id) ) join film using (film_id)) join language using (language_id)\n" +
                "where language.name = '%s' ", serchField.getText()) ;
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
                    searchLanguage.add(new film(res2.getInt("film_id"),res2.getString("title"),res2.getString("language.name"),res2.getInt("release_year"))) ;
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }
        //

        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("searchLanguage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void click_FilmName(MouseEvent event) throws IOException {  // title
        MySQLConnection sql2 = new MySQLConnection() ;
        String s2 = String.format("select film_id, title, actor_id, name, release_year\n" +
                "from (film_category join category using (category_id) ) join ((film_actor join inventory using (film_id) ) join actor using (actor_id) join film using (film_id))  using (film_id)\n" +
                "where title = '%s' ", serchField.getText() ) ;
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
                    searchFilmGenre.add(new film(res2.getInt("film_id"),res2.getString("title"),res2.getInt("actor_id"),res2.getString("name"),res2.getInt("release_year"))) ;
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }

        ///

        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("searchGenre.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void click_FilmYear(MouseEvent event) throws IOException {
        MySQLConnection sql2 = new MySQLConnection() ;
        String s2 = String.format("select film_id, title, actor_id, name, release_year\n" +
                "from (film_category join category using (category_id) ) join ((film_actor join inventory using (film_id) ) join actor using (actor_id) join film using (film_id))  using (film_id)\n" +
                "where release_year = %s ", Integer.valueOf(serchField.getText()) ) ;
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
                    searchFilmGenre.add(new film(res2.getInt("film_id"),res2.getString("title"),res2.getInt("actor_id"),res2.getString("name"),res2.getInt("release_year"))) ;
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }

        //
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("searchGenre.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void click_Genre(MouseEvent event) throws IOException {
        MySQLConnection sql2 = new MySQLConnection() ;
        String s2 = String.format("select film_id, title, actor_id, name, release_year\n" +
                "from (film_category join category using (category_id) ) join ((film_actor join inventory using (film_id) ) join actor using (actor_id) join film using (film_id))  using (film_id)\n" +
                "where name = '%s' ", serchField.getText() ) ;
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
                    searchFilmGenre.add(new film(res2.getInt("film_id"),res2.getString("title"),res2.getInt("actor_id"),res2.getString("name"),res2.getInt("release_year"))) ;
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }

        //
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("searchGenre.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void click_home(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("customerPannel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

}
