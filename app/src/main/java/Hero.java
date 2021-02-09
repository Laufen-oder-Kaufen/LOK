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
 *
 * getEquipmentModifiers() returns the added modifiers of all equipment
 */
public class Hero extends Actor{
    private Skill skill;
    private Equip[] equipment;

    private void equipItem(Equip equip) {
        if (checkCanEquip(equip)){
            equipment[equip.getSlot()] = equip;
        }
        else {
            System.out.println("Gegenstand kann von Held nicht ausgerüstet werden");
        }
    }

    private void unequipItem(Equip equip) {
        equipment[equip.getSlot()] = null;
    }

    private void unequipItem(int slot) {
        equipment[slot] = null;
    }

    private boolean checkCanEquip(Equip equip){
        String etype = equip.getType();
        if (etype.equals("accessory") || etype.equals("talisman") || etype.equals("common") || etype.equals("physical")){ return true; }
        else {
            switch (this.getType()) {
                case "warrior":
                    if (etype.equals("plate") || etype.equals("heavy")){return true;};
                case "mage":
                    if (etype.equals("cloth") || etype.equals("arcane")){return true;};
                case "healer":
                    if (etype.equals("chain") || etype.equals("divine")){return true;};
                case "rogue":
                    if (etype.equals("leather") || etype.equals("light")){return true;};
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

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public void setEquipmentSlot(int i, Equip equip) {
        this.equipment[i] = equip;
    }

    public void setEquipment(Equip[] equipment) {
        this.equipment = equipment;
    }

    public int[] getEquipmentModifiers(){
        int maxHP;
        int currHP;
        int str;
        int def;
        int mag;
        int mdf;
        int agi;
        int luk;
        int[] result = {0, 0, 0, 0, 0, 0, 0, 0};
        for (Equip e:
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

    public Hero() {
        equipment = new Equip[10];
    }
}
