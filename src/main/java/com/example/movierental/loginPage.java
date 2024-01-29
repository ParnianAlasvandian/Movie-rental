package com.example.movierental;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.movierental.Store.managerStores;


public class loginPage {

   @FXML
   private Button but_customer;

   @FXML
   private Button but_manager;

   @FXML
   private Button but_signUp;

   @FXML
   private Rectangle rectangle;

   @FXML
   private TextField textFielde_email;

   @FXML
   private PasswordField textFielde_pass;

   @FXML
   private Text txt_Password;

   @FXML
   private Text txt_email;

   @FXML
   private Text txt_login;

   @FXML
   private Text txt_notAccount;
   @FXML
   void click_customer(MouseEvent event) throws SQLException, IOException {
      String SQLCom;
      if (textFielde_pass.getText().isEmpty()) {
         SQLCom = String.format("select customer_id from customer where email = '%s' and password IS NULL", textFielde_email.getText());
      }else {
         SQLCom = String.format("select customer_id from customer where email = '%s' and password = '%s'", textFielde_email.getText(), textFielde_pass.getText());
      }

      MySQLConnection sql = new MySQLConnection() ;
      ResultSet res  =  sql.ExecuteQuery(SQLCom) ;
      if (res.next()) {
         int custId = res.getInt("customer_id");
         HelloApplication.id.add(0,custId) ;
         HelloApplication.p.add(0,1) ;
         Parent parent = FXMLLoader.load(HelloApplication.class.getResource("customerPannel.fxml"));
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         Scene scene = new Scene(parent);
         stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
         stage.setTitle("Movie Rental");
         stage.setScene(scene);
         stage.show();
         System.out.println("Customer ID: " + custId);

      } else {
         //ورودی اشتباه
         Parent parent = FXMLLoader.load(HelloApplication.class.getResource("inCorrectPass.fxml"));
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         Scene scene = new Scene(parent);
         stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
         stage.setTitle("Movie Rental");
         stage.setScene(scene);
         stage.show();
      }

   }

   @FXML
   void click_manager(MouseEvent event) throws SQLException, IOException {
      String SQLCom;
      if (textFielde_pass.getText().isEmpty()) {
         SQLCom = String.format("select manager_id from manager where email = '%s' and password IS NULL", textFielde_email.getText());
      } else {
         SQLCom = String.format("select manager_id from manager where email = '%s' and password = '%s'", textFielde_email.getText(), textFielde_pass.getText());
      }

      MySQLConnection sql = new MySQLConnection() ;
      ResultSet res  =  sql.ExecuteQuery(SQLCom) ;
      if (res.next() ) {
         int staffId = res.getInt("manager_id");
         //در اری لیست تمامی استورهای این کاربر را می آوریم
         MySQLConnection sql2 = new MySQLConnection() ;
         String s2 = String.format("SELECT store_id,address_id FROM store natural join storeManagement  where manager_id = %s",staffId) ;
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
                  managerStores.add(new Store(res2.getInt("store_id"),res2.getInt("address_id"))) ;
               } catch (SQLException e) {
                  e.printStackTrace();

               }
            }

         HelloApplication.id.add(0,staffId) ;
         HelloApplication.p.add(0,0) ;
         //رفتن به پنل منیجر
         Parent parent = FXMLLoader.load(HelloApplication.class.getResource("whichStore.fxml"));
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         Scene scene = new Scene(parent);
         stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
         stage.setTitle("Movie Rental");
         stage.setScene(scene);
         stage.show();
         System.out.println("Manager ID: " + staffId);
      } else {
         //ورودی اشتباه
         Parent parent = FXMLLoader.load(HelloApplication.class.getResource("inCorrectPass.fxml"));
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         Scene scene = new Scene(parent);
         stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
         stage.setTitle("Movie Rental");
         stage.setScene(scene);
         stage.show();
      }
   }


   @FXML
   void click_signUp(MouseEvent event) throws IOException {
      Parent parent = FXMLLoader.load(HelloApplication.class.getResource("signupPage.fxml"));
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      Scene scene = new Scene(parent);
      stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
      stage.setTitle("Movie Rental");
      stage.setScene(scene);
      stage.show();
   }

}
