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

import static com.example.movierental.payInfo.customerPaymentINFO;
import static com.example.movierental.payInfo.paymentINFO;

public class customerPaymentInfo {

    @FXML
    private Button btn1;

    @FXML
    private TableColumn<payInfo, String> cal_PaymentDate;

    @FXML
    private TableColumn<payInfo, Integer> cal_RentalID;

    @FXML
    private TableColumn<payInfo, Integer> cal_custID;

    @FXML
    private TableColumn<payInfo, Integer> cal_paymentID;

    @FXML
    private TableColumn<payInfo, Integer> cal_staffID;

    @FXML
    private Label lbl1;

    @FXML
    private Rectangle rectangle;

    @FXML
    private TableView<payInfo> table;

    ObservableList<payInfo> list = FXCollections.observableArrayList(customerPaymentINFO) ;

    public void initialize() {
        cal_custID.setCellValueFactory(new PropertyValueFactory<payInfo, Integer>("customer_id"));
        cal_paymentID.setCellValueFactory(new PropertyValueFactory<payInfo, Integer>("payment_id"));
        cal_staffID.setCellValueFactory(new PropertyValueFactory<payInfo, Integer>("staff_id"));
        cal_RentalID.setCellValueFactory(new PropertyValueFactory<payInfo, Integer>("rental_id"));
        cal_PaymentDate.setCellValueFactory(new PropertyValueFactory<payInfo, String>("payment_date"));
        table.setItems(list);
    }


    @FXML
    void click_Home(MouseEvent event) throws IOException {
        customerPaymentINFO.clear();
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("customerPannel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

}
