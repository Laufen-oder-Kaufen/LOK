/***
 * The public class Equip represents every kind of item that heroes can equip
 *
 * slot: equipment slot that the equip is equipped on
 */
public class Equip extends Actor{
    private int slot;

    public Equip() {
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
}
