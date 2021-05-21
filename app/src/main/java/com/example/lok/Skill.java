package com.example.lok;

/***
 * the class com.example.lok.Skill describes active hero skills
 *
 * id
 * name
 * icon
 * cd: cool down time of the skill
 */
public abstract class Skill extends MenuActor {

    private int cd;

    abstract void skillEffect();

    public Skill(int id, String name, int image, int icon, int cd) {
        super(id, name, image, icon);
        this.cd = cd;
    }

    public int getCd() {
        return cd;
    }

    public Skill setCd(int cd) {
        this.cd = cd;
        return this;
    }
}
