package com.example.demo.Effect;

import com.example.demo.MainWindowApplication;
import com.example.demo.MainWindowController;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.io.IOException;

public class EffectDemo extends Stage {
    public EffectDemo() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainWindowController.class.getResource("demo3-view.fxml"));

        Scene scene = new Scene(new Group(), 920, 680);
        ObservableList<Node> content = ((Group)scene.getRoot()).getChildren();
        /// Perspective
        content.add(perspective());
        /// DropShadow
        content.add(dropShadow());
        /// BlendMode
        content.add(blendMode());
        /// Bloom
        content.add(bloom());
        /// BoxBlur
        content.add(boxBlur());
        /// DisplacementMap
        content.add(displacementMap());
        /// InnerShadow
        content.add(innerShadow());
        /// Lighting
        content.add(lighting());
        /// MotionBlur
        content.add(motionBlur());
        /// Reflection
        content.add(reflection());
        /// GaussianBlur
        content.add(gaussianBlur());
        /// DistantLight
        content.add(distantLight());

        //content.add(chainEffects());
        this.setTitle("Effect");
        this.setScene(scene);
    }
    static Node distantLight() {
        Light.Distant light = new Light.Distant();
        light.setAzimuth(-135.0f);
        light.setElevation(30.0f);

        Lighting l = new Lighting();
        l.setLight(light);
        l.setSurfaceScale(5.0f);

        final Text t = new Text();
        t.setText("Distant Light");
        t.setFill(Color.RED);
        t.setFont(Font.font("null", FontWeight.BOLD, 70));
        t.setX(10.0f);
        t.setY(50.0f);
        t.setTextOrigin(VPos.TOP);

        t.setEffect(l);

        final Rectangle r = new Rectangle();
        r.setFill(Color.BLACK);

        Group g = new Group();
        g.getChildren().add(r);
        g.getChildren().add(t);

        g.setTranslateY(460);

        return g;
    }

    static Node perspective() {
        Group g = new Group();
        PerspectiveTransform pt = new PerspectiveTransform();
        pt.setUlx(10.0f);
        pt.setUly(10.0f);
        pt.setUrx(210.0f);
        pt.setUry(40.0f);
        pt.setLrx(210.0f);
        pt.setLry(60.0f);
        pt.setLlx(10.0f);
        pt.setLly(90.0f);

        g.setEffect(pt);
        g.setCache(true);

        Rectangle r = new Rectangle();
        r.setX(10.0f);
        r.setY(10.0f);
        r.setWidth(280.0f);
        r.setHeight(80.0f);
        r.setFill(Color.DARKBLUE);

        Text t = new Text();
        t.setX(20.0f);
        t.setY(65.0f);
        t.setText("Perspective");
        t.setFill(Color.RED);
        t.setFont(Font.font("null", FontWeight.BOLD, 36));

        g.getChildren().add(r);
        g.getChildren().add(t);
        return g;
    }

    static Node gaussianBlur() {
        Text t2 = new Text();
        t2.setX(10.0f);
        t2.setY(140.0f);
        t2.setCache(true);
        t2.setText("Gaussian Blur");
        t2.setFill(Color.RED);
        t2.setFont(Font.font("null", FontWeight.BOLD, 36));
        t2.setEffect(new GaussianBlur());
        return t2;
    }

    static Node reflection() {
        Text t = new Text();
        t.setX(10.0f);
        t.setY(50.0f);
        t.setCache(true);
        t.setText("Reflections on JavaFX...");
        t.setFill(Color.RED);
        t.setFont(Font.font("null", FontWeight.BOLD, 30));

        Reflection r = new Reflection();
        r.setFraction(0.7f);

        t.setEffect(r);

        t.setTranslateY(400);
        return t;
    }

    static Node motionBlur() {
        Text t = new Text();
        t.setX(20.0f);
        t.setY(80.0f);
        t.setText("Motion Blur");
        t.setFill(Color.RED);
        t.setFont(Font.font("null", FontWeight.BOLD, 60));

        MotionBlur mb = new MotionBlur();
        mb.setRadius(15.0f);
        mb.setAngle(45.0f);

        t.setEffect(mb);

        t.setTranslateX(520);
        t.setTranslateY(100);

        return t;
    }

    static Node lighting() {
        Light.Distant light = new Light.Distant();
        light.setAzimuth(-135.0f);

        Lighting l = new Lighting();
        l.setLight(light);
        l.setSurfaceScale(5.0f);

        Text t = new Text();
        t.setText("JavaFX\nLighting!");
        t.setFill(Color.RED);
        t.setFont(Font.font("null", FontWeight.BOLD, 70));
        t.setX(500.0f);
        t.setY(100.0f);
        t.setTextOrigin(VPos.TOP);

        t.setEffect(l);

        t.setTranslateX(0);
        t.setTranslateY(320);

        return t;
    }

    static Node innerShadow() {
        InnerShadow is = new InnerShadow();
        is.setOffsetX(2.0f);
        is.setOffsetY(2.0f);

        Text t = new Text();
        t.setEffect(is);
        t.setX(20);
        t.setY(100);
        t.setText("Inner Shadow");
        t.setFill(Color.RED);
        t.setFont(Font.font("null", FontWeight.BOLD, 80));

        t.setTranslateX(300);
        t.setTranslateY(300);

        return t;
    }

    static Node displacementMap() {
        int w = 220;
        int h = 100;
        FloatMap map = new FloatMap();
        map.setWidth(w);
        map.setHeight(h);

        for (int i = 0; i < w; i++) {
            double v = (Math.sin(i / 50.0 * Math.PI) - 0.5) / 40.0;
            for (int j = 0; j < h; j++) {
                map.setSamples(i, j, 0.0f, (float) v);
            }
        }

        Group g = new Group();
        DisplacementMap dm = new DisplacementMap();
        dm.setMapData(map);

        Rectangle r = new Rectangle();
        r.setX(20.0f);
        r.setY(20.0f);
        r.setWidth(w);
        r.setHeight(h);
        r.setFill(Color.BLUE);

        g.getChildren().add(r);

        Text t = new Text();
        t.setX(40.0f);
        t.setY(80.0f);
        t.setText("Wavy Text");
        t.setFill(Color.YELLOW);
        t.setFont(Font.font("null", FontWeight.BOLD, 36));

        g.getChildren().add(t);

        g.setEffect(dm);
        g.setCache(true);

        g.setTranslateX(400);
        g.setTranslateY(200);

        return g;
    }

    static Node boxBlur() {
        Text t = new Text();
        t.setText("Blurry Text!");
        t.setFill(Color.RED);
        t.setFont(Font.font("null", FontWeight.BOLD, 36));
        t.setX(10);
        t.setY(40);

        BoxBlur bb = new BoxBlur();
        bb.setWidth(5);
        bb.setHeight(5);
        bb.setIterations(3);

        t.setEffect(bb);
        t.setTranslateX(300);
        t.setTranslateY(100);

        return t;
    }

    static Node blendMode() {

        Rectangle r = new Rectangle();
        r.setX(590);
        r.setY(50);
        r.setWidth(50);
        r.setHeight(50);
        r.setFill(Color.BLUE);

        Circle c = new Circle();
        c.setFill(Color.RED);
        c.setCenterX(590);
        c.setCenterY(50);
        c.setRadius(25);
        c.setBlendMode(BlendMode.SRC_ATOP);

        Group g = new Group();
        g.setBlendMode(BlendMode.SRC_OVER);
        g.getChildren().add(r);
        g.getChildren().add(c);
        return g;
    }

    static Node dropShadow() {
        Group g = new Group();
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        Text t = new Text();
        t.setEffect(ds);
        t.setCache(true);
        t.setX(10.0f);
        t.setY(270.0f);
        t.setFill(Color.RED);
        t.setText("JavaFX drop shadow...");
        t.setFont(Font.font("null", FontWeight.BOLD, 32));

        DropShadow ds1 = new DropShadow();
        ds1.setOffsetY(4.0f);

        Circle c = new Circle();
        c.setEffect(ds1);
        c.setCenterX(50.0f);
        c.setCenterY(325.0f);
        c.setRadius(30.0f);
        c.setFill(Color.ORANGE);
        c.setCache(true);

        g.getChildren().add(t);
        g.getChildren().add(c);
        return g;
    }

    static Node bloom() {
        Group g = new Group();

        Rectangle r = new Rectangle();
        r.setX(10);
        r.setY(10);
        r.setWidth(160);
        r.setHeight(80);
        r.setFill(Color.DARKBLUE);

        Text t = new Text();
        t.setText("Bloom!");
        t.setFill(Color.YELLOW);
        t.setFont(Font.font("null", FontWeight.BOLD, 36));
        t.setX(25);
        t.setY(65);

        g.setCache(true);
        //g.setEffect(new Bloom());
        Bloom bloom = new Bloom();
        bloom.setThreshold(1.0);
        g.setEffect(bloom);
        g.getChildren().add(r);
        g.getChildren().add(t);
        g.setTranslateX(350);
        return g;
    }
    static Node chainEffects() {

        Rectangle rect = new Rectangle();
        rect.setFill(Color.RED);
        rect.setWidth(200);
        rect.setHeight(100);
        rect.setX(60.0f);
        rect.setY(60.0f);

        DropShadow ds = new DropShadow();
        ds.setOffsetY(5.0);
        ds.setOffsetX(5.0);
        ds.setColor(Color.GRAY);


        Reflection reflection = new Reflection();

        ds.setInput(reflection);
        rect.setEffect(ds);

        return rect;
    }
}
