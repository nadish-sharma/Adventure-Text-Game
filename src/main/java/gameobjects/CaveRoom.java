package gameobjects;

import enums.rl;

import java.util.Vector;

public class CaveRoom extends Room{

    private ThingList itemList;
    private Vector<Actor> enemy;
    public CaveRoom(String nm, String descr, rl north, rl south, rl west, rl east, ThingList roomItemList, Vector<Actor> enemy) {
        super(nm, descr, north, south, west, east, roomItemList);
        this.enemy = enemy;
    }
    public Vector<Actor> getActor() {
        return enemy;
    }
}
