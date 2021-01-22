/***
 * the class Skill describes active hero skills
 *
 * id
 * name
 * icon
 * cd: cool down time of the skill
 */
abstract class Skill {
    private int id;
    private int name;
    private int icon;
    private int cd;

    abstract void skillEffect();

    public Skill(int id, int name, int icon, int cd) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.cd = cd;
    }

    public int getId() {
        return id;
    }

    public int getName() {
        return name;
    }

    public int getIcon() {
        return icon;
    }

    public int getCd() {
        return cd;
    }
}
