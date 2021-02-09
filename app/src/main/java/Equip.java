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

    public void setSlot(String slot){
        slot = slot.toLowerCase(Locale.ROOT);
        switch(slot) {
            case "weapon mainhand":
                this.slot = 1;
            case "mainhand":
                this.slot = 1;
            case "weapon offhand":
                this.slot = 2;
            case "offhand":
                this.slot = 2;
            case "head":
                this.slot = 3;
            case "body":
                this.slot = 4;
            case "arms":
                this.slot = 5;
            case "legs":
                this.slot = 6;
            case "feet":
                this.slot = 7;
            case "talisman":
                this.slot = 8;
            case "accessory":
                this.slot = 9;
        }
    }
}
