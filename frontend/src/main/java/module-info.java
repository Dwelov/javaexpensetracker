module com.example.frontend {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.swing;

    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.example.frontend to javafx.fxml, javafx.base;
    exports com.example.frontend;
}