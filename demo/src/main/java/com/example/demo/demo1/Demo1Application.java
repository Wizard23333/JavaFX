package com.example.demo.demo1;

import com.example.demo.MainWindowApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class Demo1Application extends Stage {
    public Demo1Application() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainWindowApplication.class.getResource("demo1-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 480, 310);

        Label label1 = new Label("I'm a label created by code");
        label1.setFont(new Font("Arial", 30));
        label1.setTextFill(Color.web("#0076a3"));


        // 在这里修改每个演示的内容
        // 添加各种的功能演示

        //scene.
        this.setScene(new Scene(label1));
    }
}
