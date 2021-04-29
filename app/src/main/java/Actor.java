import java.util.Locale;

/***
 * The abstract class Actor represents either monsters or heroes or equip
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
 *  plate - armor pieces for warrior
 *  cloth - armor pieces for mage
 *  chain - armor pieces for healer
 *  leather - armor pieces for rogue
 *  common - armor pieces for everyone
 *  heavy - weapons for warrior
 *  arcane - weapons for mage
 *  divine - weapons for healer
 *  light - weapons for rogue
 *  physical - weapons for everyone
 *  accessories and talismans are equippable by everyone
 */
abstract class Actor extends MenuActor {
    private String type;
    private int maxHP = 0;
    private int currHP = 0;
    private int str = 0;
    private int def = 0;
    private int mag = 0;
    private int mdf = 0;
    private int agi = 0;
    private int luk = 0;
    private String rarity = "";
    String charClass = "";

    public Actor() {
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

    public String getRarity() {
        return rarity;
    }

    public String getCharClass(){return charClass;}

    public Actor setType(String type) {
        this.type = type;
        return this;
    }

    public Actor setMaxHP(int maxHP) {
        this.maxHP = maxHP;
        return this;
    }

    public Actor setCurrHP(int currHP) {
        this.currHP = currHP;
        return this;
    }

    public Actor setStr(int str) {
        this.str = str;
        return this;
    }

    public Actor setDef(int def) {
        this.def = def;
        return this;
    }

    public Actor setMag(int mag) {
        this.mag = mag;
        return this;
    }

    public Actor setMdf(int mdf) {
        this.mdf = mdf;
        return this;
    }

    public Actor setAgi(int agi) {
        this.agi = agi;
        return this;
    }

    public Actor setLuk(int luk) {
        this.luk = luk;
        return this;
    }

    public Actor setRarity(String rarity) {
        this.rarity = rarity;
        return this;
    }

    public Actor setCharClass(String charClass){
        this.charClass = charClass;
        return this;
    }

    /***
     * function to set the entire stat block at once
     * @param maxHP
     * @param str
     * @param def
     * @param mag
     * @param mdf
     * @param agi
     * @param luk
     */
    public void setStatBlock(int maxHP, int str, int def, int mag, int mdf, int agi, int luk) {
        this.maxHP = maxHP;
        this.currHP = this.maxHP;
        this.str = str;
        this.def = def;
        this.mag = mag;
        this.mdf = mdf;
        this.agi = agi;
        this.luk = luk;
    }


    public static void levelUp(Actor actor, int level){
        System.out.println("Level UP");
        double multiplicator = 0;

        if (actor.getRarity().equals("1")) {
            multiplicator = 0.03;
        }

        if (actor.getRarity().equals("2")) {
            multiplicator = 0.04;
        }

        if (actor.getRarity().equals("3")) {
            multiplicator = 0.05;
        }

        if (actor.getRarity().equals("4")) {
            multiplicator = 0.06;
        }

        if (actor.getRarity().equals("5")) {
            multiplicator = 0.07;
        }


        if (actor.getRarity().equals("C")) {
            multiplicator = 0.08;
        }
        if (actor.getRarity().equals("U")) {
            multiplicator = 0.10;
        }
        if (actor.getRarity().equals("R")) {
            multiplicator = 0.11;
        }
        if (actor.getRarity().equals("L")) {
            multiplicator= 0.13;
        }
        System.out.println(actor.toString());

        for (int i = 0; i < level; i++) {

            actor.setMaxHP(actor.getMaxHP() + (int) Math.round(actor.getMaxHP() * multiplicator));
            actor.setCurrHP(actor.getMaxHP());
            actor.setStr(actor.getStr() + (int) Math.round(actor.getStr() * multiplicator));
            if (Math.round(actor.getStr() * multiplicator) == 0){
                actor.setStr(actor.getStr() + 1);
            }

            actor.setDef(actor.getDef() + (int) Math.round(actor.getDef() * multiplicator));

            actor.setMag(actor.getMag() + (int) Math.round(actor.getMag() * multiplicator));
            if (Math.round(actor.getMag() * multiplicator) == 0){
                actor.setMag(actor.getMag() + 1);
            }

            actor.setMdf(actor.getMdf() + (int) Math.round(actor.getMdf() * multiplicator));
            actor.setAgi(actor.getAgi() + (int) Math.round(actor.getAgi() * multiplicator/4));
            if (Math.round(actor.getAgi() * multiplicator) == 0){
                actor.setAgi(actor.getAgi() + 1);
            }
            //              actor.setLuck(actor.getLuck() + (int) Math.round(actor.getLuck() * multiplicator/4));
            System.out.println(actor.toString());
        }

    }
}
