package gameobjects;

// This class adds the capability to have a list of things
// ThingHolder class has objects(like room or actor) which hold a list of things(like items) and are not a list of things themselves
public class ThingHolder extends Thing {
    private ThingList things = new ThingList();

    public ThingList getThings() {
        return things;
    }

    public void setThings(ThingList things) {
        this.things = things;
    }

    ThingHolder(String nm, String descr, ThingList tl) {
        super(nm, descr);
        things.addRange(tl);
    }
    ThingHolder(String nm, String descr, boolean aCanTake, ThingList tl) {
        super(nm, descr, aCanTake);
        things.addRange(tl);
    }
    public String describe() {
        return "Name : " + this.name + "\nDescription : " + this.description + "\nIt contains : " + getThings().describeThings();
    }

}
