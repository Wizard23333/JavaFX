package com.example.demo.demo2;

import com.example.demo.MainWindowApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Demo2Application extends Stage{
    public Demo2Application() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainWindowApplication.class.getResource("demo2-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 480, 310);
        this.setScene(scene);

    }

}
