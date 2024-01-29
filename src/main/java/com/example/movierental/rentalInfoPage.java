package com.example.movierental;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.movierental.film.customerRentalHistory;
import static com.example.movierental.film.customerRentalInfo;

public class rentalInfoPage {

    @FXML
    private Button btn1;

    @FXML
    private TableColumn<film, Integer> colAVGrat;

    @FXML
    private TableColumn<film, Integer> colNumRen;

    @FXML
    private TableColumn<film, String> colTitle;

    @FXML
    private Rectangle rect;

    @FXML
    private TableView<film> table;


    ObservableList<film> list = FXCollections.observableArrayList(customerRentalInfo) ;
    public void initialize() {
        colTitle.setCellValueFactory(new PropertyValueFactory<film, String>("title"));
        colAVGrat.setCellValueFactory(new PropertyValueFactory<film, Integer>("average_rating"));
        colNumRen.setCellValueFactory(new PropertyValueFactory<film, Integer>("numberOfRents"));

        table.setItems(list);
    }


    @FXML
    void click_home(MouseEvent event) throws IOException {
        customerRentalInfo.clear();
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("customerPannel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

}
