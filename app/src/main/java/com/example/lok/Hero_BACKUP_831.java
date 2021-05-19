package com.example.lok;

/***
 * the public class com.example.lok.Hero represents every hero
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
    private int exp;

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
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

<<<<<<< HEAD:app/src/main/java/com/example/lok/Hero.java
    public Hero(String name, int id, String type, String rarity, int maxHP, int str, int mag, int def, int mdf, int agi, int luk, int image, int icon) {
        super(name, id,type,rarity, maxHP, str,  mag,  def,  mdf,  agi,  luk,  image,  icon);
=======
    public Hero(int id, String name, int image, int icon, String type, int maxHP, int currHP, int str, int def, int mag, int mdf, int agi, int luk, int exp) {
        super(id, name, image, icon, type, maxHP, currHP, str, def, mag, mdf, agi, luk);
>>>>>>> 98ce266cd1b663e764c036057a69a5b04b128d77:app/src/main/java/Hero.java
    }
}
