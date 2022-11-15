package gameobjects;

import java.util.Vector;

public class ThingList extends Vector<Thing> implements java.io.Serializable {
    public Vector<Thing> thingList = new Vector<Thing>();

    public Vector<Thing> getThingList() {
        return thingList;
    }

  public ThingList() {
  }

    String describeThings() {

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
    public Thing returnThisObject(String nm) {

        Thing athing = null;
        String thingName = "";
        String lowcase = nm.trim().toLowerCase();
        for(Thing t : this) {
            thingName = t.getName().trim().toLowerCase();
            if(thingName.equals(lowcase)) {
                athing = t;
            }
        }
        return athing;

    }
   /* public void addThing(Thing thing) {
        thingList.add(thing);
    } */

   public void addRange(ThingList tl) {
        thingList.addAll(tl);
    }

}
