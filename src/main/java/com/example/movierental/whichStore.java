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
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.movierental.Store.allStores;
import static com.example.movierental.Store.managerStores;

public class whichStore {

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnNext;

    @FXML
    private TableView<Store> table;

    @FXML
    private TableColumn<Store, Integer> colAddressID;

    @FXML
    private TableColumn<Store, Integer> colStoreID;

    @FXML
    private Label lb2;

    @FXML
    private Label lbl1;

    @FXML
    private TextField txtFieldID;


    ObservableList<Store> list = FXCollections.observableArrayList(managerStores) ;
    public void initialize() {
        colAddressID.setCellValueFactory(new PropertyValueFactory<Store, Integer>("addressID"));
        colStoreID.setCellValueFactory(new PropertyValueFactory<Store, Integer>("storeID"));
        table.setItems(list);
    }

    @FXML
    void clickNext(MouseEvent event) throws IOException {
        // اگه ورودی اشتباه بود
/*
        for (int i = 0; i< managerStores.size() ; i++) {
            if (managerStores.get(i).getStoreID() != Integer.valueOf(txtFieldID.getText())) {
                // ورودی اشتباه
                HelloApplication.id.clear();
                Parent parent = FXMLLoader.load(HelloApplication.class.getResource("error.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(parent);
                stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
                stage.setTitle("Movie Rental");
                stage.setScene(scene);
                stage.show();
            }
        } */

        //
        // اگه ورودی خالی بود
        if (txtFieldID.getText().isEmpty()){
            HelloApplication.id.clear();
            managerStores.clear();
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("error.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Movie Rental");
            stage.setScene(scene);
            stage.show();
        }
        // اگه درست بود میره صفحع
        HelloApplication.storeID.add(0,Integer.valueOf(txtFieldID.getText()) );
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("managerPannel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void clickLogout(MouseEvent event) throws IOException {
        HelloApplication.id.clear();
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
