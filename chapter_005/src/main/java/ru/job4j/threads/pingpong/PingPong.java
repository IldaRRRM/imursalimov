package ru.job4j.threads.pingpong;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PingPong extends Application {
    private static final String JOB4J = "Пинг-понг";
    private Button button;

    @Override
    public void start(Stage stage) {
        int limitX = 300;
        int limitY = 300;
        Rectangle rect = new Rectangle(50, 100, 10, 10);
        button = new Button("Interrupt rectangle move");
        Group group = groupInit(rect);
        Thread rectangleThread = new Thread(new RectangleMove(rect, limitX, limitY));
        button.setOnAction(event -> rectangleThread.interrupt());
        rectangleThread.start();
        stageInit(stage, limitX, limitY, group, rectangleThread);
    }

    private Group groupInit(Rectangle rect) {
        Group group = new Group();
        group.getChildren().add(rect);
        group.getChildren().add(button);
        return group;
    }

    private void stageInit(Stage stage, int limitX, int limitY, Group group, Thread thread) {
        stage.setScene(new Scene(group, limitX, limitY));
        stage.setTitle(JOB4J);
        stage.setResizable(false);
        stage.show();
        stage.setOnCloseRequest(event -> thread.interrupt());
    }

}


