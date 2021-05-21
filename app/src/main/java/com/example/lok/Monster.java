package com.example.lok;

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

    public Monster(String name, int id, String type, String rarity, int maxHP, int str, int mag, int def, int mdf, int agi, int luk, int image, int icon) {
        super(name, id,type,rarity, maxHP, str,  mag,  def,  mdf,  agi,  luk,  image,  icon);
    }
}
