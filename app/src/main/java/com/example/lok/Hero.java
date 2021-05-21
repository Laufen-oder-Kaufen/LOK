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
    private int expToLvlUp;

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public void setExp(int exp) { this.exp = exp; }

    public int getExp() { return exp; }

    public void setExpToLvlUp(int exp) { this.expToLvlUp = exp; }

    public int getExpToLvlUp() { return expToLvlUp; }

    public void levelUp() {
        setMaxHP(getMaxHP() + 10);
        setStr(getStr() + 2);
        setDef(getDef() + 2);
        setMag(getMag() + 2);
        setMdf(getMdf() + 2);
        setAgi(getAgi() + 1);
        setLuk(getLuk() + 1);
        setExpToLvlUp(Math.round(getExpToLvlUp() * 1.2F));
        System.out.println(getExpToLvlUp());
        setExp(0);
//        Float multiplicator;
//        if(this.getRarity().equals("2")){
//            multiplicator = 0.04F;
//        }else if(this.getRarity().equals("3")){
//            multiplicator = 0.05F;
//        }else if(this.getRarity().equals("4")){
//            multiplicator = 0.06F;
//        }else if(this.getRarity().equals("5")){
//            multiplicator = 0.07F;
//        }else if(this.getRarity().equals("C")){
//            multiplicator = 0.08F;
//        }else if(this.getRarity().equals("U")){
//            multiplicator = 0.10F;
//        }else if(this.getRarity().equals("R")){
//            multiplicator = 0.11F;
//        }else if(this.getRarity().equals("L")){
//            multiplicator = 0.13F;
//        }else {
//            multiplicator = 0.03F;
//        }
//        setMaxHP(getMaxHP() + Math.round(getMaxHP() * multiplicator));
//        if(Math.round(getStr() * multiplicator) >= 1) {
//            setStr(getStr() + Math.round(getStr() * multiplicator));
//        }else{
//            setStr(getStr() + 1);
//        }
//        setDef(getDef() + Math.round(getDef() * multiplicator));
//        if(Math.round(getMag() * multiplicator) >= 1) {
//            setMag(getMag() + Math.round(getMag() * multiplicator));
//        }else{
//            setMag(getMag() + 1);
//        }
//        setMdf(getMdf() + Math.round(getMdf() * multiplicator));
//        if(Math.round(getAgi() * multiplicator) >= 1) {
//            setAgi(getAgi() + Math.round(getAgi() * multiplicator));
//        }else{
//            setAgi(getAgi() + 1);
//        }
    }

    public Hero(String name, int id, String type, String rarity, int maxHP, int str, int mag, int def, int mdf, int agi, int luk, int image, int icon) {
        super(name, id,type,rarity, maxHP, str,  mag,  def,  mdf,  agi,  luk,  image,  icon);
        this.exp = 0;
        this.expToLvlUp = 300;
}
}
