module com.example.demoexam2025 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.demoexam2025 to javafx.fxml;
    exports com.example.demoexam2025;
}