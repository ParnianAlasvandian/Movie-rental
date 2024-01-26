module com.example.movierental {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.movierental to javafx.fxml;
    exports com.example.movierental;
}