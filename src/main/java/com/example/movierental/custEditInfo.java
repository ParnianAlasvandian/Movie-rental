package com.example.movierental;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.movierental.customer.allCustomer;

public class custEditInfo {

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private TableColumn<customer, Integer> colAddID;

    @FXML
    private TableColumn<customer, Integer> colCustID;

    @FXML
    private TableColumn<customer, String> colEmail;

    @FXML
    private TableColumn<customer, String> colFirstName;

    @FXML
    private TableColumn<customer, String> colLastName;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Rectangle rectangle;

    @FXML
    private TableView<customer> table;

    @FXML
    private TextField txtField;


    ObservableList<customer> list = FXCollections.observableArrayList(allCustomer) ;

    public void initialize() {
        colCustID.setCellValueFactory(new PropertyValueFactory<customer, Integer>("customer_id"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<customer, String>("first_name"));
        colLastName.setCellValueFactory(new PropertyValueFactory<customer, String>("last_name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<customer, String>("email"));
        colAddID.setCellValueFactory(new PropertyValueFactory<customer, Integer>("address_id"));
        table.setItems(list);
    }


    @FXML
    void click_AddID(MouseEvent event) throws IOException {

        String SQLCom = String.format("update customer\n" +
                "set address_id = %s where customer_id = %s", Integer.valueOf(txtField.getText()) , HelloApplication.id.get(0)) ;
        MySQLConnection sql = new MySQLConnection() ;
        Boolean res  =  sql.ExecuteSQL(SQLCom) ;
        if (res){
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("successfulCustomerPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Movie Rental");
            stage.setScene(scene);
            stage.show();
        } else{
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("errorCustomerPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Movie Rental");
            stage.setScene(scene);
            stage.show();
        }

    }

    @FXML
    void click_Email(MouseEvent event) throws IOException {

        String SQLCom = String.format("update customer\n" +
                "set email = '%s' where customer_id = %s", txtField.getText(), HelloApplication.id.get(0)) ;
        MySQLConnection sql = new MySQLConnection() ;
        Boolean res  =  sql.ExecuteSQL(SQLCom) ;
        if (res){
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("successfulCustomerPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Movie Rental");
            stage.setScene(scene);
            stage.show();
        } else{
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("errorCustomerPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Movie Rental");
            stage.setScene(scene);
            stage.show();
        }

    }

    @FXML
    void click_FirstName(MouseEvent event) throws IOException {

        String SQLCom = String.format("update customer\n" +
                "set first_name = '%s' where customer_id = %s", txtField.getText() , HelloApplication.id.get(0)) ;
        MySQLConnection sql = new MySQLConnection() ;
        Boolean res  =  sql.ExecuteSQL(SQLCom) ;
        if (res){
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("successfulCustomerPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Movie Rental");
            stage.setScene(scene);
            stage.show();
        } else{
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("errorCustomerPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Movie Rental");
            stage.setScene(scene);
            stage.show();
        }

    }

    @FXML
    void click_LastName(MouseEvent event) throws IOException {

        String SQLCom = String.format("update customer\n" +
                "set last_name = '%s' where customer_id = %s", txtField.getText() , HelloApplication.id.get(0)) ;
        MySQLConnection sql = new MySQLConnection() ;
        Boolean res  =  sql.ExecuteSQL(SQLCom) ;
        if (res){
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("successfulCustomerPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Movie Rental");
            stage.setScene(scene);
            stage.show();
        } else{
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("errorCustomerPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Movie Rental");
            stage.setScene(scene);
            stage.show();
        }

    }

}
