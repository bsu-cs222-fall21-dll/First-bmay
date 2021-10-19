module com.example.projectoneptwo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires json.path;

    opens com.example.projectoneptwo to javafx.fxml;
    exports com.example.projectoneptwo;
}