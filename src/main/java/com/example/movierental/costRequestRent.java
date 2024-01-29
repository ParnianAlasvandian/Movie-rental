package com.example.movierental;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.movierental.inventory.allInventory;

public class costRequestRent {

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private TableColumn<inventory, Integer> colFilmID;

    @FXML
    private TableColumn<inventory, Integer> colInvenID;

    @FXML
    private TableColumn<inventory, Integer> colStoreID;

    @FXML
    private TextField fieldTXT;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Rectangle rectangl;

    @FXML
    private DatePicker rentalDate;

    @FXML
    private DatePicker returnDate;

    @FXML
    private TableView<inventory> table;


    ObservableList<inventory> list = FXCollections.observableArrayList(allInventory) ;
    public void initialize() {
        colInvenID.setCellValueFactory(new PropertyValueFactory<inventory, Integer>("inventory_id"));
        colFilmID.setCellValueFactory(new PropertyValueFactory<inventory, Integer>("film_id"));
        colStoreID.setCellValueFactory(new PropertyValueFactory<inventory, Integer>("store_id"));
        table.setItems(list);
    }


    String rettDate ;
    String renttDate ;

    @FXML
    void acReturnDate(ActionEvent event) {
        rettDate = returnDate.getValue().toString() ;
    }

    @FXML
    void ac_rentalDate(ActionEvent event) {
        renttDate = rentalDate.getValue().toString() ;
    }

    @FXML
    void click_Done(MouseEvent event) throws SQLException, IOException {
        //
        String SQLCom4 = String.format("select active from customer where customer_id = %s ", HelloApplication.id.get(0));
        MySQLConnection sql = new MySQLConnection() ;
        ResultSet res4  =  sql.ExecuteQuery(SQLCom4) ;

        if (res4.next()){
            int active = res4.getInt("active");
            if (active == 0) {
                allInventory.clear();
                Parent parent = FXMLLoader.load(HelloApplication.class.getResource("dontHaveAccess.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(parent);
                stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
                stage.setTitle("Movie Rental");
                stage.setScene(scene);
                stage.show();
            }
        }


        String SQLCom = String.format("select manager_id from storemanagement where store_id = %s ", allInventory.get(0).store_id);
        ResultSet res  =  sql.ExecuteQuery(SQLCom) ;
        if (res.next() ) {
            int staffId = res.getInt("manager_id");
            //
            String SQLCom2 = String.format("INSERT INTO `reservation` (`rental_date`, `inventory_id`, `customer_id`, `return_date`, `staff_id`) values ('%s', %s,  %s, '%s', %s)",
                    renttDate, Integer.valueOf(fieldTXT.getText()), HelloApplication.id.get(0), rettDate, staffId );
            Boolean res2 = sql.ExecuteSQL(SQLCom2);

            if (res2) {
                allInventory.clear();
                Parent parent = FXMLLoader.load(HelloApplication.class.getResource("sendSucceMassege.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(parent);
                stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
                stage.setTitle("Movie Rental");
                stage.setScene(scene);
                stage.show();
            }
            else {
                allInventory.clear();
                Parent parent = FXMLLoader.load(HelloApplication.class.getResource("errorCustomerPage.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(parent);
                stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
                stage.setTitle("Movie Rental");
                stage.setScene(scene);
                stage.show();
            }

        }
    }

    @FXML
    void click_home(MouseEvent event) throws IOException {
        allInventory.clear();
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("customerPannel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

}
