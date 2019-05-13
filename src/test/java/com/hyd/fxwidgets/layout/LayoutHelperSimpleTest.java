package com.hyd.fxwidgets.layout;

import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LayoutHelperSimpleTest extends Application implements LayoutHelper {

    private Label label1;

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(
            borderPane(
                label1 = label("Hello, world")
            ),
            500, 400
        );

        startTimer();

        stage.setScene(scene);
        stage.show();
    }

    private void startTimer() {
        DateTimeFormatter format = ofPattern("HH:mm:ss");

        new Timer(true).scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (label1 != null) {
                    Platform.runLater(() -> {
                        String now = LocalTime.now().format(format);
                        label1.setText(now);
                    });
                }
            }
        }, 1000, 1000);
    }
}
