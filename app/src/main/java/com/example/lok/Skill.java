package com.example.lok;

/***
 * the class com.example.lok.Skill describes active hero skills
 *
 * id
 * name
 * icon
 * cd: cool down time of the skill
 */
<<<<<<< HEAD:app/src/main/java/Skill.java
abstract class Skill extends MenuActor {
=======
public abstract class Skill extends MenuActor{
>>>>>>> ui:app/src/main/java/com/example/lok/Skill.java
    private int cd;

    abstract void skillEffect();

<<<<<<< HEAD:app/src/main/java/Skill.java
    public Skill() {
=======
    public Skill(int id, String name, int image, int icon, int cd) {
        super(id, name, image, icon);
        this.cd = cd;
>>>>>>> ui:app/src/main/java/com/example/lok/Skill.java
    }

    public int getCd() {
        return cd;
    }

    public Skill setCd(int cd) {
        this.cd = cd;
        return this;
    }
}
