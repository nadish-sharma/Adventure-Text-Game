package gameobjects;

import enums.rl;

import java.util.Vector;

public class ElfRoom extends Room{
    private ThingList itemList;
    private Vector<Actor> enemy;
    public ElfRoom(String nm, String descr, rl north, rl south, rl west, rl east, ThingList roomItemList, Vector<Actor> enemy, rl prevRoom) {
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
        System.out.println("Maybe you should have taken all the items in the room. You can take them anytime");
    }
}
