package gameobjects;

// This class adds the capability to have a list of things
// ThingHolder class has objects(like room or actor) which hold a list of things and are not a list of things themselves
public class ThingHolder extends Thing {
    private ThingList thingList;
    ThingHolder(String nm, String descr, ThingList tl) {
        super(nm, descr);
        thingList = tl;
    }
}
