package gameobjects;

import enums.rl;

// This class adds the capability to have a list of things
// ThingHolder class has objects(like room or actor) which hold a list of things(like items) and are not a list of things themselves
public class ThingHolder extends Thing {
    protected Enum<rl> room;
    protected ThingList things = new ThingList();
    protected Actor enemy;
    public ThingHolder(String nm, String descr, rl roomName) {
        super(nm, descr);
        this.room = roomName;
    }
    public ThingHolder(String nm, String descr, ThingList tl) {
        super(nm, descr);
        this.things = tl;
    }

    ThingHolder(String nm, String descr, ThingList tl, Actor enemyList) {
        super(nm, descr);
        things = tl;
        enemy = enemyList;
       // things.addRange(tl);
    }
    ThingHolder(String nm, String descr, boolean aCanTake, ThingList tl) {
        super(nm, descr, aCanTake);
        things.addRange(tl);
    }


    public String describe() {
        return "Name : " + this.name + "\nDescription : " + this.description + "\nIt contains : " + getThings().describeThings();
    }
    public void setThings(ThingList things) {
        this.things = things;
    }
    public ThingList getThings() {
        return things;
    }

}
