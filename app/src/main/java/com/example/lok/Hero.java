package com.example.lok;

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
public class Hero extends Actor {
    private Skill skill;
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

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Hero(String name, int id, String type, String rarity, int maxHP, int str, int mag, int def, int mdf, int agi, int luk, int image, int icon, int exp) {
        super(name, id,type,rarity, maxHP, str,  mag,  def,  mdf,  agi,  luk,  image,  icon);
}
}
