package gameobjects;

import enums.rl;

// This class adds the capability to have a list of things
// ThingHolder class has objects(like room or actor) which hold a list of things(like items) and are not a list of things themselves
public class ThingHolder extends Thing {
    protected Enum<rl> room;
    protected ThingList things = new ThingList();
    public ThingHolder(String nm, String descr, rl roomName) {
        super(nm, descr);
        this.room = roomName;
    }
    public ThingHolder(String nm, String descr, rl roomName, ThingList tl) {
        super(nm, descr);
        this.room = roomName;
        this.things = tl;
    }
    public ThingHolder(String nm, String descr, ThingList tl) {
        super(nm, descr);
        this.things = tl;
    }
    ThingHolder(String nm, String descr, boolean aCanTake, ThingList tl) {
        super(nm, descr, aCanTake);
        things.addRange(tl);
    }


    public String describe() {
        return "--------------------"+this.name+"--------------------" +
                "\n"+ this.description + "\nLook! some mystical items are here for you to take:\n"
                + getThings().describeThings();
    }
    public String describeItems() {
        return "Look! some mystical items are here for you to take:\n"
                + getThings().describeThings();
    }
    public ThingList getThings() {
        return things;
    }

    public void setName(String name) {
        this.name = name;
    }
}
