package gameobjects;

public class Thing {
    protected String name;
    protected String description;
    protected  boolean canTake;
    protected int effect;

    public int getEffect() {
        return effect;
    }

    public void setEffect(int effect) {
        this.effect = effect;
    }

    public Thing(String nm, String descr, int effect) {
        name = nm;
        description = descr;
        canTake = true;
        this.effect = effect;
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

  /* public void setName(String nm) {
        name = nm;
    } *//*
   public void setDescription(String descr) {
        description = descr;
    }
    */

}
