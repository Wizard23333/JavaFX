package com.example.demo.demo10;

import com.example.demo.MainWindowApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Demo10Application extends Stage {
    public Demo10Application() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainWindowApplication.class.getResource("demo10-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        this.setScene(scene);
        this.setTitle("demo10");
    }
}
