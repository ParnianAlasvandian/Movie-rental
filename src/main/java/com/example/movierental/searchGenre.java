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

import static com.example.movierental.actor.allActor;
import static com.example.movierental.film.searchFilmGenre;

public class searchGenre {

    @FXML
    private Button btnHome;

    @FXML
    private TableColumn<film, Integer> colActorID;

    @FXML
    private TableColumn<film, Integer> colFilmID;

    @FXML
    private TableColumn<film, String> colTitle;

    @FXML
    private TableColumn<film, Integer> colReleaseYear;

    @FXML
    private TableColumn<film, String> colGenre;

    @FXML
    private Label lbl1;

    @FXML
    private Rectangle rectangle;

    @FXML
    private TableView<film> table;

    ObservableList<film> list = FXCollections.observableArrayList(searchFilmGenre) ;
    public void initialize() {
        colFilmID.setCellValueFactory(new PropertyValueFactory<film, Integer>("film_id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<film, String>("title"));
        colActorID.setCellValueFactory(new PropertyValueFactory<film, Integer>("actor_id"));
        colGenre.setCellValueFactory(new PropertyValueFactory<film, String>("nameGenre"));
        colReleaseYear.setCellValueFactory(new PropertyValueFactory<film, Integer>("release_year"));

        table.setItems(list);
    }

    @FXML
    void clickHome(MouseEvent event) throws IOException {
        searchFilmGenre.clear();

        if (HelloApplication.p.get(0) == 0) {
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("managerPannel.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Movie Rental");
            stage.setScene(scene);
            stage.show();
        }
        else if (HelloApplication.p.get(0) == 1) {
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
