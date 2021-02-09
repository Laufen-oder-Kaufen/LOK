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

    public ActiveItem() {
    }

    public int getMaxAmmount() {
        return maxAmmount;
    }

    public void setMaxAmmount(int maxAmmount) {
        this.maxAmmount = maxAmmount;
    }
}
