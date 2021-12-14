package com.example.kursova2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class AddSweetController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button butAceptAddSweet;

    @FXML
    private Button butCancelAddSweet;

    @FXML
    private ComboBox<String> cbTypeSweet;

    @FXML
    void initialize() {
        cbTypeSweet.getItems().addAll("Шоколадна цукерка з начинкою",
        "Цукерка з вафлею в середині",
        "Цукерка грильяж",
        "Цукерка з лікером",
        "Молочна цукерка");

        butCancelAddSweet.setOnAction(Event -> {
            EventWithGiftController controller = new EventWithGiftController();
            butCancelAddSweet.getScene().getWindow().hide();
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

        butAceptAddSweet.setOnAction(Event -> {


            String choose = cbTypeSweet.getSelectionModel().getSelectedItem().toString();

            Sweets sweets = searchSweet(choose);
            Driver db = new Driver();
            db.addSweet(sweets);

            EventWithGiftController controler = new EventWithGiftController();
            butAceptAddSweet.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("EventsWithGift.fxml"));
            fxmlLoader.setController(controler);

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

    private Sweets searchSweet(String choose){

        String str1 = "Шоколадна цукерка з начинкою";
        String str2 = "Цукерка з вафлею в середині";
        String str3 = "Цукерка грильяж";
        String str4 = "Цукерка з лікером";
        String str5 = "Молочна цукерка";

        Sweets sw = new Sweets();
        if(str1.equals(choose)){
            sw = new Sweets(choose,52,40);
        }
        if(str2.equals(choose)){
            sw = new Sweets(choose,40,25);
        }
        if(str3.equals(choose)){
            sw = new Sweets(choose,45,35);
        }
        if(str4.equals(choose)){
            sw = new Sweets(choose,42,28);
        }
        if(str5.equals(choose)){
            sw = new Sweets(choose,35,34);
        }

        return sw;
    }
}
