package com.example.buttonclickinggame;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class ButtonClickingGameController implements Initializable {
    @FXML
    private Label label;
    @FXML
    private Button button;

    private int count;

    public void onButtonClick() {
        count++;
        label.setText(String.valueOf(count));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Random randomX = new Random();
        Random randomY = new Random();
          Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), event -> {
              double x = randomX.nextDouble(0, 300);
              double y = randomY.nextDouble(0, 300);
            button.setLayoutX(x);
            button.setLayoutY(y);
          }));
        timeline.setCycleCount(10);
        timeline.play();
        timeline.setOnFinished(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            int result = count;
            alert.getResult();
            Platform.runLater(alert::showAndWait);
            count=0;
            timeline.play();
        });
    }
}