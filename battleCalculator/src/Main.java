import com.sun.org.apache.bcel.internal.classfile.LineNumber;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Stream;

public class Main extends Application {

    @FXML
    public BorderPane characterCreatorPane;

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        mainWindow();
    }

    public void mainWindow() {
       try {
            int x = 1;
            if (x == 0) {
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("characterCreator.fxml"));
                AnchorPane pane = loader.load();
                Scene scene = new Scene(pane);
                this.primaryStage.setTitle("CharacterCreator");
                this.primaryStage.setScene(scene);
                this.primaryStage.setResizable(true);
                this.primaryStage.show();
            }
            if (x == 1) {
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("battleArena.fxml"));
                AnchorPane pane = loader.load();
                Scene scene = new Scene(pane);
                this.primaryStage.setTitle("Battle Arena");
                this.primaryStage.setScene(scene);
                this.primaryStage.setResizable(true);
                this.primaryStage.show();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public static void main(String[] args) throws IOException {
        launch(args);




        }


    public static int countLines(boolean hero) throws IOException {
        long lineCount;
        final File f = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String path = "";
        if (hero == true) {
             path = f.getAbsolutePath() + "\\heroes.txt";
        }
        else {
            path = f.getAbsolutePath()+ "\\enemies.txt";
        }

        LineNumberReader reader = null;
            reader = new LineNumberReader((new FileReader(path)));
            while ((reader.readLine()) != null);
            reader.close();
            return reader.getLineNumber();

    }




    public static Hero getHeroFromFile(int lineNumber) throws IOException {


        final File f = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String path = f.getAbsolutePath() + "\\heroes.txt";
        BufferedReader init = new BufferedReader(new FileReader(path));
        String line = "x";
        String name = "y";
        for (int i = 0; i<lineNumber;i++) {
            line = init.readLine();
            name = line.substring(0, line.indexOf(',')).replace("\"", "");
        }
        line= line.substring(line.indexOf(',')+1, line.length());
        int hp = Integer.parseInt(line.substring(0, line.indexOf(',')));
        line= line.substring(line.indexOf(',')+1, line.length());
        int strength = Integer.parseInt(line.substring(0, line.indexOf(',')));
        line= line.substring(line.indexOf(',')+1, line.length());
        int magic = Integer.parseInt(line.substring(0, line.indexOf(',')));
        line= line.substring(line.indexOf(',')+1, line.length());
        int defense = Integer.parseInt(line.substring(0, line.indexOf(',')));
        line= line.substring(line.indexOf(',')+1, line.length());
        int mdefense = Integer.parseInt(line.substring(0, line.indexOf(',')));
        line= line.substring(line.indexOf(',')+1, line.length());
        int agility = Integer.parseInt(line.substring(0, line.indexOf(',')));
        line= line.substring(line.indexOf(',')+1, line.length());
        int luck = Integer.parseInt(line.substring(0, line.indexOf(',')));
        line= line.substring(line.indexOf(',')+1, line.length());
        String rarity = line.substring(0, line.indexOf(','));
        line= line.substring(line.indexOf(',')+1, line.length());
        String charClass = line.substring(0, line.length());

            Hero hero = new Hero(name, hp, strength, magic, defense, mdefense, agility, luck, charClass, rarity);
            init.close();
            return hero;

    }
    public static Enemy getEnemyFromFile(int lineNumber) throws IOException {


        final File f = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String path = f.getAbsolutePath() + "\\enemies.txt";
        BufferedReader init = new BufferedReader(new FileReader(path));
        String line = "x";
        String name = "y";
        for (int i = 0; i < lineNumber; i++) {
            line = init.readLine();
            name = line.substring(0, line.indexOf(','));
        }
        line = line.substring(line.indexOf(',') + 1, line.length());
        int hp = Integer.parseInt(line.substring(0, line.indexOf(',')));
        line = line.substring(line.indexOf(',') + 1, line.length());
        int strength = Integer.parseInt(line.substring(0, line.indexOf(',')));
        line = line.substring(line.indexOf(',') + 1, line.length());
        int magic = Integer.parseInt(line.substring(0, line.indexOf(',')));
        line = line.substring(line.indexOf(',') + 1, line.length());
        int defense = Integer.parseInt(line.substring(0, line.indexOf(',')));
        line = line.substring(line.indexOf(',') + 1, line.length());
        int mdefense = Integer.parseInt(line.substring(0, line.indexOf(',')));
        line = line.substring(line.indexOf(',') + 1, line.length());
        int agility = Integer.parseInt(line.substring(0, line.indexOf(',')));
        line= line.substring(line.indexOf(',')+1, line.length());
        int luck = Integer.parseInt(line.substring(0, line.indexOf(',')));
        line= line.substring(line.indexOf(',')+1, line.length());
        String rarity = line.substring(0, line.indexOf(','));
        line= line.substring(line.indexOf(',')+1, line.length());
        String charClass = line.substring(0, line.length());

        Enemy enemy = new Enemy(name, hp, strength, magic, defense, mdefense, agility, luck, charClass, rarity);


        init.close();
        return enemy;
    }

        /*

        1. Reihenfolge bestimmen [Erstellen einer Linked-List für Reihenfolge]
        2. Held/ Gegner 1 greift an
        -> Frontkämpfer greifen immer Front an (noch zu implementieren)
        -> Fernkämpfer immer den Schwächsten (noch zu implementieren)
        3. Nächstes Element in der List ist am Zug
         */
        public static void prepare(ArrayList<String> heroes, ArrayList<String> enemies, int numberOfFights, int[] levelArray) throws IOException {
            int counter = 0;

            ArrayList<Hero> heroList = new ArrayList<Hero>();
            ArrayList<String>heroNames = new ArrayList<String>();
            ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
            ArrayList<String>enemyNames = new ArrayList<String>();



            LinkedList<Character> battleSequence = new LinkedList<Character>();
            for (int i = 0; i < heroes.size(); i++){
                for (int j = 1; j < countLines(true) + 1; j++) {
                    Hero hero = getHeroFromFile(j); // Lese Zeile für Zeile Held aus der Textdatei
                    if (heroes.get(i).equals(hero.getName())) { // Stimmt ein Name aus der ComboBox mit einem Held aus der Textdatei überein

                        if (heroNames.contains(hero.getName())) { //Existiert der Name bereits schon,addiere eine 1 an seinen Namen
                            hero.setName(hero.getName() + "2");
                        }
                        if (heroNames.contains(hero.getName())) { //Existiert der Name bereits schon,addiere eine 2 an seinen Namen
                            hero.setName(hero.getName().replace("2","3"));
                        }
                        heroNames.add(hero.getName()); //Füge den Namen zur Namensliste hinzu
                        heroList.add(hero); // Füge den Held zur Gegnerliste hinzu
                        battleSequence.add(hero); //Füge den Held der Battlesequenz hinzu
                        System.out.println("Hero Add: " + hero.getName());
                    }
                }
            }




for (int i = 0; i < enemies.size(); i++){
    for (int j = 1; j < countLines(false) + 1; j++) {
    Enemy enemy = getEnemyFromFile(j); // Lese Zeile für Zeile Gegner aus der Textdatei
    if (enemies.get(i).equals(enemy.getName())) { // Stimmt ein Name aus der ComboBox mit einem Gegner aus der Textdatei überein


            if (enemyNames.contains(enemy.getName())) { //Existiert der Name bereits schon,addiere eine 1 an seinen Namen
                enemy.setName(enemy.getName() + "2");
            }
            if (enemyNames.contains(enemy.getName())) { //Existiert der Name bereits schon,addiere eine 2 an seinen Namen
                enemy.setName(enemy.getName().replace("2","3"));
            }
            enemyNames.add(enemy.getName()); //Füge den Namen zur Namensliste hinzu
            enemyList.add(enemy); // Füge den Gegner zur Gegnerliste hinzu
            battleSequence.add(enemy); //Füge den Gegner der Battlesequenz hinzu
            System.out.println("Enemy Add: " + enemy.getName());
    }
    }
}
            levelUp(heroList.get(0), levelArray[0]);
            levelUp(heroList.get(1), levelArray[1]);
            levelUp(heroList.get(2), levelArray[2]);
            levelUp(enemyList.get(0), levelArray[3]);
            levelUp(enemyList.get(1), levelArray[4]);
            levelUp(enemyList.get(2), levelArray[5]);

            for (int i = 0; i<battleSequence.size();i++){
                battleSequence.get(i).setDamageDealt(0);
                battleSequence.get(i).setDamageTaken(0);
                battleSequence.get(i).setRoundsSurvived(0);
            }

                Collections.sort(battleSequence, Comparator.comparingInt(Character::getAgility).reversed());
                fight(heroList, enemyList, battleSequence);
                //enemies.clear();
                //battleSequence.clear();
                counter++;
        }


 public static void battleRoyale(ArrayList<Hero> heroes, ArrayList<Enemy> enemies, LinkedList<Character> battleSequence) {

            // Battle Royale without rules
            while (battleSequence.size() > 1) {

                for (int i = 0; i < battleSequence.size(); i++) {
                    System.out.println("===>*<=== Round " + i + " ===>*<===");
                    Character actor = battleSequence.get(i);
                    Random r = new Random();
                    int rn = r.nextInt(battleSequence.size());
                    Character victim = battleSequence.get(rn);

                    if (rn == i) {
                        rn = +1;
                    }

                    System.out.println(actor.getName() + " greift " + victim.getName() + " an.");
                    int damage = actor.getStrength() - (victim.getDefense() / 4);
                    if (damage <= 0) {
                        damage = 1;
                    } //Negative damage would otherwise heal the victim
                    victim.setLifepoints(victim.getLifepoints() - damage);
                    System.out.println(victim.getName() + " verliert " + damage + " HP. Verbleibende HP: " + victim.getLifepoints());
                    if (victim.getLifepoints() <= 0) {
                        System.out.println(victim.getName() + " ist tot.");
                    }
                    battleSequence.removeIf(Character -> (Character.getLifepoints() <= 0));
                }
            }
            System.out.println("Gewinner: " + battleSequence.get(0).getName());
        }

    public static boolean isCritical(Character actor, Character victim){
        double baseCritChance = 1;
        double baseCritEvade = 0.5;

        double actorCritChance = baseCritChance + actor.getLuck()*0.3;
        double victimCritEvade = baseCritEvade + victim.getLuck()*0.1;

        Random random = new Random();
        double rn = random.nextInt(100);

        System.out.println("actorCritChance " + actorCritChance + "/ victimCritEvade " + victimCritEvade + "/ RN: " + rn);


        if (rn <= (actorCritChance - victimCritEvade)){
            return true;
        }
        return false;
    }

    public static int calculatePower(Character actor){
        double strength = 0;
        double survivability = Math.round((actor.getMaxLifepoints() / (1/(actor.getDefense() + (double) actor.getMagicalDefense())/2))/6);
        if (actor.getCharClass().contains("M")) {
             strength = actor.getMagic() * 30;
        }

        if (actor.getCharClass().contains("W") || actor.getCharClass().contains("A")) {
            strength = actor.getStrength() * 25;
        }
        if (actor.getCharClass().contains("A")) {
            strength = strength * 1.05;
        }

        double skill = Math.round(survivability/10 * (double)(actor.getLuck() + actor.getAgility())/4);

        int power = (int) Math.round(survivability + strength + 0.7*skill);
        return power;
    }

    public static Character archerEnemyVictim(ArrayList<Enemy> victimList){
            int hp = 100000;
            int index = 0;
            for (int i = 0; i< victimList.size(); i++){
                if (victimList.get(i).getLifepoints()<hp){
                    hp = victimList.get(i).getLifepoints();
                    index = i;
                }
            }
            return victimList.get(index);

    }
    public static Character archerHeroVictim(ArrayList<Hero> victimList){
        int hp = 100000;
        int index = 0;
        for (int i = 0; i< victimList.size(); i++){
            if (victimList.get(i).getLifepoints()<hp){
                hp = victimList.get(i).getLifepoints();
                index = i;
            }
        }
        return victimList.get(index);

    }


public static void fight(ArrayList<Hero> heroes, ArrayList<Enemy> enemies, LinkedList<Character> battleSequence) {

    double fightcounter = 0;

    Enemy tmpEnemy1 = enemies.get(0);
    Enemy tmpEnemy2 = enemies.get(1);
    Enemy tmpEnemy3 = enemies.get(2);

    Hero tmpHero1 = heroes.get(0);
    Hero tmpHero2 = heroes.get(1);
    Hero tmpHero3 = heroes.get(2);


    String winners = "";

    for (int p = 0; p < 100; p++) {
        System.out.println(String.format("================================ %d ===========================================", p));
        while ((heroes.size() > 0)) {
            for (int i = 0; i < battleSequence.size(); i++) {
                System.out.println("===>*<=== Character " + (i) + " ===>*<===");
                System.out.println("Enemy size: " + enemies.size());
                System.out.println("Hero size: " + heroes.size());
                Character actor = battleSequence.get(i);
                Character victim = battleSequence.get(i); // this is just for initialization purposes
                String actorType = actor.getClass().getTypeName();


                String victimType = "";



                int damage = 0;
                Random r = new Random();
                int rn = 0;
                if (actorType.equals("Hero")) {
                    victimType = "Enemy";
                }

                if (actorType.equals("Enemy")) {
                    victimType = "Hero";
                }


                if (victimType.equals("Enemy")) {
                    rn = r.nextInt(enemies.size());
                    if (actor.getCharClass().contains("A") == true) {
                    victim = archerEnemyVictim(enemies);
                    }
                    else victim = enemies.get(rn);

                }
                if (victimType.equals("Hero")) {
                    rn = r.nextInt(heroes.size());
                    if (actor.getCharClass().contains("A") == true) {
                        victim = archerHeroVictim(heroes);
                    }
                    else victim = heroes.get(rn);
                }
                System.out.println(actor.getName() + " greift " + victim.getName() + " an.");
                if (actor.getCharClass().contains("M") == true) {
                    System.out.println("Magic attack!");
                    damage = (int) ((actor.getMagic() - (victim.getMagicalDefense() / 4)) + Math.round(actor.getMagic() * 0.5));
                }
                if (actor.getCharClass().contains("M") == false) {
                    damage = actor.getStrength() - (victim.getDefense() / 4);
                }
                if (isCritical(actor, victim)) {
                    damage = (int) (Math.round(damage * 1.5));
                    System.out.println("CRITICAL DAMAGE");
                }

                if (damage <= 0) {
                    damage = 1;
                } //Negative damage would otherwise heal the victim
                victim.setLifepoints(victim.getLifepoints() - damage);
                victim.setDamageTaken(damage);
                actor.setDamageDealt(damage);
                System.out.println(victim.getName() + " verliert " + damage + " HP. Verbleibende HP: " + victim.getLifepoints());
                if (victim.getLifepoints() <= 0) {

                    if (battleSequence.indexOf(victim) < battleSequence.indexOf(actor)) {
                        i--; //otherwise it would skip the last actor in the battle sequence
                    }
                    System.out.println(victim.getName() + " ist tot.");
                    battleSequence.removeIf(Character -> (Character.getLifepoints() <= 0));

                    if (victimType.equals("Enemy")) {
                        enemies.remove(victim);
                    }
                    if (victimType.equals("Hero")) {
                        heroes.remove(victim);
                    }
                    //After every death the linked list is updated (might be useless because linked list)
                    Collections.sort(battleSequence, Comparator.comparingInt(Character::getAgility).reversed());
                }

                for (int t = 0; t< enemies.size();t++){ //every surviving member gets a +1 on their survival
                    enemies.get(t).setRoundsSurvived(1);
                }
                for (int t = 0; t< heroes.size();t++){
                    heroes.get(t).setRoundsSurvived(1);
                }

                if (enemies.size() == 0) break;
                if (heroes.size() == 0) break;
            }


            if (heroes.size() == 0) {
                winners = "Gegner";

                battleSequence.clear();
                heroes.clear();
                enemies.clear();
                battleSequence.add(tmpHero1);
                battleSequence.add(tmpHero2);
                battleSequence.add(tmpHero3);
                battleSequence.add(tmpEnemy1);
                battleSequence.add(tmpEnemy2);
                battleSequence.add(tmpEnemy3);

                enemies.add(tmpEnemy1);
                enemies.add(tmpEnemy2);
                enemies.add(tmpEnemy3);

                heroes.add(tmpHero1);
                heroes.add(tmpHero2);
                heroes.add(tmpHero3);
                healingHeroes(heroes);
                Collections.sort(battleSequence, Comparator.comparingInt(Character::getAgility).reversed());
                break;
            }
            if (enemies.size() == 0) {
                winners = "Helden";
                battleSequence.add(tmpEnemy1);
                battleSequence.add(tmpEnemy2);
                battleSequence.add(tmpEnemy3);
                enemies.add(tmpEnemy1);
                enemies.add(tmpEnemy2);
                enemies.add(tmpEnemy3);
                healingEnemies(enemies);
                Collections.sort(battleSequence, Comparator.comparingInt(Character::getAgility).reversed());
                fightcounter++;
                System.out.println (String.format("================$$$$ Einzelkampf " +(Math.round(fightcounter)+1) + " $$$$================"));
            }
        }

        System.out.println("Gewonnen haben: " + winners);

    }
    System.out.println("Durchschnittliche Anzahl an Arenakämpfen: " + fightcounter/100);
    System.out.println(tmpHero1.getName() + " damage: " + tmpHero1.getDamageDealt()/100 + ", überlebte Einzelrunden: " + tmpHero1.getRoundsSurvived()/100 + " / Mächtigkeit: " + calculatePower(tmpHero1));
    System.out.println(tmpHero2.getName() + " damage: " + tmpHero2.getDamageDealt()/100 + ", überlebte Einzelrunden: " + tmpHero2.getRoundsSurvived()/100 + " / Mächtigkeit: " + calculatePower(tmpHero2));
    System.out.println(tmpHero3.getName() + " damage: " + tmpHero3.getDamageDealt()/100 + ", survival: Einzelrunden: " + tmpHero3.getRoundsSurvived()/100 + " / Mächtigkeit: " + calculatePower(tmpHero3));
    System.out.println(tmpEnemy1.getName() + " damage: " + tmpEnemy1.getDamageDealt()/100 + ", überlebte Einzelrunden: " + tmpEnemy1.getRoundsSurvived()/100 + " / Mächtigkeit: " + calculatePower(tmpEnemy1));
    System.out.println(tmpEnemy2.getName() + " damage: " + tmpEnemy2.getDamageDealt()/100 + ", überlebte Einzelrunden: " + tmpEnemy2.getRoundsSurvived()/100 + " / Mächtigkeit: " + calculatePower(tmpEnemy2));
    System.out.println(tmpEnemy3.getName() + " damage: " + tmpEnemy3.getDamageDealt()/100 + ", überlebte Einzelrunden: " + tmpEnemy3.getRoundsSurvived()/100 + " / Mächtigkeit: " + calculatePower(tmpEnemy3));


}

public static void healingHeroes(ArrayList<Hero> heroes) {
    for (int n = 0; n < heroes.size(); n++) {
        heroes.get(n).setLifepoints(heroes.get(n).getMaxLifepoints());
    }
}
    public static void healingEnemies(ArrayList<Enemy> enemies){
        for(int n = 0; n< enemies.size();n++){
            enemies.get(n).setLifepoints(enemies.get(n).getMaxLifepoints());
        }
}

public static void levelUp(Character actor, int level){
            System.out.println("Level UP");
double multiplicator = 0;

    if (actor.getRarity().equals("1")) {
        multiplicator = 0.03;
    }

    if (actor.getRarity().equals("2")) {
        multiplicator = 0.04;
    }

    if (actor.getRarity().equals("3")) {
        multiplicator = 0.05;
    }

    if (actor.getRarity().equals("4")) {
        multiplicator = 0.06;
    }

    if (actor.getRarity().equals("5")) {
        multiplicator = 0.07;
    }


    if (actor.getRarity().equals("C")) {
                 multiplicator = 0.08;
            }
            if (actor.getRarity().equals("U")) {
                multiplicator = 0.10;
            }
             if (actor.getRarity().equals("R")) {
                 multiplicator = 0.11;
           }
            if (actor.getRarity().equals("L")) {
                multiplicator= 0.13;
             }
            System.out.println(actor.toString());

                for (int i = 0; i < level; i++) {



                    actor.setMaxlifepoints(actor.getMaxLifepoints() + (int) Math.round(actor.getMaxLifepoints() * multiplicator));
                    actor.setLifepoints(actor.getMaxLifepoints());
                    actor.setStrength(actor.getStrength() + (int) Math.round(actor.getStrength() * multiplicator));
                    if (Math.round(actor.getStrength() * multiplicator) == 0){
                        actor.setStrength(actor.getStrength() + 1);
                    }

                    actor.setDefense(actor.getDefense() + (int) Math.round(actor.getDefense() * multiplicator));

                    actor.setMagic(actor.getMagic() + (int) Math.round(actor.getMagic() * multiplicator));
                    if (Math.round(actor.getMagic() * multiplicator) == 0){
                        actor.setMagic(actor.getMagic() + 1);
                    }

                    actor.setMagicalDefense(actor.getMagicalDefense() + (int) Math.round(actor.getMagicalDefense() * multiplicator));
                    actor.setAgility(actor.getAgility() + (int) Math.round(actor.getAgility() * multiplicator/4));
                    if (Math.round(actor.getAgility() * multiplicator) == 0){
                        actor.setAgility(actor.getAgility() + 1);
                    }
      //              actor.setLuck(actor.getLuck() + (int) Math.round(actor.getLuck() * multiplicator/4));
                    System.out.println(actor.toString());
                }

}
}
