package com.example.kursova2;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class EventWithGiftController implements Initializable {

    private boolean isSearch = false;
    private int x1;
    private int x2;

    public EventWithGiftController() {

    }

    public EventWithGiftController(int x1, int x2) {
        this.isSearch = true;
        this.x1 = x1;
        this.x2 = x2;
    }

    private ArrayList<Sweets> SweetsArrayList = new ArrayList<>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Sweets, String> Name;

    @FXML
    private TextField SugarSumma;

    @FXML
    private TableColumn<Sweets, Integer> Weight;

    @FXML
    private Button butAddSweets;

    @FXML
    private Button butDeleteSweets;

    @FXML
    private Button butSearchSumaSugarcontent;

    @FXML
    private Button butSearchSweets;

    @FXML
    private Button but_SweetsSceneBack;

    @FXML
    private Button butaccept;

    @FXML
    private TableColumn<Sweets, Integer> idSweets;

    @FXML
    private TableColumn<Sweets, Integer> sugarcontent;

    @FXML
    private TableView<Sweets> table;

    ObservableList<Sweets> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Driver db = new Driver();
        ResultSet result;
        if(isSearch){
            result = db.searchSugarSweet(x1, x2);

        }
        else
        {
            result = db.viewSweet();
        }

        while (true) {
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                list.add(new Sweets(result.getInt(1), result.getString(2), result.getInt(3),
                        result.getInt(4)));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        idSweets.setCellValueFactory(new PropertyValueFactory<Sweets, Integer>("idSweets"));
        Name.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNameSweets()));
        Weight.setCellValueFactory(new PropertyValueFactory<Sweets, Integer>("Weight"));
        sugarcontent.setCellValueFactory(new PropertyValueFactory<Sweets, Integer>("sugarcontent"));

        table.setItems(list);

        butAddSweets.setOnAction(Event-> {
            Main.SwitchScene("AddSweetsScene.fxml", butAddSweets);
        });

        butSearchSweets.setOnAction(Event-> {
            Main.SwitchScene("RangeOfSugarcontent.fxml", butSearchSweets);
        });

        butSearchSumaSugarcontent.setOnAction(Event-> {
            Integer sum = 0;
            for (int i = 0; i < list.size(); i++){
                sum+=list.get(i).getWeight();
            }

            SugarSumma.setText(sum.toString());
        });

        but_SweetsSceneBack.setOnAction(Event -> {
            Main.SwitchScene("secondMenu.fxml", but_SweetsSceneBack);
        });

        butaccept.setOnAction(Event-> {
            Main.SwitchScene("AcceptScene.fxml", butaccept);
        });

        butDeleteSweets.setOnAction(Event -> {
            int i = table.getSelectionModel().getSelectedItem().getIdSweets();

            db.delSweet(i);

            EventWithGiftController controller = new EventWithGiftController();
            butDeleteSweets.getScene().getWindow().hide();
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
