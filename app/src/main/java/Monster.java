/***
 * the monster class is a special actor that can hold exp
 */
public class Monster extends Actor{
    private int exp;

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public Monster(int id, String name, String image, String icon, String type, int maxHP, int currHP, int str, int def, int mag, int mdf, int agi, int luk) {
        super(id, name, image, icon, type, maxHP, currHP, str, def, mag, mdf, agi, luk);
    }
}
