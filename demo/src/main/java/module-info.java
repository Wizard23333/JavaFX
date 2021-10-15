module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.demo2;
    opens com.example.demo.demo2 to javafx.fxml;
    exports com.example.demo.demo1;
    opens com.example.demo.demo1 to javafx.fxml;

    exports com.example.demo.demo10;
    opens com.example.demo.demo10 to javafx.fxml;
    exports com.example.demo.demo11;
    opens com.example.demo.demo11 to javafx.fxml;
    exports com.example.demo.demo12;
    opens com.example.demo.demo12 to javafx.fxml;
}