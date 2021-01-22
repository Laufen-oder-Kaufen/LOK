/***
 * the class Skill describes active hero skills
 *
 * id
 * name
 * icon
 * cd: cool down time of the skill
 */
abstract class Skill extends MenuActor{
    private int cd;

    abstract void skillEffect();

    public Skill(int id, String name, String image, String icon, int cd) {
        super(id, name, image, icon);
        this.cd = cd;
    }

    public int getCd() {
        return cd;
    }
}
