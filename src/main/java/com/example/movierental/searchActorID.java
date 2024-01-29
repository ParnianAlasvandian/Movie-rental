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

import static com.example.movierental.Store.managerStores;
import static com.example.movierental.actor.allActor;

public class searchActorID {

    @FXML
    private Button btnHome;

    @FXML
    private TableColumn<actor, Integer> colFilmID;

    @FXML
    private TableColumn<actor, String> colFirstName;

    @FXML
    private TableColumn<actor, String> colLastName;

    @FXML
    private TableColumn<actor, String> colTitle;

    @FXML
    private Label lbl1;

    @FXML
    private Rectangle rectngl;

    @FXML
    private TableView<actor> table;

    ObservableList<actor> list = FXCollections.observableArrayList(allActor) ;
    public void initialize() {

        colFirstName.setCellValueFactory(new PropertyValueFactory<actor, String>("first_name"));
        colLastName.setCellValueFactory(new PropertyValueFactory<actor, String>("last_name"));
        colFilmID.setCellValueFactory(new PropertyValueFactory<actor, Integer>("film_id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<actor, String>("title"));
        table.setItems(list);
    }

    @FXML
    void clickHome(MouseEvent event) throws IOException {

        allActor.clear();

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
