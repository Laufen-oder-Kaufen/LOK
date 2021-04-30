import java.util.*;

public class Battle {

    /*

  This function gets the heroes and enemies and prepares them for battle.

public void prepare getHeroes(){

ArrayList<Hero> heroList = getHeroes();
ArrayList<Enemy> enemyList = getEnemies();

LinkedList<Character> battleSequence = new LinkedList<Character>();
for (int i = 0;i<heroList.size();i++){
battleSequence.add(heroList.get(i));
}
for (int i = 0;i<enemyList.size();i++){
battleSequence.add(enemyList.get(i));
}

Collections.sort(battleSequence, Comparator.comparingInt(Character::getAgility).reversed());
fight(heroList, enemyList, battleSequence);

*/
    public static Monster archerEnemyVictim(ArrayList<Monster> victimList){
        int hp = 100000;
        int index = 0;
        for (int i = 0; i< victimList.size(); i++){
            if (victimList.get(i).getCurrHP()<hp){
                hp = victimList.get(i).getCurrHP();
                index = i;
            }
        }
        return victimList.get(index);

    }
    public static Hero archerHeroVictim(ArrayList<Hero> victimList){
        int hp = 100000;
        int index = 0;
        for (int i = 0; i< victimList.size(); i++){
            if (victimList.get(i).getCurrHP()<hp){
                hp = victimList.get(i).getCurrHP();
                index = i;
            }
        }
        return victimList.get(index);

    }

    public static boolean isCritical(Actor actor, Actor victim){
        double baseCritChance = 1;
        double baseCritEvade = 0.5;

        double actorCritChance = baseCritChance + actor.getLuk()*0.3;
        double victimCritEvade = baseCritEvade + victim.getLuk()*0.1;

        Random random = new Random();
        double rn = random.nextInt(100);

        System.out.println("actorCritChance " + actorCritChance + "/ victimCritEvade " + victimCritEvade + "/ RN: " + rn);


        if (rn <= (actorCritChance - victimCritEvade)){
            return true;
        }
        return false;
    }



public static void fight(ArrayList<Hero> heroes, ArrayList<Monster> enemies, LinkedList<Actor> battleSequence) {
        while ((heroes.size() > 0)) {
            for (int i = 0; i < battleSequence.size(); i++) {
                Actor actor = battleSequence.get(i);
                Actor victim = battleSequence.get(i); // this is just for initialization purposes
                String actorType = actor.getClass().getTypeName();


                String victimType = "";
                int damage = 0;
                Random r = new Random();
                int rn = 0;
                if (actorType.equals("Hero")) {
                    victimType = "Monster";
                }

                if (actorType.equals("Monster")) {
                    victimType = "Hero";
                }


                if (victimType.equals("Monster")) {
                    rn = r.nextInt(enemies.size());
                    if (actor.getType().contains("A") == true) {
                    victim = archerEnemyVictim(enemies);
                    }
                    else victim = enemies.get(rn);

                }
                if (victimType.equals("Hero")) {
                    rn = r.nextInt(heroes.size());
                    if (actor.getType().contains("A") == true) {
                        victim = archerHeroVictim(heroes);
                    }
                    else victim = heroes.get(rn);
                }
                if (actor.getType().contains("M") == true) {
                    System.out.println("Magic attack!");
                    damage = (int) ((actor.getMag() - (victim.getMdf() / 4)) + Math.round(actor.getMag() * 0.5));
                }
                if (actor.getType().contains("M") == false) {
                    damage = actor.getStr() - (victim.getDef() / 4);
                }
                if (isCritical(actor, victim)) {
                    damage = (int) (Math.round(damage * 1.5));
                    System.out.println("CRITICAL DAMAGE");
                }

                if (damage <= 0) {
                    damage = 1;
                } //Negative damage would otherwise heal the victim
                victim.setCurrHP(victim.getCurrHP() - damage);
                if (victim.getCurrHP() <= 0) {

                    if (battleSequence.indexOf(victim) < battleSequence.indexOf(actor)) {
                        i--; //otherwise it would skip the last actor in the battle sequence
                    }
                    battleSequence.removeIf(Character -> (Character.getCurrHP() <= 0));

                    if (victimType.equals("Enemy")) {
                        enemies.remove(victim);
                    }
                    if (victimType.equals("Hero")) {
                        heroes.remove(victim);
                    }
                    //After every death the linked list is updated (might be useless because linked list)
                    Collections.sort(battleSequence, Comparator.comparingInt(Actor::getAgi).reversed());
                }

                if (enemies.size() == 0) break;
                if (heroes.size() == 0) break;
            }


            if (heroes.size() == 0) {
                break;
            }
            if (enemies.size() == 0) {
            }
        }

}
}