package com.example.demo.demo3;

import com.example.demo.MainWindowApplication;
import com.example.demo.MainWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Demo3Application extends Stage {
    public Demo3Application() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainWindowController.class.getResource("demo3-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 480, 310);
        this.setScene(scene);
    }

}
