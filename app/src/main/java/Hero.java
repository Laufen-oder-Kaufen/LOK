import java.lang.reflect.Array;
import java.util.ArrayList;

/***
 * the public class Hero represents every hero
 *
 * skill: the usable hero skill
 * equipment: the array of equipment slots
 *  1: Weapon Mainhand
 *  2: Weapon Offhand
 *  3: Head
 *  4: Body
 *  5: Arms
 *  6: Legs
 *  7: Feet
 *  8: Talisman
 *  9: Accessory
 */
public class Hero extends Actor {
    private Skill skill;
    private Equip[] equipment;


    public Hero() {
        equipment = new Equip[10];
        setType("warrior");
    }
    /***
     * function to equip an item. Checks if Equip type is compatible, and if Equip exists on that slot, returns that
     * Equip
     * @param equip
     * @return Equip if the function had to unequip an already existent equip
     */
    public Equip equip(Equip equip) {
        if (checkCanEquip(equip)) {
            if (equipment[equip.getSlot()] == null) {
                equipment[equip.getSlot()] = equip;
            } else {
                Equip e = unequip(equip.getSlot());
                equipment[equip.getSlot()] = equip;
                return e;
            }
        } else {
            System.out.println("Gegenstand kann von Held nicht ausgerüstet werden");
        }
        return null;
    }

    /***
     * unequips an equipment by Object
     * @param equip
     * @return the unequipped Item
     */
    public Equip unequip(Equip equip) {
        Equip e = equipment[equip.getSlot()];
        equipment[equip.getSlot()] = null;
        return e;
    }

    /***
     * unequips an equipment by slot
     * @param slot
     * @return the unequipped Item
     */
    public Equip unequip(int slot) {
        Equip e = equipment[slot];
        equipment[slot] = null;
        return e;
    }

    /***
     * checks whether or not a Hero can equip a certain Equip based on type
     * @param equip
     * @return
     */
    private boolean checkCanEquip(Equip equip) {
        String etype = equip.getType();
        if (etype.equals("accessory") || etype.equals("talisman") || etype.equals("common") || etype.equals("physical")) {
            return true;
        } else {
            switch (this.getType()) {
                case "warrior":
                    if (etype.equals("plate") || etype.equals("heavy")) {
                        return true;
                    }
                    ;
                case "mage":
                    if (etype.equals("cloth") || etype.equals("arcane")) {
                        return true;
                    }
                    ;
                case "healer":
                    if (etype.equals("chain") || etype.equals("divine")) {
                        return true;
                    }
                    ;
                case "rogue":
                    if (etype.equals("leather") || etype.equals("light")) {
                        return true;
                    }
                    ;
            }
        }
        return false;
    }

    public Skill getSkill() {
        return skill;
    }

    public Equip[] getEquipment() {
        return equipment;
    }

    public Hero setSkill(Skill skill) {
        this.skill = skill;
        return this;
    }

    public Hero setEquipment(Equip[] equipment) {
        this.equipment = equipment;
        return this;
    }

    public Hero setEquipmentSlot(int slot, Equip equip) {
        this.equipment[slot] = equip;
        return this;
    }

    /***
     * adds up all modifiers of equipment of all slots
     * @return
     */
    public int[] getEquipmentModifiers() {
        int maxHP;
        int currHP;
        int str;
        int def;
        int mag;
        int mdf;
        int agi;
        int luk;
        int[] result = {0, 0, 0, 0, 0, 0, 0, 0};
        for (Equip e :
                this.equipment) {
            result[1] += e.getMaxHP();
            result[2] += e.getCurrHP();
            result[3] += e.getStr();
            result[4] += e.getDef();
            result[5] += e.getMag();
            result[6] += e.getMdf();
            result[7] += e.getAgi();
            result[8] += e.getLuk();
        }
        return result;
    }
}
