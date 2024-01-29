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
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.movierental.actor.allActor;
import static com.example.movierental.rental.allRequest;

public class requestPage {

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private TableColumn<rental, Integer> colCustomerID;

    @FXML
    private TableColumn<rental, Integer> colInventoryID;

    @FXML
    private TableColumn<rental, String> colRentalDate;

    @FXML
    private TableColumn<rental, String> colReturnDate;

    @FXML
    private TableColumn<rental, Integer> col_ManagerID;

    @FXML
    private TableColumn<rental, Integer> col_RequestID;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Rectangle rectangle;

    @FXML
    private TableView<rental> table;

    @FXML
    private TextField txtField_reqID;

    ObservableList<rental> list = FXCollections.observableArrayList(allRequest) ;
    public void initialize() {

        col_RequestID.setCellValueFactory(new PropertyValueFactory<rental, Integer>("request_id"));
        colRentalDate.setCellValueFactory(new PropertyValueFactory<rental, String>("rental_date"));
        colInventoryID.setCellValueFactory(new PropertyValueFactory<rental, Integer>("inventory_id"));
        colCustomerID.setCellValueFactory(new PropertyValueFactory<rental, Integer>("customer_id"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<rental, String>("return_date"));
        col_ManagerID.setCellValueFactory(new PropertyValueFactory<rental, Integer>("staff_id"));

        table.setItems(list);
    }




    String renDate = allRequest.get(0).getRental_date() ;
    int invID = allRequest.get(0).getInventory_id() ;
    int custID = allRequest.get(0).getCustomer_id() ;
    String retunDate = allRequest.get(0).getReturn_date() ;

    @FXML
    void click_Accept(MouseEvent event) throws SQLException {
        String SQLCom = String.format("INSERT INTO `rental` (rental_date, inventory_id, customer_id, return_date, staff_id) values ('%s', %s,  %s, '%s', %s)",
                  renDate, invID, custID, retunDate, HelloApplication.id.get(0) );
        MySQLConnection sql = new MySQLConnection() ;
        Boolean res  =  sql.ExecuteSQL(SQLCom) ;
        //
        String SQLCom2 = String.format("delete from `reservation` where request_id = %s", Integer.valueOf(txtField_reqID.getText()) );
        Boolean res2  =  sql.ExecuteSQL(SQLCom2) ;
        //
        String SQLCom3 = String.format("select rental_id from `rental` where rental_date = '%s' AND inventory_id = %s AND customer_id = %s AND return_date ='%s' AND  staff_id = %s",
                renDate, invID, custID, retunDate, HelloApplication.id.get(0)) ;
        ResultSet res3  =  sql.ExecuteQuery(SQLCom3) ;
        if (res3.next()) {
            int rental_id = res3.getInt("rental_id");
            String SQLCom4 = String.format("INSERT INTO `history` (rental_id, customer_id) values (%s,  %s)",
                    rental_id,renDate, custID );
            Boolean res4  =  sql.ExecuteSQL(SQLCom4) ;

        }



    }

    @FXML
    void click_Reject(MouseEvent event) {
        String SQLCom2 = String.format("delete from `reservation` where request_id = %s", Integer.valueOf(txtField_reqID.getText())) ;
        MySQLConnection sql = new MySQLConnection() ;
        Boolean res2  =  sql.ExecuteSQL(SQLCom2) ;
    }

    @FXML
    void click_home(MouseEvent event) throws IOException {
        allRequest.clear();
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("managerPannel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

}
