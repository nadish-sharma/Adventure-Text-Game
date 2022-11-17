package gameobjects;

import enums.rl;

import java.util.Vector;

public class DungeanRoom extends Room {
    private ThingList itemList;
    private Vector<Actor> enemy;
    public DungeanRoom(String nm, String descr, rl north, rl south, rl west, rl east, ThingList roomItemList, Vector<Actor> enemy, rl prevRoom) {
        super(nm, descr, north, south, west, east, roomItemList, prevRoom);
        this.enemy = enemy;
    }
    public Vector<Actor> getActor() {
        return enemy;
    }
    public String describeEnemy() {
        return "There is a dangerous enemy here. Beware! His name is: \n\n\t\t\t\t" + enemy.get(0).name +
                "\n" + enemy.get(0).description;
    }
    public void lossHelp() {}
}
