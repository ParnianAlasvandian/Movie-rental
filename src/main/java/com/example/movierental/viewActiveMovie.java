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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;



import static com.example.movierental.inventory.allInventory;
import static com.example.movierental.rental.custViewActiveMovie;

public class viewActiveMovie {

    @FXML
    private Button btn_home;

    @FXML
    private TableColumn<inventory, Integer> colFilmID;

    @FXML
    private TableColumn<inventory, Integer> colInvID;

    @FXML
    private TableColumn<inventory, Integer> colStoreID;

    @FXML
    private TableColumn<rental, String> colRemaining_time;

    @FXML
    private TableColumn<rental, String> colRentalDate;

    @FXML
    private TableColumn<rental, String> colReturnDate;

    @FXML
    private TableColumn<rental, Integer> colRentalID;

    @FXML
    private DatePicker currentDate;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private Label lbl4;

    @FXML
    private Rectangle rectangle;

    @FXML
    private TableView<inventory> table1;

    @FXML
    private TableView<rental> table2;

    ObservableList<inventory> list1 = FXCollections.observableArrayList(allInventory) ;
    ObservableList<rental> list2 = FXCollections.observableArrayList(custViewActiveMovie) ;

    public void initialize() {
        colInvID.setCellValueFactory(new PropertyValueFactory<inventory, Integer>("inventory_id"));
        colFilmID.setCellValueFactory(new PropertyValueFactory<inventory, Integer>("film_id"));
        colStoreID.setCellValueFactory(new PropertyValueFactory<inventory, Integer>("store_id"));
        //
        colRentalDate.setCellValueFactory(new PropertyValueFactory<rental, String>("rental_date"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<rental, String>("return_date"));
        colRemaining_time.setCellValueFactory(new PropertyValueFactory<rental, String>("remaining_time"));
        colRentalID.setCellValueFactory(new PropertyValueFactory<rental, Integer>("request_id"));

        table1.setItems(list1);
        table2.setItems(list2);
    }

    String toDay ;

    @FXML
    void ac_currentDate(ActionEvent event) throws IOException {
        toDay = currentDate.getValue().toString() ;
        //
        MySQLConnection sql2 = new MySQLConnection() ;
        String s2 = String.format("select rental_date , return_date , DATEDIFF(return_date, '%s') as remaining_time , store_id\n" +
                "from rental \n" +
                "where customer_id = %s  ",toDay,HelloApplication.id.get(0)) ;

        ResultSet res2 = sql2.ExecuteQuery(s2);

        if (res2==null)
            System.out.println("-Error !");
        else
            while (true)
            {
                try {
                    if (!res2.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    custViewActiveMovie.add(new rental(res2.getString("rental_date"),res2.getString("return_date"),res2.getString("remaining_time"),res2.getInt("store_id"))) ;
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }

        ////


    }


    @FXML
    void click_home(MouseEvent event) throws IOException {
        allInventory.clear();
        custViewActiveMovie.clear();
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("customerPannel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

}
