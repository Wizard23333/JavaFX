package com.example.demo.demo11;

import com.example.demo.MainWindowApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Demo11Application extends Stage {
    public Demo11Application() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainWindowApplication.class.getResource("demo11-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        this.setScene(scene);
        this.setTitle("Demo11");
    }
}
