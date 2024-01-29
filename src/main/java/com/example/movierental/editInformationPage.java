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

import static com.example.movierental.Store.managerStores;
import static com.example.movierental.Store.managerStoresEnter;

public class editInformationPage {

    @FXML
    private Button btnAddressID;

    @FXML
    private Button btnBack;

    @FXML
    private TableColumn<Store, Integer> colAddress_ID;

    @FXML
    private TableColumn<Store, Integer> colStore_ID;

    @FXML
    private Label lbl1;

    @FXML
    private Rectangle rectangle;

    @FXML
    private TableView<Store> table;

    @FXML
    private TextField txtfield;

    ObservableList<Store> list = FXCollections.observableArrayList(managerStoresEnter) ;
    public void initialize() {
        colAddress_ID.setCellValueFactory(new PropertyValueFactory<Store, Integer>("addressID"));
        colStore_ID.setCellValueFactory(new PropertyValueFactory<Store, Integer>("storeID"));
        table.setItems(list);
    }

    @FXML
    void clickAddressID(MouseEvent event) throws IOException {
        String SQLCom = String.format("update store\n" +
                "set address_id = %s where store_id = %s", Integer.valueOf(txtfield.getText()) , HelloApplication.storeID.get(0)) ;
        MySQLConnection sql = new MySQLConnection() ;
        Boolean res  =  sql.ExecuteSQL(SQLCom) ;

        if (res ) {
            managerStoresEnter.clear();
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("successfulManagerPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Movie Rental");
            stage.setScene(scene);
            stage.show();
        }
        else {
            managerStoresEnter.clear();
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
    void clickBack(MouseEvent event) throws IOException {
        managerStoresEnter.clear();
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("managerPannel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

}
