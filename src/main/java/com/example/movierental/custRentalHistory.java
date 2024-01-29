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

import static com.example.movierental.film.customerRentalHistory;
import static com.example.movierental.film.searchLanguage;

public class custRentalHistory {

    @FXML
    private Button btn1;

    @FXML
    private TableColumn<film, Integer> colReleaseYear;

    @FXML
    private TableColumn<film, String> colRentalDate;

    @FXML
    private TableColumn<film, String> colTitle;

    @FXML
    private Label lbl1;

    @FXML
    private Rectangle rectangl;

    @FXML
    private TableView<film> table;

    ObservableList<film> list = FXCollections.observableArrayList(customerRentalHistory) ;
    public void initialize() {
        colTitle.setCellValueFactory(new PropertyValueFactory<film, String>("title"));
        colRentalDate.setCellValueFactory(new PropertyValueFactory<film, String>("rentalDate"));
        colReleaseYear.setCellValueFactory(new PropertyValueFactory<film, Integer>("release_year"));

        table.setItems(list);
    }

    @FXML
    void clickHome(MouseEvent event) throws IOException {
        customerRentalHistory.clear();
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("customerPannel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

}
