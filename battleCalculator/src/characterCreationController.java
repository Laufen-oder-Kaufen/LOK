import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.*;

public class characterCreationController extends Application {

    @FXML
     public TextField labelName;
    @FXML
    public  TextField labelStrength;
    @FXML
    public  TextField labelMagic;
    @FXML
    public  TextField labelDefense;
    @FXML
    public  TextField labelMDefense;
    @FXML
    public  TextField labelLuck;
    @FXML
    public  TextField labelAgility;
    @FXML
    public  TextField labelHP;
    @FXML
    public  TextField labelRarity;
    @FXML
    public CheckBox checkMage;
    @FXML
    public CheckBox checkWarrior;
    @FXML
    public CheckBox checkArcher;
    @FXML
    public CheckBox checkHealer;
    @FXML
    public CheckBox checkEnemy;
    @FXML
    public  TextField power;

    @FXML
    AnchorPane characterCreatorPane;


    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    @FXML
    private void handleCreate(ActionEvent e) throws IOException {
        String charClass = "";
        if (isMage()){
            charClass="M";
        }
        if (isWarrior()){
            charClass=charClass + "W";
        }
        if (isArcher()){
            charClass=charClass + "A";
        }
        if (isHealer()){
            charClass=charClass + "H";
        }
        Hero tempHero = new Hero(getActorName(), getActorHP(), getActorStrength(), getActorMagic(), getActorDefense(), getActorMDefense(), getActorAgility(), getActorLuck(), charClass, getActorRarity());
        final File f = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String path = f.getAbsolutePath() + "\\heroes.txt";
        if (checkEnemy.isSelected() == true){
            path = f.getAbsolutePath() + "\\enemies.txt";
        }
        BufferedWriter output = new BufferedWriter(new FileWriter(path, true));
            output.write("\n" + tempHero.getName() + "" + "," + tempHero.getMaxLifepoints() + "," + tempHero.getStrength() + "," + tempHero.getMagic() + "," + tempHero.getDefense() + "," + tempHero.getMagicalDefense() + "," + tempHero.getAgility() + "," + tempHero.getLuck()+","  + tempHero.getRarity() + "," + tempHero.getCharClass());
            output.close();

    }
    @FXML
    private void handleCalculate(ActionEvent e) {
        String charClass = "";
        if (isMage()){
            charClass="M";
        }
        if (isWarrior()){
            charClass=charClass + "W";
        }
        if (isArcher()){
            charClass=charClass + "A";
        }
        if (isHealer()){
            charClass=charClass + "H";
        }
        Hero tempHero = new Hero(getActorName(), getActorHP(), getActorStrength(), getActorMagic(), getActorDefense(), getActorMDefense(), getActorAgility(), getActorLuck(), charClass, getActorRarity());
        power.setText(String.valueOf(Main.calculatePower(tempHero)));



    }

    public String getActorName(){
        return labelName.getText();
    }

    public int getActorHP(){
        return Integer.parseInt(labelHP.getText());
    }
    public int getActorStrength(){
        return Integer.parseInt(labelStrength.getText());
    }
    public int getActorMagic(){
        return Integer.parseInt(labelMagic.getText());
    }
    public int getActorDefense(){
        return Integer.parseInt(labelDefense.getText());
    }
    public int getActorMDefense(){
        return Integer.parseInt(labelMDefense.getText());
    }
    public int getActorAgility(){
        return Integer.parseInt(labelAgility.getText());
    }
    public int getActorLuck(){
        return Integer.parseInt(labelLuck.getText());
    }
    public String getActorRarity(){return labelRarity.getText();}
    public boolean isMage(){return checkMage.isSelected();    }
    public boolean isWarrior(){
        return checkWarrior.isSelected();
    }
    public boolean isArcher(){
        return checkArcher.isSelected();
    }
    public boolean isHealer(){
        return checkHealer.isSelected();
    }
    public boolean isEnemy(){
        return checkEnemy.isSelected();
    }

}
