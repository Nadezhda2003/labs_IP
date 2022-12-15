module com.example.tablewithsql {
    requires java.sql;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    exports com.example.tablewithsql;
    exports com.example.tablewithsql.Person;

    opens com.example.tablewithsql to javafx.fxml;
}
