package com.example.demo.AnimationDemo;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class AnimationDemo1 extends Stage {

    private SequentialTransition sequentialTransition;
    private SequentialTransition parallelTransition;

    private Timeline timeline;
    private AnimationTimer timer;

    //variable for storing actual frame
    private Integer i=0;
    public AnimationDemo1() throws IOException {

        this.setTitle("Interpolator");
        final Group group = new Group();
        final Scene scene = new Scene(group, 600, 450);
        this.setScene(scene);

        final Rectangle rect = new Rectangle(100, 200, 100, 50);
        rect.setFill(Color.BROWN);

        group.getChildren().add(rect);


        final Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);

        final KeyValue keyValue1 = new KeyValue(rect.xProperty(), 300);
        AnimationBooleanInterpolator yInterp = new AnimationBooleanInterpolator();
        final KeyValue keyValue2 = new KeyValue(rect.yProperty(), 0., yInterp);


        final KeyFrame kf1 = new KeyFrame(Duration.millis(2000), keyValue1);
        final KeyFrame kf2 = new KeyFrame(Duration.millis(2000), keyValue2);
        timeline.getKeyFrames().add(kf1);
        timeline.getKeyFrames().add(kf2);
        timeline.play();


//        Group p = new Group();
//        Scene scene = new Scene(p);
//        this.setScene(scene);
//        this.setWidth(500);
//        this.setHeight(500);
//        p.setTranslateX(80);
//        p.setTranslateY(80);
//
//
//        //create a circle with effect
//        final Circle circle = new Circle(20,  Color.rgb(156,216,255));
//        circle.setEffect(new Lighting());
//        //create a text inside a circle
//        final Text text = new Text (i.toString());
//        text.setStroke(Color.BLACK);
//        //create a layout for circle with text inside
//        final StackPane stack = new StackPane();
//        stack.getChildren().addAll(circle, text);
//        stack.setLayoutX(30);
//        stack.setLayoutY(30);
//
//        p.getChildren().add(stack);
//
//        //create a timeline for moving the circle
//
//        timeline = new Timeline();
//        timeline.setCycleCount(Timeline.INDEFINITE);
//        timeline.setAutoReverse(true);
//
//        //one can add a specific action when each frame is started. There are one or more frames during executing one KeyFrame depending on set Interpolator.
//        timer = new AnimationTimer() {
//            @Override
//            public void handle(long l) {
//                text.setText(i.toString());
//                i++;
//            }
//
//        };
//
//        //create a keyValue with factory: scaling the circle 2times
//        KeyValue keyValueX = new KeyValue(stack.scaleXProperty(), 2);
//        KeyValue keyValueY = new KeyValue(stack.scaleYProperty(), 2);
//
//        //create a keyFrame, the keyValue is reached at time 2s
//        Duration duration = Duration.millis(2000);
//        //one can add a specific action when the keyframe is reached
//        EventHandler<ActionEvent> onFinished = new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent t) {
//                stack.setTranslateX(java.lang.Math.random()*200-100);
//                //reset counter
//                i = 0;
//            }
//        };
//
//
//
//
//        KeyFrame keyFrame = new KeyFrame(duration, onFinished , keyValueX, keyValueY);
//
//        //add the keyframe to the timeline
//        timeline.getKeyFrames().add(keyFrame);
//
//        timeline.play();
//        timer.start();

    }


}
