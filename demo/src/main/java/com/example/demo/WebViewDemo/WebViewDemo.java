package com.example.demo.WebViewDemo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class WebViewDemo extends Stage {

    private static final String htmlstring = "<html><h1>JavaFX</h1><h2>Hello</h2></html>";

    public WebViewDemo() {

        Label inputlabel = new Label("URL box:");
        inputlabel.getStyleClass().add("label.css");
        TextField addressBar = new TextField("https://www.tongji.edu.cn/");

        //三个按钮
        Button buttonURL = new Button("Load Website");
        Button buttonHtmlString = new Button("Load HTML String");
        Button buttonHtmlFile = new Button("Load HTML File");

        //CSS设置样式
        buttonURL.setStyle("-fx-background-color:#3838;");
        buttonHtmlString.setStyle("-fx-background-color:#3838;");
        buttonHtmlFile.setStyle("-fx-background-color:#3838;");

        Label stateLabel = new Label();
        stateLabel.setTextFill(Color.RED);
        ProgressBar progressBar = new ProgressBar();

        //WebView框
        WebView browser = new WebView();
        WebEngine webEngine = browser.getEngine();

        webEngine.setJavaScriptEnabled(true);

        // A Worker load the page
        Worker<Void> worker = webEngine.getLoadWorker();

        // Listening to the status of worker
        worker.stateProperty().addListener(new ChangeListener<State>() {

            @Override
            public void changed(ObservableValue<? extends State> observable, State oldValue, State newValue) {
                stateLabel.setText("Loading state: " + newValue.toString());
                if (newValue == Worker.State.SUCCEEDED) {
                    stateLabel.setText("Finish!");
                }
            }
        });

        // Bind the progress property of ProgressBar
        // with progress property of Worker
        progressBar.progressProperty().bind(worker.progressProperty());

        //点击响应,加载网页
        buttonURL.setOnAction(event -> {
            String url = addressBar.getText();
            webEngine.load(url);
        });

        //加载HTML字符串
        buttonHtmlString.setOnAction(event -> {
            String html = htmlstring;
            webEngine.loadContent(html);
        });

        //加载外部HTML文件
        buttonHtmlFile.setOnAction(event -> {
            try {
                File file = new File("src/main/resources/com/example/demo/WebViewDemo/test.html");
                URL url = file.toURI().toURL();
                System.out.println("Local URL: " + url.toString());
                webEngine.load(url.toString());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        });

        //布局
        VBox root = new VBox();
        root.setPadding(new Insets(5));
        root.setSpacing(5);

        VBox child1 = new VBox();
        child1.setSpacing(5);
        child1.getChildren().addAll(inputlabel, addressBar);

        HBox child2 = new HBox();
        child2.setSpacing(7);
        child2.getChildren().addAll(buttonURL,progressBar,stateLabel);

        root.getChildren().addAll(child1, child2, buttonHtmlString, buttonHtmlFile, browser);

        Scene scene = new Scene(root);
        this.setScene(scene);


    }

}
