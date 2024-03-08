package com.example.jaskaran_test3_sem3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("WEBSITE-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 700);
        stage.setTitle("JASKARAN KAUR ");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}