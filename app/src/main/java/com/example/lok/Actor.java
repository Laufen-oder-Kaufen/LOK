package com.example.lok;

/***
 * The abstract class com.example.lok.Actor represents either monsters or heroes or equip
 *
 * id
 * name
 * image
 * icon
 * type: hero or monster class
 * maxHP: maximum Hit Point value
 * currHP: current Hit Point value
 * str: strength attack value
 * def: strength defense value
 * mag: magic attack value
 * mdf: magic defense value
 * agi: agility / speed value
 * luk: luck value
 *
 * types of heroes:
 *  warrior - strength damage and survivability
 *  mage - magical damage and AoE
 *  healer - healing and buffs
 *  rogue - strength damage and utility
 * types of monsters:
 *  [currently not necessary]
 * types of equip:
 *  armor plate - armor pieces for warrior
 *  armor cloth - armor pieces for mage
 *  armor chain - armor pieces for healer
 *  armor leather - armor pieces for rogue
 *  armor common - armor pieces for everyone
 *  weapon heavy - weapons for warrior
 *  weapon arcane - weapons for mage
 *  weapon divine - weapons for healer
 *  weapon light - weapons for rogue
 *  weapon common - weapons for everyone
 *  accessories and talismans are equippable by everyone
 */
abstract public class Actor extends MenuActor {
    private String type;
    private String rarity;
    private int maxHP = 0;
    private int currHP = 0;
    private int str = 0;
    private int def = 0;
    private int mag = 0;
    private int mdf = 0;
    private int agi = 0;
    private int luk = 0;



    public Actor(String name, int id, String type, String rarity, int maxHP, int str, int mag, int def, int mdf, int agi, int luk, int image, int icon) {
        super(id, name, image, icon);
        this.type = type;
        this.rarity = rarity;
        this.maxHP = maxHP;
        this.currHP = maxHP;
        this.str = str;
        this.def = def;
        this.mag = mag;
        this.mdf = mdf;
        this.agi = agi;
        this.luk = luk;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getType() {
        return type;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrHP() {
        return currHP;
    }

    public int getStr() {
        return str;
    }

    public int getDef() {
        return def;
    }

    public int getMag() {
        return mag;
    }

    public int getMdf() {
        return mdf;
    }

    public int getAgi() {
        return agi;
    }

    public int getLuk() {
        return luk;
    }
    public void setType(String type) {
        this.type = type;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void setCurrHP(int currHP) {
        this.currHP = currHP;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setMag(int mag) {
        this.mag = mag;
    }

    public void setMdf(int mdf) {
        this.mdf = mdf;
    }

    public void setAgi(int agi) {
        this.agi = agi;
    }

    public void setLuk(int luk) {
        this.luk = luk;
    }
}

