package com.example.movierental;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.movierental.inventory.allInventory;
import static com.example.movierental.rental.allRequest;

public class managerClickRegisteingPage {

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private DatePicker changeDate;

    @FXML
    private TableColumn<rental, Integer> colCustomerID;

    @FXML
    private TableColumn<rental, Integer> colInventoryID;

    @FXML
    private TableColumn<rental, String> colRentalDate;

    @FXML
    private TableColumn<rental, String> colReturnDate;

    @FXML
    private TableColumn<rental, Integer> col_ManagerID;

    @FXML
    private TableColumn<rental, Integer> col_RentaliD;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Rectangle rectangle;

    @FXML
    private TableView<rental> table;

    @FXML
    private TextField txtField;



    ObservableList<rental> list = FXCollections.observableArrayList(allRequest) ;
    public void initialize() {
        col_RentaliD.setCellValueFactory(new PropertyValueFactory<rental, Integer>("request_id"));
        colRentalDate.setCellValueFactory(new PropertyValueFactory<rental, String>("rental_date"));
        colInventoryID.setCellValueFactory(new PropertyValueFactory<rental, Integer>("inventory_id"));
        colCustomerID.setCellValueFactory(new PropertyValueFactory<rental, Integer>("customer_id"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<rental, String>("return_date"));
        col_ManagerID.setCellValueFactory(new PropertyValueFactory<rental, Integer>("staff_id"));

        table.setItems(list);
    }

    String daEChange ;

    @FXML
    void ac_changeDate(ActionEvent event) {
        daEChange = changeDate.getValue().toString() ;
    }

    int rentalID = allRequest.get(0).getRequest_id() ;

    @FXML
    void click_rentalDate(MouseEvent event) throws SQLException, IOException {
        String SQLCom = String.format("update rental set rental_date = '%s' where rental_id = %s", txtField.getText(),rentalID) ;
        MySQLConnection sql = new MySQLConnection() ;
        Boolean res  =  sql.ExecuteSQL(SQLCom) ;
        if (res){
            allRequest.clear();
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("successfulManagerPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Movie Rental");
            stage.setScene(scene);
            stage.show();
        }
        else {
            allRequest.clear();
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("errorManagerPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Movie Rental");
            stage.setScene(scene);
            stage.show();
        }

    }

    @FXML
    void click_returnDate(MouseEvent event) throws IOException {
        String SQLCom = String.format("update rental set return_date = '%s' where rental_id = %s", txtField.getText(),rentalID) ;
        MySQLConnection sql = new MySQLConnection() ;
        Boolean res  =  sql.ExecuteSQL(SQLCom) ;
        if (res){
            allRequest.clear();
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("successfulManagerPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Movie Rental");
            stage.setScene(scene);
            stage.show();
        }
        else {
            allRequest.clear();
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("errorManagerPage.fxml"));
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
        allRequest.clear();
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("managerPannel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

}
