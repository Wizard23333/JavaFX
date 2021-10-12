package com.example.demo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindowApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainWindowApplication.class.getResource("main-window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960, 620);
        primaryStage.setTitle("演示控制台");
        primaryStage.setScene(scene);

        // 设置同步关闭： 关闭主窗口后子窗口也关闭
        primaryStage.setOnCloseRequest(event -> Platform.exit());

//        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//            public void handle(WindowEvent event) {
//                Platform.exit();
//            }
//        });
        primaryStage.show();
    }
}