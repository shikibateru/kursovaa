package com.example.kursova2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class startMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button but_creategift;

    @FXML
    private Label welcomeText;

    @FXML
    void initialize() {
        Driver db = new Driver();
        db.truncatetable();
       but_creategift.setOnAction(event -> {
            Main.SwitchScene("secondMenu.fxml",but_creategift);
       });
    }

}