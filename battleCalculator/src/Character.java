abstract public class Character {

    String name;
    String rarity;
    int maxLifepoints;
    int lifepoints;
    int strength;
    int magic;
    int defense;
    int magicalDefense;
    int agility;
    int luck;
    String charClass;
    double damageDealt;
    double damageTaken;
    double roundsSurvived;

    public Character(String name, int lifepoints, int strength, int magic, int defense, int magicalDefense, int agility, int luck, String charClass, String rarity) {
        this.name = name;
        this.maxLifepoints = lifepoints;
        this.strength = strength;
        this.magic = magic;
        this.defense = defense;
        this.magicalDefense = magicalDefense;
        this.agility = agility;
        this.luck = luck;
        this.charClass = charClass;
        this.lifepoints = this.maxLifepoints;
        this.rarity = rarity;
        double damageDealt = 0;
        double damageTaken = 0;
        double roundsSurvived = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxLifepoints() {
        return maxLifepoints;
    }

    public void setMaxlifepoints(int maxLifepoints) {
        this.maxLifepoints = maxLifepoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMagicalDefense() {
        return magicalDefense;
    }

    public void setMagicalDefense(int magicalDefense) {
        this.magicalDefense = magicalDefense;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public void setCharClass(String charClass){this.charClass = charClass; }

    public String getCharClass(){return this.charClass;}

    public int getLifepoints(){return this.lifepoints;}

    public void setLifepoints(int lifepoints){this.lifepoints = lifepoints;}

    public void setRarity(String rarity){this.rarity = rarity;}

    public String getRarity(){return this.rarity;}

    public void setDamageTaken(double damage){
        this.damageTaken=this.damageTaken + damage;
    }
    public void setDamageDealt(double damage){
        this.damageDealt=this.damageDealt + damage;
    }
    public void setRoundsSurvived(double rounds){
        this.roundsSurvived=this.roundsSurvived+rounds;
    }
    public double getDamageTaken(){return this.damageTaken;}
    public double getDamageDealt(){return this.damageDealt;}
    public double getRoundsSurvived(){return this.roundsSurvived;}

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", rarity='" + rarity + '\'' +
                ", maxLifepoints=" + maxLifepoints +
                ", lifepoints=" + lifepoints +
                ", strength=" + strength +
                ", magic=" + magic +
                ", defense=" + defense +
                ", magicalDefense=" + magicalDefense +
                ", agility=" + agility +
                ", luck=" + luck +
                ", charClass='" + charClass + '\'' +
                ", damageDealt=" + damageDealt +
                ", damageTaken=" + damageTaken +
                ", roundsSurvived=" + roundsSurvived +
                '}';
    }
}
