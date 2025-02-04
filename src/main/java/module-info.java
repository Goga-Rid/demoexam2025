module com.example.demoexam2025 {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;

    requires org.controlsfx.controls;
    requires java.sql;

    opens com.example.demoexam2025 to javafx.fxml;
    exports com.example.demoexam2025;
}