/***
 * The abstract class ActiveItem describes MenuActors such as potions that are consumable and for active use.
 *
 * maxAmmount: variable for limiting Item access
 *
 * effect(): placeholder for item effect
 */
abstract class ActiveItem extends MenuActor{
    private int maxAmmount;
    abstract void effect();

    public ActiveItem(int id, String name, String image, String icon) {
        super(id, name, image, icon);
    }

    public int getMaxAmmount() {
        return maxAmmount;
    }

    public void setMaxAmmount(int maxAmmount) {
        this.maxAmmount = maxAmmount;
    }
}
