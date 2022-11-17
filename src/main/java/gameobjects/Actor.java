package gameobjects;

import enums.rl;

public class Actor extends ThingHolder{
    private int health;
    private int attackPower;

    public int getAttackPower() {
        return attackPower;
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
    public Actor(String nm, String descr, rl roomName, ThingList tl, int aHealth, int aAttackPower) {
        super(nm, descr, tl);
        this.loc = roomName;
        this.health = aHealth;
        this.attackPower = aAttackPower;
    }
    public Actor(String nm, String descr, rl roomName, int aHealth, int aAttackPower) {
        super(nm, descr, roomName);
        this.loc = roomName;
        this.health = aHealth;
        this.attackPower = aAttackPower;
    }
    public void setLoc(rl roomName) {
        this.loc = roomName;
    }
    public rl getLoc() {
        return loc;
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
