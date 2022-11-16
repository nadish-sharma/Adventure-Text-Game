package gameobjects;

public class WeaponItem extends Thing implements Items{

    boolean canTake;
    int healthEffect;
    // standard constructor which uses canTake variable with default value true

    public WeaponItem(String nm, String descr, boolean aCanTake, int aHealthEffect) {
        super(nm, descr, aHealthEffect);
        canTake = aCanTake;
    }

    public boolean getCanTake() {
        return canTake;
    }

    public void setCanTake(boolean canTake) {
        this.canTake = canTake;
    }

}
