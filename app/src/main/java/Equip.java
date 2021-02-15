import java.util.Locale;

/***
 * The public class Equip represents every kind of item that heroes can equip
 *
 * slot: equipment slot that the equip is equipped on
 *  *  1: Weapon Mainhand
 *  *  2: Weapon Offhand
 *  *  3: Head
 *  *  4: Body
 *  *  5: Arms
 *  *  6: Legs
 *  *  7: Feet
 *  *  8: Talisman
 *  *  9: Accessory
 */
public class Equip extends Actor {
    private int slot = 0;

    public Equip() {
    }

    public int getSlot() {
        return slot;
    }

    public Equip setSlot(int slot) {
        this.slot = slot;
        return this;
    }

    public void setSlot(String slot) {
        slot = slot.toLowerCase(Locale.ROOT);
        switch (slot) {
            case "weapon mainhand":
                this.slot = 1;
                break;
            case "mainhand":
                this.slot = 1;
                break;
            case "main":
                this.slot = 1;
                break;
            case "weapon offhand":
                this.slot = 2;
                break;
            case "offhand":
                this.slot = 2;
                break;
            case "off":
                this.slot = 2;
                break;
            case "head":
                this.slot = 3;
                break;
            case "body":
                this.slot = 4;
                break;
            case "arms":
                this.slot = 5;
                break;
            case "legs":
                this.slot = 6;
                break;
            case "feet":
                this.slot = 7;
                break;
            case "talisman":
                this.slot = 8;
                break;
            case "accessory":
                this.slot = 9;
                break;
        }
    }
}
