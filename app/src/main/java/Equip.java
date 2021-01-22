/***
 * The public class Equip represents every kind of item that heroes can equip
 *
 * slot: equipment slot that the equip is equipped on
 */
public class Equip extends Actor{
    private int slot;

    public Equip(int id, String name, String image, String icon, String type, int maxHP, int currHP, int str, int def, int mag, int mdf, int agi, int luk, int slot) {
        super(id, name, image, icon, type, maxHP, currHP, str, def, mag, mdf, agi, luk);
        this.slot = slot;
    }

    public Equip() {
    }

    public int getSlot() {
        return slot;
    }
}
