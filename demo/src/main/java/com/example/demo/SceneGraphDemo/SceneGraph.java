package com.example.demo.SceneGraphDemo;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class SceneGraph extends Stage {
    public SceneGraph() throws IOException{
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500, Color.BLACK);
        Rectangle r = new Rectangle(0, 0, 250, 250);
        r.setFill(Color.BLUE);
        root.getChildren().add(r);

        TranslateTransition translate =
                new TranslateTransition(Duration.millis(750));
        translate.setToX(390);
        translate.setToY(390);

        FillTransition fill = new FillTransition(Duration.millis(750));
        fill.setToValue(Color.RED);

        RotateTransition rotate = new RotateTransition(Duration.millis(750));
        rotate.setToAngle(360);

        ScaleTransition scale = new ScaleTransition(Duration.millis(750));
        scale.setToX(0.1);
        scale.setToY(0.1);

        ParallelTransition transition = new ParallelTransition(r,
                translate, fill, rotate, scale);
        transition.setCycleCount(Timeline.INDEFINITE);
        transition.setAutoReverse(true);
        transition.play();

        this.setTitle("JavaFX Scene Graph Demo");
        this.setScene(scene);
    }

}
