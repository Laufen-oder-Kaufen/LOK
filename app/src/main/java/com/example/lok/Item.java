package com.example.lok;

import android.view.Menu;

public class Item extends MenuActor{
    private String rarity;

    public Item(int id, String name, int image, int icon, String rarity){
        super(id, name, image, icon);
        this.rarity = rarity;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }
}