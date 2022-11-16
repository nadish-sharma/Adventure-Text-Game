package gameobjects;

public class MagicItem extends Thing implements Items{
    boolean canTake;
    int healthEffect;
    public MagicItem(String nm, String descr, boolean aCanTake, int aHealthEffect) {
        super(nm, descr);
        canTake = aCanTake;
        healthEffect = aHealthEffect;
    }
    public int getHealthEffect() {
        return healthEffect;
    }

    public boolean getCanTake() {
        return canTake;
    }

    public void setCanTake(boolean canTake) {
        this.canTake = canTake;
    }


    public void setHealthEffect(int aHealthEffect) {
        healthEffect = aHealthEffect;
    }

}
