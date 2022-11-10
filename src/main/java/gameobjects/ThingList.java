package gameobjects;

import java.util.Vector;

public class ThingList extends Vector<Thing> {
    public String describeThings() {
        String s = "";
        if(this.size() == 0) {
            s = "empty\n";
        } else {
            for(Thing t : this) {
                s = s + t.getName() + " : " + t.getDescription() + "\n";
            }
        }
        return s;
    }
    public Thing giveThisObject(String nm) {
        Thing thing = null;
        String thingName = "";
        String lowcase = nm.trim().toLowerCase();
        for(Thing t : this) {
            thingName = t.getName().trim().toLowerCase();
            if(thingName.equals(lowcase)) {
                thing = t;
            }
        }
        return thing;
    }
}
