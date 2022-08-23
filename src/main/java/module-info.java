module com.example.buttonclickinggame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.buttonclickinggame to javafx.fxml;
    exports com.example.buttonclickinggame;
}