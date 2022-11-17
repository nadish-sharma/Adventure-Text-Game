package gameobjects;

import enums.rl;

import java.util.Vector;

public class KingsmeadRoom extends Room{
    private ThingList itemList;
    private Vector<Actor> enemy;
    public KingsmeadRoom(String nm, String descr, rl north, rl south, rl west, rl east, ThingList roomItemList, Vector<Actor> enemy, rl prevRoom) {
        super(nm, descr, north, south, west, east, roomItemList, prevRoom);
        this.enemy = enemy;
    }
    public Vector<Actor> getActor() {
        return enemy;
    }
    public String describeEnemy() {
        return "There is a dangerous enemy here. Beware! His name is: \n\n" + enemy.get(0).name +
                "\n\n" + enemy.get(0).description;
    }
    public void lossHelp() {
        System.out.println("Only if you had a futuristic weapon equipped or enough health items Alas!");
    }
}
