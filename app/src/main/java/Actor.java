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
 */
abstract class Actor {
    private int id;
    private String name;
    private String image;
    private String icon;
    private String type;
    private int maxHP;
    private int currHP;
    private int str;
    private int def;
    private int mag;
    private int mdf;
    private int agi;
    private int luk;

    public Actor() {
    }

    public Actor(int id, String name, String image, String icon, String type, int maxHP, int currHP, int str, int def, int mag, int mdf, int agi, int luk) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.icon = icon;
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getIcon() {
        return icon;
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
