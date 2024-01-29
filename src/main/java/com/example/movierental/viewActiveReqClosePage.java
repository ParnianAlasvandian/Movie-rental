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
import static com.example.movierental.rental.viewActiveReqClose;

public class viewActiveReqClosePage {

    @FXML
    private Button btnDone;

    @FXML
    private Button btnHome;

    @FXML
    private TableColumn<rental, Integer> colInventory;

    @FXML
    private TableColumn<rental, String> colRentalDate;

    @FXML
    private TableColumn<rental, Integer> colRentalID;

    @FXML
    private TableColumn<rental, Integer> colStaffID;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private Label lbl4;

    @FXML
    private Label lbl5;

    @FXML
    private Label lbl9;

    @FXML
    private Rectangle rect;

    @FXML
    private TableView<rental> table;

    @FXML
    private TextField textFieldRate;

    @FXML
    private DatePicker todayDate;

    @FXML
    private TextField txtFieldRenID;


    ObservableList<rental> list = FXCollections.observableArrayList(viewActiveReqClose) ;
    public void initialize() {
        colInventory.setCellValueFactory(new PropertyValueFactory<rental, Integer>("inventory_id"));
        colRentalID.setCellValueFactory(new PropertyValueFactory<rental, Integer>("request_id"));
        colStaffID.setCellValueFactory(new PropertyValueFactory<rental, Integer>("staff_id"));
        colRentalDate.setCellValueFactory(new PropertyValueFactory<rental, String>("rental_date"));
        table.setItems(list);
    }


    String toDay ;
    @FXML
    void ac_todayDate(ActionEvent event) {
        toDay = todayDate.getValue().toString() ;
    }



    @FXML
    void clickDone(MouseEvent event) throws SQLException, IOException {
        MySQLConnection sql = new MySQLConnection() ;
        String SQLCom3 = String.format("select DATEDIFF(return_date, rental_date) as duration\n" +
                "from rental\n" +
                "where rental_id = %s",Integer.valueOf(txtFieldRenID.getText() )) ;
        ResultSet res2 = sql.ExecuteQuery(SQLCom3);
        if (res2.next()) {
            int duration1 = res2.getInt("duration");  //تایم اولی که وارد کرده بود

            //
            String SQLCom5 = String.format("update rental set return_date = '%s' where rental_id = %s", toDay, Integer.valueOf(txtFieldRenID.getText()));
            Boolean res5 = sql.ExecuteSQL(SQLCom5);
            if (res5) {
                String SQLCom4 = String.format("select DATEDIFF(return_date, rental_date) as duration\n" +
                        "from rental\n" +
                        "where rental_id = %s",Integer.valueOf(txtFieldRenID.getText() )) ;
                ResultSet res4 = sql.ExecuteQuery(SQLCom4);
                if (res4.next()) {
                    int duration2 = res2.getInt("duration");  // اختلاف تایمی که الان تحویل داده
                    if (duration2 > duration1 || duration1 > 14 || duration2 > 14) {  // delay
                        // delay
                        int payment = (3 * (duration2 - duration1)) + (2 * duration1);
                        String SQLCom6 = String.format("update customer set delayNumb =+1 where customer_id = %s ", HelloApplication.id.get(0));
                        Boolean res6 = sql.ExecuteSQL(SQLCom6);
                        if (res6) {
                            String SQLCom7 = String.format("select delayNumb from customer where customer_id = %s ", HelloApplication.id.get(0));
                            ResultSet res7 = sql.ExecuteQuery(SQLCom7);
                            if (res7.next()) {
                                int delayNumb = res7.getInt("delayNumb");
                                if (delayNumb > 10) {
                                    String SQLCom8 = String.format("update customer set active = %s where customer_id = %s ", 0, HelloApplication.id.get(0));
                                    Boolean res8 = sql.ExecuteSQL(SQLCom8);
                                }

                                String SQLCom8 = String.format("update history set payment = %s and rete = %s and status = %s where rental_id = %s", payment, Integer.valueOf(textFieldRate.getText()), 1, Integer.valueOf(txtFieldRenID.getText()));
                                Boolean res8 = sql.ExecuteSQL(SQLCom8);
                                if (res8) {
                                    Parent parent = FXMLLoader.load(HelloApplication.class.getResource("successfulCustomerPage.fxml"));
                                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                    Scene scene = new Scene(parent);
                                    stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
                                    stage.setTitle("Movie Rental");
                                    stage.setScene(scene);
                                    stage.show();
                                }

                            }


                        }
                    }
                    else {
                        int payment = 2 * duration2 ;
                        String SQLCom6 = String.format("update history set payment = %s and rete = %s and status = %s where rental_id = %s", payment,Integer.valueOf(textFieldRate.getText()),1, Integer.valueOf(txtFieldRenID.getText()));
                        Boolean res6 = sql.ExecuteSQL(SQLCom6);
                        if (res6){
                            viewActiveReqClose.clear();
                            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("successfulCustomerPage.fxml"));
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            Scene scene = new Scene(parent);
                            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
                            stage.setTitle("Movie Rental");
                            stage.setScene(scene);
                            stage.show();
                        }
                    }
                }
            }
        }
        viewActiveReqClose.clear();
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("errorCustomerPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void clickHome(MouseEvent event) throws IOException {
            viewActiveReqClose.clear();
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("customerPannel.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("Movie Rental");
            stage.setScene(scene);
            stage.show();
    }
}
