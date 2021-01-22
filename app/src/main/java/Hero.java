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
    private String skill;
    private Equip[] equipment;

    public String getSkill() {
        return skill;
    }

    public Equip[] getEquipment() {
        return equipment;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void setEquipment(int i, Equip equip) {
        this.equipment[i] = equip;
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
}
