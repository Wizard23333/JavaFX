package com.example.demo;

import com.example.demo.demo1.Demo1Application;
import com.example.demo.demo10.Demo10Application;
import com.example.demo.demo11.Demo11Application;
import com.example.demo.demo12.Demo12Application;
import com.example.demo.demo2.Demo2Application;
import com.example.demo.demo3.Demo3Application;
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
            add(new Demo3Application());
        } catch (IOException e) {
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

}