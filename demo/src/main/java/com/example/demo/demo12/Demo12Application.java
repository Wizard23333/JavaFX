package com.example.demo.demo12;

import com.example.demo.MainWindowApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Demo12Application extends Stage {
    public Demo12Application() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainWindowApplication.class.getResource("demo12-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        this.setScene(scene);
        this.setTitle("Demo12");
    }
}
