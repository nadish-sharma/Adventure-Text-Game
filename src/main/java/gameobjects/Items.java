package gameobjects;

public class Items extends Thing{
    protected boolean canTake;
    protected int healthEffect;

    public Items(String nm, String descr) {
        super(nm, descr);
    }

    public boolean getCanTake() {
        return canTake;
    }

    public void setCanTake(boolean canTake) {
        this.canTake = canTake;
    }
    // standard constructor which uses canTake variable with default value true
    Items(String nm, String descr, int aHealthEffect) {
        super(nm, descr);
        healthEffect = aHealthEffect;
    }
    // alternative constructor
    Items(String nm, String descr, boolean aCanTake, int aHealthEffect) {
        super(nm, descr);
        canTake = aCanTake;
        healthEffect = aHealthEffect;
    }
    public int getHealthEffect() {
        return healthEffect;
    }
}
