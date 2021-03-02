import java.util.Vector;

/***
 * GachaLootbox represents any Lootbox in the game
 *
 * ticketType:  ticket(0), goldticket(1) or platinticket(2) is used
 * equips: list of possible equips that can drop
 * heroes: list of possible heroes that can drop
 * items: list of possible items that can drop
 * goldHeaps: list of different goldHeaps that can drop
 *
 * !! Not implemented !!
 * !! Also no weight of individual heroes or other list items !!
 * equipWeight: possibility of equip drops
 * heroWeight: possibility of hero drops
 * itemWeight: possibility of item drops
 * goldWeight: possibility of goldHeap drops
 */
public class GachaLootbox extends MenuActor {
    private int ticketType = 0;
    private Vector<Equip> equips = new Vector<Equip>();
    private Vector<Hero> heroes = new Vector<Hero>();
    private Vector<ActiveItem> items = new Vector<ActiveItem>();
    private Vector<Integer> goldHeaps = new Vector<Integer>();
    private int equipWeight = 1;
    private int heroWeight = 1;
    private int itemWeight = 1;
    private int goldWeight = 1;

    public GachaLootbox() {
    }

    public int getTicketType() {
        return ticketType;
    }

    public Vector<Equip> getEquips() {
        return equips;
    }

    public Vector<Hero> getHeroes() {
        return heroes;
    }

    public Vector<ActiveItem> getItems() {
        return items;
    }

    public Vector<Integer> getGoldHeaps() {
        return goldHeaps;
    }

    public int getEquipWeight() {
        return equipWeight;
    }

    public int getHeroWeight() {
        return heroWeight;
    }

    public int getItemWeight() {
        return itemWeight;
    }

    public int getGoldWeight() {
        return goldWeight;
    }

    public GachaLootbox setTicketType(int ticketType) {
        this.ticketType = ticketType;
        return this;
    }

    public GachaLootbox setEquips(Vector<Equip> equips) {
        this.equips = equips;
        return this;
    }

    public GachaLootbox setHeroes(Vector<Hero> heroes) {
        this.heroes = heroes;
        return this;
    }

    public GachaLootbox setItems(Vector<ActiveItem> items) {
        this.items = items;
        return this;
    }

    public GachaLootbox setGoldHeaps(Vector<Integer> goldHeaps) {
        this.goldHeaps = goldHeaps;
        return this;
    }

    public GachaLootbox setEquipWeight(int equipWeight) {
        this.equipWeight = equipWeight;
        return this;
    }

    public GachaLootbox setHeroWeight(int heroWeight) {
        this.heroWeight = heroWeight;
        return this;
    }

    public GachaLootbox setItemWeight(int itemWeight) {
        this.itemWeight = itemWeight;
        return this;
    }

    public GachaLootbox setGoldWeight(int goldWeight) {
        this.goldWeight = goldWeight;
        return this;
    }

    /***
     * returns random int value
     * @param min min value (included)
     * @param max max value (included)
     * @return random int value
     */
    private int getRndInteger(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    /***
     * getRandomListObject returns a randomly selected Object from a given list
     * @param list
     * @return random object rolled on list
     */
    private Object getRandomListObject(Vector list) {
        int roll = getRndInteger(0, list.size() - 1);
        return list.get(roll);
    }

    /***
     * rollLoot rolls on loot tables of this lootbox
     * @param rolls number of roll results
     * @return vector containing the loot
     */
    public Vector rollLoot(int rolls) {
        Vector res = new Vector();
        int type;
        for (int i = 0; i < rolls; i++) {
            type = getRndInteger(1, 4);
            switch (type) {
                case 1:
                    res.add(getRandomListObject(equips));
                    break;
                case 2:
                    res.add(getRandomListObject(heroes));
                    break;
                case 3:
                    res.add(getRandomListObject(items));
                    break;
                case 4:
                    res.add(getRandomListObject(goldHeaps));
            }
        }
        return res;
    }
}
