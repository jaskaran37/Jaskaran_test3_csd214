module com.example.jaskaran_test3_sem3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.jaskaran_test3_sem3 to javafx.fxml;
    exports com.example.jaskaran_test3_sem3;
}