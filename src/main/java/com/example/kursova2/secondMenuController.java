package com.example.kursova2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class secondMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button but_eventgift;

    @FXML
    private Button but_ierarhisweets;

    @FXML
    private Label welcomeText;

    @FXML
    void initialize() {
        but_eventgift.setOnAction(event -> {
            EventWithGiftController controller = new EventWithGiftController();
            but_eventgift.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("EventsWithGift.fxml"));
            fxmlLoader.setController(controller);

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
        });
        but_ierarhisweets.setOnAction(event -> {
            Main.SwitchScene("Typesweets.fxml",but_ierarhisweets);
        });
    }
}
