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

import static com.example.movierental.filmCategory.filmCat;
import static com.example.movierental.inventory.allInventory;

public class moviesListInEachCategory {

    @FXML
    private Button btn1;

    @FXML
    private TableColumn<filmCategory, String> colCatName;

    @FXML
    private TableColumn<filmCategory, String> colFilmTitle;

    @FXML
    private Label lbl1;

    @FXML
    private Rectangle rect;

    @FXML
    private TableView<filmCategory> table;

    ObservableList<filmCategory> list = FXCollections.observableArrayList(filmCat) ;
    public void initialize() {
        colCatName.setCellValueFactory(new PropertyValueFactory<filmCategory, String>("category_name"));
        colFilmTitle.setCellValueFactory(new PropertyValueFactory<filmCategory, String>("film_title"));
        table.setItems(list);
    }


    @FXML
    void clickHome(MouseEvent event) throws IOException {

        filmCat.clear();

        if (HelloApplication.p.get(0)==0){
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("managerPannel.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Movie Rental");
            stage.setScene(scene);
            stage.show();
        }
        else {
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("customerPannel.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Movie Rental");
            stage.setScene(scene);
            stage.show();
        }
    }

}
