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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.movierental.payInfo.paymentINFO;
import static com.example.movierental.rental.allRequest;

public class paymentInformation {

    @FXML
    private Button btn1;

    @FXML
    private TableColumn<payInfo, Integer> cal_RentalID;

    @FXML
    private TableColumn<payInfo, Integer> cal_StoreID;

    @FXML
    private TableColumn<payInfo, Integer> cal_addID;

    @FXML
    private TableColumn<payInfo, Integer> cal_amount;

    @FXML
    private TableColumn<payInfo, Integer> cal_custID;

    @FXML
    private TableColumn<payInfo, Integer> cal_filmID;

    @FXML
    private TableColumn<payInfo, String> cal_firstNam;

    @FXML
    private TableColumn<payInfo, String> cal_lastName;

    @FXML
    private TableColumn<payInfo, Integer> cal_paymentID;

    @FXML
    private TableColumn<payInfo, Integer> cal_staffID;

    @FXML
    private TableView<payInfo> table;

    @FXML
    private Label lbl1;

    @FXML
    private Rectangle rectangle;


    ObservableList<payInfo> list = FXCollections.observableArrayList(paymentINFO) ;

    public void initialize() {

        cal_custID.setCellValueFactory(new PropertyValueFactory<payInfo, Integer>("customer_id"));
        cal_firstNam.setCellValueFactory(new PropertyValueFactory<payInfo, String>("first_name"));
        cal_lastName.setCellValueFactory(new PropertyValueFactory<payInfo, String>("last_name"));
        cal_addID.setCellValueFactory(new PropertyValueFactory<payInfo, Integer>("address_id"));
        cal_paymentID.setCellValueFactory(new PropertyValueFactory<payInfo, Integer>("payment_id"));
        cal_RentalID.setCellValueFactory(new PropertyValueFactory<payInfo, Integer>("rental_id"));
        cal_amount.setCellValueFactory(new PropertyValueFactory<payInfo, Integer>("amount"));
        cal_filmID.setCellValueFactory(new PropertyValueFactory<payInfo, Integer>("film_id"));
        cal_StoreID.setCellValueFactory(new PropertyValueFactory<payInfo, Integer>("store_id"));
        cal_staffID.setCellValueFactory(new PropertyValueFactory<payInfo, Integer>("staff_id"));

        table.setItems(list);
    }


    @FXML
    void click_home(MouseEvent event) throws IOException {
        paymentINFO.clear();
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("managerPannel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

}
