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

import static com.example.movierental.Store.allStores;
import static com.example.movierental.inventory.allInventory;

public class activeRentlInfoPage {

    @FXML
    private Button btn_back;

    @FXML
    private TableColumn<inventory, Integer> col_filmID;

    @FXML
    private TableColumn<inventory, Integer> col_inventoryID;

    @FXML
    private TableColumn<inventory, Integer> col_storeID;

    @FXML
    private Label lbl1;

    @FXML
    private Rectangle rec;

    @FXML
    private TableView<inventory> table;


    ObservableList<inventory> list = FXCollections.observableArrayList(allInventory) ;
    public void initialize() {
        col_inventoryID.setCellValueFactory(new PropertyValueFactory<inventory, Integer>("inventory_id"));
        col_filmID.setCellValueFactory(new PropertyValueFactory<inventory, Integer>("film_id"));
        col_storeID.setCellValueFactory(new PropertyValueFactory<inventory, Integer>("store_id"));
        table.setItems(list);
    }

    @FXML
    void click_back(MouseEvent event) throws IOException {
        allInventory.clear();
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("managerPannel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

}
