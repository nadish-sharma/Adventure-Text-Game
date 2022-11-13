package gameobjects;

import enums.rl;

public class Actor extends ThingHolder{
    private int health;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    private rl loc; //Room where the actor is present
    public Actor(String nm, String descr, rl roomName, boolean tak ,ThingList tl) {
        super(nm, descr, tak, tl);
        this.loc = roomName;
    }
    public Actor(String nm, String descr, rl roomName, ThingList tl) {
        super(nm, descr, tl);
        this.loc = roomName;
    }
    public Actor(String nm, String descr, rl roomName, ThingList tl, int hlth) {
        super(nm, descr, tl);
        this.loc = roomName;
        this.health = hlth;
    }
    public void setLoc(rl roomName) {
        this.loc = roomName;
    }
    public rl getLoc() {
        return loc;
    }
}
