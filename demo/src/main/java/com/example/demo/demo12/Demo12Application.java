package com.example.demo.demo12;

import com.example.demo.MainWindowApplication;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;

public class Demo12Application extends Stage {
    public Demo12Application() throws IOException {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        final Button button2 = new Button("I am a button");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Thread button2thread = new Thread() {
                    @Override
                    public void run() {
                        // 这个是正确的用法
                        Platform.runLater(new Runnable() {
                            public void run() {
                                button2.setText("Now I become another button!");
                            }
                        });
                    }
                };
                button2thread.setName("button2thread");
                try {
                    button2thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                button2thread.start();
            }
        });

        final Button button = new Button("reset");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                button2.setText("I am a button");
            }
        });
        vBox.getChildren().addAll(button2, button);


        Scene scene = new Scene(vBox, 400, 300);

        this.setScene(scene);
        this.setTitle("Demo12");
    }
}
