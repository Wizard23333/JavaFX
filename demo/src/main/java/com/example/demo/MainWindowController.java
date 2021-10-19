package com.example.demo;

import com.example.demo.AnimationDemo.AnimationDemo1;
import com.example.demo.ChartDemo.PieChartDemo;
import com.example.demo.Effect.EffectDemo;
import com.example.demo.LayoutDemo1.LayoutSampleApplication;
import com.example.demo.LayoutDemo2.LayoutSizingAligning;
import com.example.demo.LayoutDemo3.LayoutSampleCSS;
import com.example.demo.MediaDemo.MeidaDemo;
import com.example.demo.SceneGraphDemo.SceneGraph;
import com.example.demo.ThreeDModelDemo.ThreeDModelDemo;
import com.example.demo.TransformationDemo.TransformationDemo;
import com.example.demo.TransitionDemo.TransitionDemo;
import com.example.demo.WebViewDemo.WebViewDemo;
import com.example.demo.demo1.Demo1Application;
import com.example.demo.demo10.Demo10Application;
import com.example.demo.demo11.Demo11Application;
import com.example.demo.demo12.Demo12Application;
import com.example.demo.demo2.Demo2Application;
import com.example.demo.dragAndDropDemo1.HelloDragAndDrop;
import com.example.demo.enentHandleDemo.KeyboardExample;
import com.example.demo.eventFilterDemo.DraggablePanelsExample;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainWindowController {
    // 演示demo的序号
    int demoNum = -1;

    // 演示demo的列表 每新增加一个demo需要在这里添加
    ArrayList<Stage> demoList = new ArrayList<Stage>() {{
        try {
            add(new Demo1Application());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            add(new Demo2Application());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            add(new LayoutSampleApplication());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            add(new LayoutSizingAligning());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            add(new LayoutSampleCSS());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            add(new DraggablePanelsExample());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            add(new HelloDragAndDrop());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            add(new Demo10Application());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            add(new Demo11Application());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            add(new Demo12Application());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            add(new WebViewDemo());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            add(new PieChartDemo());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            add(new ThreeDModelDemo());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            add(new MeidaDemo());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            add(new SceneGraph());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            add(new TransformationDemo());
        } catch (Exception e) {
            e.printStackTrace();
            // 避免构造失败时对后续项造成影响
            add (new Stage());
        }
        try {
            add(new EffectDemo());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            add(new TransitionDemo());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            add(new AnimationDemo1());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            add(new KeyboardExample());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }};

    @FXML
    private Label welcomeText;
    @FXML
    private Label title;

    // "下一个演示" 按钮
    @FXML
    private void onNextButtonClick() {
        demoNum++;
        demoNum = demoNum >= demoList.size() ? demoNum - demoList.size() : demoNum;
        Stage demo = this.demoList.get(demoNum);
        demo.show();
        closePreStage(-1);

    }

    // "前一个演示按钮"
    @FXML
    private void onPreButtonClick() {
        if(demoNum == -1)
            demoNum = 0;
        demoNum--;
        demoNum = demoNum < 0 ? demoNum + demoList.size() : demoNum;
        Stage demo = this.demoList.get(demoNum);
        demo.show();
        closePreStage(1);
    }

    private void closePreStage(int index) {
        // 将前一个窗口关闭
        System.out.println("close");
        int curDemoNum = demoNum + index;
        curDemoNum = curDemoNum >= demoList.size() ? curDemoNum - demoList.size() : curDemoNum;
        curDemoNum = curDemoNum < 0 ? curDemoNum + demoList.size() : curDemoNum;
        Stage closeStage = this.demoList.get(curDemoNum);
        closeStage.close();
    }

    @FXML
    private void onMenuClick0(){
        demoNum = 0;
        Stage demo = this.demoList.get(demoNum);
        demo.show();
    }

    @FXML
    private void onMenuClick1(){
        demoNum = 1;
        Stage demo = this.demoList.get(demoNum);
        demo.show();
    }

    @FXML
    private void onMenuClick2() throws Exception {
        demoNum = 2;
        Stage demo = this.demoList.get(demoNum);
        demo.show();
    }

    @FXML
    private void onMenuClick3() throws Exception {
        demoNum = 3;
        Stage demo = this.demoList.get(demoNum);
        demo.show();
    }

    @FXML
    private void onMenuClick4() throws Exception {
        demoNum = 4;
        Stage demo = this.demoList.get(demoNum);
        demo.show();
    }

    @FXML
    private void onMenuClick5() throws Exception {
        demoNum = 5;
        Stage demo = this.demoList.get(demoNum);
        demo.show();
    }

    @FXML
    private void onMenuClick6() throws Exception {
        demoNum = 6;
        Stage demo = this.demoList.get(demoNum);
        demo.show();
    }

    @FXML
    private void onMenuClick7() throws Exception {
        demoNum = 7;
        Stage demo = this.demoList.get(demoNum);
        demo.show();
    }

    @FXML
    private void onMenuClick8() throws Exception {
        demoNum = 8;
        Stage demo = this.demoList.get(demoNum);
        demo.show();
    }

    @FXML
    private void onMenuClick9() throws Exception {
        demoNum = 9;
        Stage demo = this.demoList.get(demoNum);
        demo.show();
    }
    @FXML
    private void onMediaDemo() throws Exception {
        demoNum = 13;
        Stage demo = this.demoList.get(demoNum);
        demo.show();
    }
    @FXML
    private void onSceneGraphDemo() throws Exception {
        demoNum = 14;
        Stage demo = this.demoList.get(demoNum);
        demo.show();
    }
    @FXML
    private void onTransformation() throws Exception {
        demoNum = 15;
        Stage demo = this.demoList.get(demoNum);
        demo.show();
    }
    @FXML
    private void onEffect() throws Exception {
        demoNum = 16;
        Stage demo = this.demoList.get(demoNum);
        demo.show();
    }
    @FXML
    private void onTransition() throws Exception {
        demoNum = 17;
        Stage demo = this.demoList.get(demoNum);
        demo.show();
    }
    @FXML
    private void onAnimation() throws Exception {
        demoNum = 18;
        Stage demo = this.demoList.get(demoNum);
        demo.show();
    }
    @FXML
    private void onEventHandleDemo() throws Exception {
        demoNum = 19;
        Stage demo = this.demoList.get(demoNum);
        demo.show();
    }
}