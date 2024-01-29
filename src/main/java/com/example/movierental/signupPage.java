package com.example.movierental;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.movierental.Store.allStores;

public class signupPage {

    @FXML
    private TextField addID_field;

    @FXML
    private Button but_customer;

    @FXML
    private Button but_home;

    @FXML
    private Button but_manager;

    @FXML
    private TextField email_field;

    @FXML
    private TextField lastName_field;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private Label lbl4;

    @FXML
    private Label lbl5;

    @FXML
    private Label lbl6;

    @FXML
    private Label lbl7;

    @FXML
    private Label lbl8;

    @FXML
    private TextField name_field;

    @FXML
    private PasswordField pass_field;

    @FXML
    private Rectangle rectangle;

    @FXML
    private TextField userName_field;



    @FXML
    void click_customer(MouseEvent event) throws SQLException, IOException {

        // اگه جای خالی بود
        if (name_field.getText().isEmpty() || lastName_field.getText().isEmpty() || email_field.getText().isEmpty() || addID_field.getText().isEmpty() || userName_field.getText().isEmpty()){
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("error.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Movie Rental");
            stage.setScene(scene);
            stage.show();
        }
        //
        String SQLCom = String.format("INSERT INTO `customer` (first_name, last_name, email, address_id, password) values ('%s', '%s', '%s',  %s, '%s')", name_field.getText(), lastName_field.getText(), email_field.getText(), Integer.valueOf(addID_field.getText()), pass_field.getText());
        MySQLConnection sql = new MySQLConnection() ;
        Boolean res  =  sql.ExecuteSQL(SQLCom) ;

        if (res ) {
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("successfulPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Movie Rental");
            stage.setScene(scene);
            stage.show();

            System.out.println("gi");
        }
        else {
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("errorPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Movie Rental");
            stage.setScene(scene);
            stage.show();
        }

    }

////////////////////////////////////////////////////////////////////////////////////

    @FXML
    void click_manager(MouseEvent event) throws IOException, SQLException {
        //در اری لیست تمامی استورهای موجود را می آوریم
        MySQLConnection sql2 = new MySQLConnection() ;
        String s2 = String.format("SELECT store_id,address_id,status FROM store where status = '%s'",0) ;
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
                    allStores.add(new Store(res2.getInt("store_id"),res2.getInt("address_id"),res2.getInt("status"))) ;
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }
        //
        // اگه جای خالی بود
        if (name_field.getText().isEmpty() || lastName_field.getText().isEmpty() || email_field.getText().isEmpty() || addID_field.getText().isEmpty() || userName_field.getText().isEmpty()){
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("errorPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Movie Rental");
            stage.setScene(scene);
            stage.show();
        }
        //
        String SQLCom = String.format("INSERT INTO manager (first_name, last_name, email, address_id, username, password) values ('%s', '%s', '%s',  %s, '%s', '%s')", name_field.getText(), lastName_field.getText(), email_field.getText(), Integer.valueOf(addID_field.getText()),userName_field.getText(),pass_field.getText());
        MySQLConnection sql = new MySQLConnection() ;
        Boolean res  =  sql.ExecuteSQL(SQLCom) ;

        if (res) {
            String SQLCom2 = String.format("select manager_id from manager where email = '%s' and password = '%s'", email_field.getText(), pass_field.getText());
            ResultSet res22  =  sql.ExecuteQuery(SQLCom2) ;

            if (res22.next() ) {
                int mangID = res22.getInt("manager_id");
                HelloApplication.id.add(mangID) ;
            }

            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("chooseStore.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Movie Rental");
            stage.setScene(scene);
            stage.show();
            //System.out.println("hey");
        }
        else {
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("errorPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Movie Rental");
            stage.setScene(scene);
            stage.show();
        }



    }

    @FXML
    void click_home(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("loginPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

}
