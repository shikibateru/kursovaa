package com.example.kursova2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TypesweetsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button but_back;

    @FXML
    private Label welcomeText;

    @FXML
    void initialize() {
        but_back.setOnAction(event -> {
            Main.SwitchScene("secondMenu.fxml",but_back);
        });
    }
}