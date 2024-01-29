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

import static com.example.movierental.bstSelActor3.bestSellingActorT3;
import static com.example.movierental.bstSelFilm2.bestSellingFilmT2;
import static com.example.movierental.bstSelGenre1.bestSellingGenreT1;
import static com.example.movierental.payInfo.customerPaymentINFO;

public class managerBestSelPage {

    @FXML
    private Button btn1;

    @FXML
    private TableColumn<bstSelActor3, String> colFirstName3;

    @FXML
    private TableColumn<bstSelGenre1, String> colGenreName1;

    @FXML
    private TableColumn<bstSelFilm2, String> colTitle2;

    @FXML
    private TableColumn<bstSelGenre1, Integer> colTotalSales1;

    @FXML
    private TableColumn<bstSelFilm2, Integer> colTotalSales2;

    @FXML
    private TableColumn<bstSelActor3, Integer> colTotalSales3;

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
    private TableView<bstSelGenre1> table1;

    @FXML
    private TableView<bstSelFilm2> table2;

    @FXML
    private TableView<bstSelActor3> table3;

    ObservableList<bstSelGenre1> list1 = FXCollections.observableArrayList(bestSellingGenreT1) ;
    ObservableList<bstSelFilm2> list2 = FXCollections.observableArrayList(bestSellingFilmT2) ;
    ObservableList<bstSelActor3> list3 = FXCollections.observableArrayList(bestSellingActorT3) ;

    public void initialize() {
        colGenreName1.setCellValueFactory(new PropertyValueFactory<bstSelGenre1, String>("genreName"));
        colTotalSales1.setCellValueFactory(new PropertyValueFactory<bstSelGenre1, Integer>("totalState1"));
        //
        colTitle2.setCellValueFactory(new PropertyValueFactory<bstSelFilm2, String>("title"));
        colTotalSales2.setCellValueFactory(new PropertyValueFactory<bstSelFilm2, Integer>("totalState2"));
        //
        colFirstName3.setCellValueFactory(new PropertyValueFactory<bstSelActor3, String>("firstName"));
        colTotalSales3.setCellValueFactory(new PropertyValueFactory<bstSelActor3, Integer>("totalState3"));

        table1.setItems(list1);
        table2.setItems(list2);
        table3.setItems(list3);

    }


        @FXML
    void click_home(MouseEvent event) throws IOException {
        bestSellingGenreT1.clear();
        bestSellingFilmT2.clear();
        bestSellingActorT3.clear();

        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("managerPannel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Movie Rental");
        stage.setScene(scene);
        stage.show();
    }

}
