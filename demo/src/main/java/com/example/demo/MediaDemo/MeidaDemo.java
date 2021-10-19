package com.example.demo.MediaDemo;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
//import simpleMediaPlayer.SimpleMediaPlayer;

/** 测试文件
 * */
public class MeidaDemo extends Stage {

    private static final String MEDIA_URL = "http://vjs.zencdn.net/v/oceans.mp4";

    public MeidaDemo() throws IOException {

        Media media = new Media(MEDIA_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        Button playButton = new Button(">");
        playButton.setOnAction(event -> {
            if (playButton.getText().equals(">")) {
                mediaPlayer.play();
                playButton.setText("||");
            }else {
                mediaPlayer.pause();
                playButton.setText(">");
            }
        });

        Button rewindButton = new Button("<<");
        rewindButton.setOnAction(event -> mediaPlayer.seek(Duration.ZERO));

        Slider slVolume = new Slider();
        slVolume.setPrefWidth(150);
        slVolume.setMinWidth(30);
        slVolume.setMinWidth(Region.USE_PREF_SIZE);
        slVolume.setValue(50);
        mediaPlayer.volumeProperty().bind(slVolume.valueProperty().divide(100));

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(playButton,rewindButton,new Label("Volume"),slVolume);

        BorderPane pane = new BorderPane();
        pane.setBottom(hBox);
        pane.setCenter(mediaView);

        Scene scene = new Scene(pane,1000,600);
        this.setTitle("VideoPlayer");
        this.setScene(scene);

    }

}