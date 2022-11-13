package gameobjects;

import enums.rl;

public class Room1 extends Room {
    private ThingList monsterList;
    public Room1(String nm, String descr, rl north, rl south, rl west, rl east, ThingList room0List) {
        super(nm, descr, north, south, west, east, room0List);
        this.monsterList = monsterList;

    }

}
