import java.util.Vector;

/***
 * The abstract class Dungeon describes all dungeons.
 *
 * monsters: the table for possible monsters during encounters
 * equips: the loot table for possible equip drops
 * stagesCount: the ammount of stages in a dungeon
 * minEncounterSize: the smallest number of monsters in an encounter (included)
 * maxEncounterSite: the highest number of monsters in an encounter (included)
 */
abstract class Dungeon extends MenuActor{
    private Monster[] monsters;
    private Equip[] equips;
    private int stagesCount = 1;
    private int minEncounterSize = 3;
    private int maxEncounterSize = 6;

    public Dungeon(int id, String name, String image, String icon) {
        super(id, name, image, icon);
    }

    public Monster[] getMonsters() {
        return monsters;
    }

    public Equip[] getEquips() {
        return equips;
    }

    public int getStagesCount() {
        return stagesCount;
    }

    public int getMinEncounterSize() {
        return minEncounterSize;
    }

    public int getMaxEncounterSize() {
        return maxEncounterSize;
    }

    public void setMonsters(Monster[] monsters) {
        this.monsters = monsters;
    }

    public void setEquips(Equip[] equips) {
        this.equips = equips;
    }

    public void setStagesCount(int stagesCount) {
        this.stagesCount = stagesCount;
    }

    public void setMinEncounterSize(int minEncounterSize) {
        this.minEncounterSize = minEncounterSize;
    }

    public void setMaxEncounterSize(int maxEncounterSize) {
        this.maxEncounterSize = maxEncounterSize;
    }

    /***
     * returns random int value
     * @param min min value (included)
     * @param max max value (included)
     * @return random int value
     */
    private int getRndInteger(int min, int max) {
        return (int)(Math.random() * (max - min + 1) ) + min;
    }

    /***
     * rolls for random object list on object table
     * @param minSize
     * @param maxSize
     * @param table object table
     * @return randomly sized list of random objects from table
     */
    protected Vector randomRoll(int minSize, int maxSize, Object[] table ){
        Vector res = new Vector();
        int monsterAmmount = getRndInteger(minSize, maxSize);
        int rmon;
        for (int i = 0; i <= monsterAmmount; i++){
            rmon = getRndInteger(0, table.length);
            res.add(table[rmon]);
        }
        return res;
    }

    public Vector<Monster> randomEncounter(){
        return randomRoll(minEncounterSize, maxEncounterSize, monsters);
    }

    public Vector<Equip> rollLoot(int minSize, int maxSize){
        return randomRoll(minSize, maxSize, equips);
    }
}
