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

    public Actor(int id, String name, String image, String icon, String type, int maxHP, int currHP, int str, int def, int mag, int mdf, int agi, int luk) {
        super(id, name, image, icon);
        this.type = type;
        this.maxHP = maxHP;
        this.currHP = currHP;
        this.str = str;
        this.def = def;
        this.mag = mag;
        this.mdf = mdf;
        this.agi = agi;
        this.luk = luk;
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
}
