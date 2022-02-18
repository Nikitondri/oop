package main.java.bsuir.zakharenko.lab01.controller;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 600, 600);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Runner runner = new Runner();
        runner.execute(root);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
