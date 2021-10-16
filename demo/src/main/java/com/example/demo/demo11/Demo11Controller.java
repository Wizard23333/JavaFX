package com.example.demo.demo11;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

public class Demo11Controller {
    @FXML
    private TextArea listBoard;
    @FXML
    private TextArea listChangeInfo;

    private final List<String> list = new ArrayList<>();
    private SimpleStringProperty listString = new SimpleStringProperty();
    private final ObservableList<String> observableList = FXCollections.observableList(this.list);

    private void updateListProperty() {
        String tempString = "Contents:\n";
        for (String listItem : list) {
            tempString += listItem + "\n";
        }
        listString.set(tempString);
    }

    @FXML
    public void initialize() {
        list.add("JVM");
        list.add("Apache");
        list.add("JSON");
        list.add("JAXP");

        // 更新列表property内容
        updateListProperty();
        // 双向绑定到textArea
        listBoard.textProperty().bindBidirectional(listString);

        // 添加listener
        observableList.addListener(new ListChangeListener<String>() {
            @Override
            public void onChanged(Change<? extends String> change) {
                while (change.next()) {
                    listChangeInfo.setText(
                            "added:  " + change.wasAdded() + "\n" +
                                    "removed:  " + change.wasRemoved() + "\n" +
                                    "replaced:  " + change.wasReplaced() + "\n" +
                                    "permutated:  " + change.wasPermutated() + "\n"
                    );
                }
            }
        });
    }

    @FXML
    private void onAddListBtnClicked() {
        list.add("JavaFX");
        updateListProperty();
        listChangeInfo.clear();
    }

    @FXML
    private void onAddObservableListBtnClicked() {
        observableList.add("JavaFX");
        updateListProperty();
    }

    @FXML
    private void onRemoveObservableListBtnClicked() {
        observableList.remove(observableList.size() - 1, observableList.size());
        updateListProperty();
    }

}
