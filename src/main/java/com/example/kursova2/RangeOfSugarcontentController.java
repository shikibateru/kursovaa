package com.example.kursova2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RangeOfSugarcontentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button butAceptSugar;

    @FXML
    private Button butCancelSugar;

    @FXML
    private TextField tfx1;

    @FXML
    private TextField tfx2;

    @FXML
    void initialize() {

        butAceptSugar.setOnAction(event -> {
            Integer x1 = Integer.valueOf(tfx1.getText());
            Integer x2 = Integer.valueOf(tfx2.getText());
            EventWithGiftController controller = new EventWithGiftController(x1,x2);
            butAceptSugar.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("EventsWithGift.fxml"));
            fxmlLoader.setController(controller);

            try {
                fxmlLoader.load();

            } catch (IOException e) {
                e.printStackTrace();
            }

            Stage stage = new Stage();
            stage.setTitle("Новорічний подарунок!");
            stage.setScene(new Scene(fxmlLoader.getRoot()));
            stage.setResizable(false);
            stage.show();
        });

        butCancelSugar.setOnAction(event -> {
            EventWithGiftController controller = new EventWithGiftController();
            butCancelSugar.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("EventsWithGift.fxml"));
            fxmlLoader.setController(controller);

            try {
                fxmlLoader.load();

            } catch (IOException e) {
                e.printStackTrace();
            }

            Stage stage = new Stage();
            stage.setTitle("Новорічний подарунок!");
            stage.setScene(new Scene(fxmlLoader.getRoot()));
            stage.setResizable(false);
            stage.show();
        });
    }

}
