import android.media.audiofx.DynamicsProcessing;

import java.util.Vector;

/***
 * PlayerInventory is a Singleton Class that represents the collected invetory of the Player
 */
public class PlayerInventory {
    private static PlayerInventory playerinvetory = new PlayerInventory();
    private Vector<Equip> equips = new Vector<Equip>();
    private Vector<Hero> heroes = new Vector<Hero>();
    private Vector<ActiveItem> items = new Vector<ActiveItem>();
    private int gold = 0;
    private int tickets = 0;
    private int goldTickets = 0;
    private int platinTickets = 0;

    private PlayerInventory() {
    }

    public static PlayerInventory getInstance() {
        return playerinvetory;
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

    public int getGold() {
        return gold;
    }

    public int getTickets() {
        return tickets;
    }

    public int getGoldTickets() {
        return goldTickets;
    }

    public int getPlatinTickets() {
        return platinTickets;
    }

    public PlayerInventory setEquips(Vector<Equip> equips) {
        this.equips = equips;
        return this;
    }

    public PlayerInventory setHeroes(Vector<Hero> heroes) {
        this.heroes = heroes;
        return this;
    }

    public PlayerInventory setItems(Vector<ActiveItem> items) {
        this.items = items;
        return this;
    }

    public PlayerInventory setGold(int gold) {
        this.gold = gold;
        return this;
    }

    public PlayerInventory setTickets(int tickets) {
        this.tickets = tickets;
        return this;
    }

    public PlayerInventory setGoldTickets(int goldTickets) {
        this.goldTickets = goldTickets;
        return this;
    }

    public PlayerInventory setPlatinTickets(int platinTickets) {
        this.platinTickets = platinTickets;
        return this;
    }

    public PlayerInventory addEquip(Equip equip) {
        this.equips.add(equip);
        return this;
    }

    public PlayerInventory addHero(Hero hero) {
        this.heroes.add(hero);
        return this;
    }

    public PlayerInventory addItem(ActiveItem item) {
        this.items.add(item);
        return this;
    }

    /***
     * EnchantEquip tries to remove the oldeqips equip items from the inventory. If successfull it increases the bonus value of the boostedEquip
     * @param oldequips array of sacrificed equipment
     * @param boostedEquip piece of equipment that gets improved
     * @return check value to see wether or not the process finished successfully
     */
    public boolean EnchantEquip(Equip[] oldequips, Equip boostedEquip) {
        Vector checkEquips = (Vector) equips.clone();
        //check to see if the oldequips exist in equips;
        for (Equip e : oldequips) {
            if (!checkEquips.removeElement(e)) {
                return false;
            }
        }
        for (Equip e : oldequips) {
            equips.removeElement(e);
        }
        boostedEquip.setBonus(boostedEquip.getBonus() + 1);
        return true;
    }
}
