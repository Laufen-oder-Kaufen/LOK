/***
 * the monster class is a special actor that can hold exp
 *
 * exp
 */
public class Monster extends Actor {
    private int exp;

    public Monster() {
    }

    public int getExp() {
        return exp;
    }

    public Monster setExp(int exp) {
        this.exp = exp;
        return this;
    }
}
