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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.movierental.Store.custStorInfo;
import static com.example.movierental.film.customerRentalInfo;

public class custStoreInfo {

    @FXML
    private Button btn1;

    @FXML
    private TableColumn<Store, String> colAddress;

    @FXML
    private TableColumn<Store, Integer> colAddressID;

    @FXML
    private TableColumn<Store, Integer> colStoreID;

    @FXML
    private TableView<Store> table;

    @FXML
    private Label lbl1;

    @FXML
    private Rectangle rec;


    ObservableList<Store> list = FXCollections.observableArrayList(custStorInfo) ;
    public void initialize() {
        colAddress.setCellValueFactory(new PropertyValueFactory<Store, String>("address"));
        colAddressID.setCellValueFactory(new PropertyValueFactory<Store, Integer>("addressID"));
        colStoreID.setCellValueFactory(new PropertyValueFactory<Store, Integer>("storeID"));

        table.setItems(list);
    }





    @FXML
    void clickHome(MouseEvent event) throws IOException {
        custStorInfo.clear();
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("customerPannel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

}
