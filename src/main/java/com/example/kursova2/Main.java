package com.example.kursova2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("startMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Новорічний подарунок!");
        stage.setScene(scene);
        stage.show();
    }

    public static void SwitchScene(String str, Button but){
        but.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(str));

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setTitle("Новорічний подарунок");
        stage.setScene(new Scene(fxmlLoader.getRoot()));
        stage.setResizable(false);
        stage.show();
    };
    public static void main(String[] args) {
        launch();
    }
}