package gameobjects;

import enums.rl;

import java.util.Vector;

public class AsceticRoom extends Room {
    private ThingList itemList;
    private Vector<Actor> enemy;
    public AsceticRoom(String nm, String descr, rl north, rl south, rl west, rl east, ThingList tl) {
        super(nm, descr, north, south, west, east, tl);
    }

    AsceticRoom(String nm, String descr, rl north, rl south, rl west, rl east, boolean tak, ThingList tl, Vector<Actor> enemy) {
        super(nm, descr, north, south, west, east, tak, tl, enemy);
    }
    public Vector<Actor> getActor() {

        return enemy;
    }
    public ThingList getItemList() {
        return itemList;
    }
}
