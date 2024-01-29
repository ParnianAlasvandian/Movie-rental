package com.example.movierental;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import java.io.IOException;
import java.sql.* ;


public class HelloApplication extends Application {
    static public ArrayList<Integer> id = new ArrayList<>();
    static public ArrayList<Integer> storeID = new ArrayList<>();
    static public ArrayList<Integer> p = new ArrayList<>();




    @Override

    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("startPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class MySQLConnection
{
    String URL = "jdbc:mysql://localhost/sakila" ;
    String UserName = "root" ;
    String Password = "" ;

    Boolean ExecuteSQL (String SqlCmd) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection Con = DriverManager.getConnection(URL, UserName, Password);
            Statement s = Con.prepareStatement(SqlCmd);
            s.execute(SqlCmd);

            Con.close();
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }
    ResultSet ExecuteQuery (String SqlCmd) {  //به صورت جدولی
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection Con = DriverManager.getConnection(URL, UserName, Password);
            Statement s = Con.prepareStatement(SqlCmd);
            ResultSet rs = s.executeQuery(SqlCmd);


            //Con.close();
            return rs;
        }
        catch (Exception ex)
        {
            return null;
        }
    }

}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
