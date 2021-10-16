package com.example.demo.demo10;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class Demo10Controller {
    @FXML
    private Label text;
    @FXML
    private TextField textField;

    @FXML
    private Slider widthSlider;
    @FXML
    private Slider heightSlider;
    @FXML
    private TextField areaTextField;

    @FXML
    public void initialize() {
        text.setText("Text");
        textField.setText("Text");
        // 将text和textField属性相互绑定 使用的实例
        text.textProperty().bindBidirectional(textField.textProperty());
    }

    @FXML
    private void onDragDetected() {
        DoubleProperty width = new SimpleDoubleProperty(widthSlider.getValue());
        DoubleProperty height = new SimpleDoubleProperty(heightSlider.getValue());

        // 高级绑定API
        NumberBinding area = width.multiply(height);
        areaTextField.setText( String.format("%.2f", area.getValue()));
    }
}
