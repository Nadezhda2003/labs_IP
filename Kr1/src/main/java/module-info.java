module com.example.kr1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kr1 to javafx.fxml;
    exports com.example.kr1;
}