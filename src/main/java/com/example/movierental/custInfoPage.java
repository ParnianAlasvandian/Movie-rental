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
import static com.example.movierental.customer.allCustomer;

public class custInfoPage {

    @FXML
    private Button butBack;

    @FXML
    private TableColumn<customer, Integer> colAddID;

    @FXML
    private TableColumn<customer, Integer> colCustID;

    @FXML
    private TableColumn<customer, String> colEmail;

    @FXML
    private TableColumn<customer, String> colFirstName;

    @FXML
    private TableColumn<customer, String> colLastName;

    @FXML
    private Label lbl1;

    @FXML
    private Rectangle rectangle;

    @FXML
    private TableView<customer> table;

    ObservableList<customer> list = FXCollections.observableArrayList(allCustomer) ;

    public void initialize() {
        colCustID.setCellValueFactory(new PropertyValueFactory<customer, Integer>("customer_id"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<customer, String>("first_name"));
        colLastName.setCellValueFactory(new PropertyValueFactory<customer, String>("last_name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<customer, String>("email"));
        colAddID.setCellValueFactory(new PropertyValueFactory<customer, Integer>("address_id"));
        table.setItems(list);
    }

    @FXML
    void clickBack(MouseEvent event) throws IOException {
        allCustomer.clear();
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("managerPannel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

}
