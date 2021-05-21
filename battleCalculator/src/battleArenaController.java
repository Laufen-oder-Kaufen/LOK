import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class battleArenaController extends Application {

    @FXML
    public ComboBox cbh1;
    @FXML
    public ComboBox cbh2;
    @FXML
    public ComboBox cbh3;
    @FXML
    public ComboBox cbe1;
    @FXML
    public ComboBox cbe2;
    @FXML
    public ComboBox cbe3;
    @FXML
    public TextField txtNrFights;
    @FXML
    public TextField txtHero1Level = new TextField();
    @FXML
    public TextField txtHero2Level= new TextField();
    @FXML
    public TextField txtHero3Level= new TextField();
    @FXML
    public TextField txtEnemy1Level= new TextField();
    @FXML
    public TextField txtEnemy2Level= new TextField();
    @FXML
    public TextField txtEnemy3Level= new TextField();

    @FXML
    public Button btnFight;

    public static ObservableList<String> myComboBoxData =
            FXCollections.observableArrayList();
    public static ObservableList<String> myComboBoxDataEnemy =
            FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception {
        initialize();
    }

    public void initialize() throws IOException {
        comboBoxData();
        cbh1.setItems(myComboBoxData);
        cbh2.setItems(myComboBoxData);
        cbh3.setItems(myComboBoxData);
        cbe1.setItems(myComboBoxDataEnemy);
        cbe2.setItems(myComboBoxDataEnemy);
        cbe3.setItems(myComboBoxDataEnemy);
    }

    public void comboBoxData() throws IOException {
        for (int i = 1; i<Main.countLines(true)+1;i++) {
            this.myComboBoxData.add(Main.getHeroFromFile(i).getName());
        }
        for (int i = 1; i<Main.countLines(false)+1;i++) {
            this.myComboBoxDataEnemy.add(Main.getEnemyFromFile(i).getName());
        }

    }

    @FXML
    private void handleFight(ActionEvent e) throws IOException {
        ArrayList<String> heroes = new ArrayList<String>();
        heroes.add((String) cbh1.getValue());
        heroes.add((String) cbh2.getValue());
        heroes.add((String) cbh3.getValue());
        ArrayList<String> enemies = new ArrayList<String>();
        enemies.add((String) cbe1.getValue());
        enemies.add((String) cbe2.getValue());
        enemies.add((String) cbe3.getValue());
        int levelArray[]= new int[6];
        levelArray[0] = Integer.parseInt(txtHero1Level.getText());
        levelArray[1] = Integer.parseInt(txtHero2Level.getText());
        levelArray[2] = Integer.parseInt(txtHero3Level.getText());
        levelArray[3] = Integer.parseInt(txtEnemy1Level.getText());
        levelArray[4] = Integer.parseInt(txtEnemy2Level.getText());
        levelArray[5] = Integer.parseInt(txtEnemy3Level.getText());
        Main.prepare(heroes, enemies, 100, levelArray);

    }

}
