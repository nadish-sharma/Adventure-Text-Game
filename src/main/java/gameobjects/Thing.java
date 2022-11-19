package gameobjects;

public class Thing {
    protected String name;
    protected String description;
    protected  boolean canTake;
    protected int healthThingEffect;
    protected int attackThingEffect;

    public int getAttackThingEffect() {
        return attackThingEffect;
    }

    public int gethealthThingEffect() {
        return healthThingEffect;
    }

    public Thing(String nm, String descr, int healthThingEffect, int attackThingEffect) {
        name = nm;
        description = descr;
        canTake = true;
        this.healthThingEffect = healthThingEffect;
        this.attackThingEffect = attackThingEffect;
    };

    public Thing(String nm, String descr) {
        name = nm;
        description = descr;
        canTake = true;
    };

    public Thing(String nm, String descr, boolean aCanTake) {
        name = nm;
        description = descr;
        canTake = aCanTake;
    }

    public String getName() {
        return name;
    }

   public String getDescription() {
        return description;
    }

}
