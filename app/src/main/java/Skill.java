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

    public Skill() {
    }

    public int getCd() {
        return cd;
    }

    public void setCd(int cd) {
        this.cd = cd;
    }
}
