package com.example.lok;

/***
 * The public class com.example.lok.Equip represents every kind of item that heroes can equip
 *
 * slot: equipment slot that the equip is equipped on
 */
public class Equip extends Actor{
    private int slot;

    public Equip(String name, int id, String type, String rarity, int maxHP, int str, int mag, int def, int mdf, int agi, int luk, int image, int icon) {
        super(name, id,type,rarity, maxHP, str,  mag,  def,  mdf,  agi,  luk,  image,  icon);
    }

    public int getSlot() {
        return slot;
    }
}
