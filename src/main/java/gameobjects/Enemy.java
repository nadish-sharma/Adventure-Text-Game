package gameobjects;

import enums.rl;

public class Enemy extends Actor{


    public Enemy(String nm, String descr, rl roomName, boolean tak, ThingList tl) {
        super(nm, descr, roomName, tak, tl);
    }

    public Enemy(String nm, String descr, rl roomName, ThingList tl) {
        super(nm, descr, roomName, tl);
    }
    public Enemy(String nm, String descr, rl roomName, int aHealth, int aAttackPower) {
        super(nm, descr, roomName, aHealth, aAttackPower);
    }

}
