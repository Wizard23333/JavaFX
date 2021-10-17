package com.example.demo;

import com.example.demo.ChartDemo.PieChartDemo;
import com.example.demo.LayoutDemo1.LayoutSampleApplication;
import com.example.demo.LayoutDemo2.LayoutSizingAligning;
import com.example.demo.LayoutDemo3.LayoutSampleCSS;
import com.example.demo.ThreeDModelDemo.ThreeDModelDemo;
import com.example.demo.WebViewDemo.WebViewDemo;
import com.example.demo.demo1.Demo1Application;
import com.example.demo.demo10.Demo10Application;
import com.example.demo.demo11.Demo11Application;
import com.example.demo.demo12.Demo12Application;
import com.example.demo.demo2.Demo2Application;
import com.example.demo.demo3.Demo3Application;
import com.example.demo.dragAndDropDemo1.HelloDragAndDrop;
import com.example.demo.eventFilterDemo.DraggablePanelsExample;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainWindowController {
    // 演示demo的序号
    int demoNum = 0;

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
    }};

    @FXML
    private Label welcomeText;
    @FXML
    private Label title;

    // "下一个演示" 按钮
    @FXML
    private void onNextButtonClick() {
        Stage demo = this.demoList.get(demoNum++);
        demo.show();
        demoNum = demoNum >= demoList.size() ? demoNum - demoList.size() : demoNum;
    }

    // "前一个演示按钮"
    @FXML
    private void onPreButtonClick() {
        Stage demo = this.demoList.get(demoNum--);
        demo.show();
        demoNum = demoNum < 0 ? demoNum + demoList.size() : demoNum;
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
}