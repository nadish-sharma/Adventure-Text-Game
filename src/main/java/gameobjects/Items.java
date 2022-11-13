package gameobjects;

public abstract class Items extends Thing{
    protected boolean canTake;
    protected int healthEffect;

    public boolean getCanTake() {
        return canTake;
    }

    public void setCanTake(boolean canTake) {
        this.canTake = canTake;
    }
    // standard constructor which uses canTake variable with default value true
    Items(String nm, String descr) {
        super(nm, descr);
        canTake = true;
    }
    // alternative constructor
    Items(String nm, String descr, boolean aCanTake) {
        super(nm, descr);
        canTake = aCanTake;
    }
    Items(String nm, String descr, boolean aCanTake, int ahealthEffect) {
        super(nm, descr);
        canTake = aCanTake;
        healthEffect = ahealthEffect;
    }

}
