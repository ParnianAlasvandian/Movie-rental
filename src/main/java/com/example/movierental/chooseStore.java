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

import static com.example.movierental.Store.allStores;

public class chooseStore {

    @FXML
    private Button ButSave;

    @FXML
    private TextField FielID;

    @FXML
    private TableView<Store> table;

    @FXML
    private TableColumn<Store, Integer> colAddID;

    @FXML
    private TableColumn<Store, Integer> colStatus;

    @FXML
    private TableColumn<Store, Integer> colStoreID;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Rectangle rectangle;

    ObservableList<Store> list = FXCollections.observableArrayList(allStores) ;
    public void initialize() {
        colAddID.setCellValueFactory(new PropertyValueFactory<Store, Integer>("addressID"));
        colStatus.setCellValueFactory(new PropertyValueFactory<Store, Integer>("status"));
        colStoreID.setCellValueFactory(new PropertyValueFactory<Store, Integer>("storeID"));
        table.setItems(list);
    }



    @FXML
    void click_save(MouseEvent event) throws IOException {
        ///    save shodan!!!!
        ///
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("loginPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }



}
