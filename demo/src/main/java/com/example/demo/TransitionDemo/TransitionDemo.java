package com.example.demo.TransitionDemo;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class TransitionDemo extends Stage {

    private SequentialTransition sequentialTransition;
    private SequentialTransition parallelTransition;
    public TransitionDemo()throws IOException {
        this.setTitle("Transitions");
        final Scene scene = new Scene(new Group(), 600, 450);
        scene.setFill(Color.WHITE);

        final Rectangle rectBasicTimeline = new Rectangle(100, 50, 100, 50);
        rectBasicTimeline.setFill(Color.BROWN);

        final Rectangle rectFade = new Rectangle(10, 150, 100, 100);
        rectFade.setArcHeight(20);
        rectFade.setArcWidth(20);
        rectFade.setFill(Color.RED);

        final Rectangle rectFadeAll = new Rectangle(0, 0, 600, 450);
        rectFadeAll.setFill(Color.GREY);

        final Rectangle rectPath = new Rectangle(0, 0, 40, 40);
        rectPath.setArcHeight(10);
        rectPath.setArcWidth(10);
        rectPath.setFill(Color.ORANGE);

        Rectangle rectParallel = new Rectangle(10, 200, 50, 50);
        rectParallel.setArcHeight(15);
        rectParallel.setArcWidth(15);
        rectParallel.setFill(Color.DARKBLUE);
        rectParallel.setTranslateX(50);
        rectParallel.setTranslateY(75);

        Rectangle rectSeq = new Rectangle(25, 25, 50, 50);
        rectSeq.setArcHeight(15);
        rectSeq.setArcWidth(15);
        rectSeq.setFill(Color.DARKBLUE);
        rectSeq.setTranslateX(50);
        rectSeq.setTranslateY(50);


        ((Group) scene.getRoot()).getChildren().addAll(rectBasicTimeline, rectFade, rectPath, rectParallel, rectSeq);
        this.setScene(scene);
        //stage.show();

        final Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        final KeyValue kv = new KeyValue(rectBasicTimeline.xProperty(), 300, Interpolator.EASE_BOTH);
        final KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();


        FadeTransition ft = new FadeTransition(Duration.millis(3000), rectFade);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        Path path = new Path();
        path.getElements().add(new MoveTo(20, 20));
        path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
        path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(4000));
        pathTransition.setPath(path);
        pathTransition.setNode(rectPath);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(true);
        pathTransition.play();

        FadeTransition fadeTransition =
                new FadeTransition(Duration.millis(1000), rectSeq);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0.3f);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(true);

        TranslateTransition translateTransition =
                new TranslateTransition(Duration.millis(2000), rectSeq);
        translateTransition.setFromX(50);
        translateTransition.setToX(375);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(true);

        RotateTransition rotateTransition =
                new RotateTransition(Duration.millis(2000), rectSeq);
        rotateTransition.setByAngle(180f);
        rotateTransition.setCycleCount(4);
        rotateTransition.setAutoReverse(true);

        ScaleTransition scaleTransition =
                new ScaleTransition(Duration.millis(2000), rectSeq);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(2);
        scaleTransition.setToY(2);
        scaleTransition.setCycleCount(1);
        scaleTransition.setAutoReverse(true);

        // create a sequential transition to do four transitions one after another
        sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(
                fadeTransition,
                translateTransition,
                rotateTransition,
                scaleTransition);
        sequentialTransition.setCycleCount(Timeline.INDEFINITE);
        sequentialTransition.setAutoReverse(true);
        sequentialTransition.play();
    }
}
