package com.example.lok;

/***
 * this class represents any actor or skill that can be represented in a menu
 */
abstract public class MenuActor {
    private int id;
    private String name;
    private int image;
    private int icon;



    public MenuActor(int id, String name, int image, int icon) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public int getIcon() {
        return icon;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
