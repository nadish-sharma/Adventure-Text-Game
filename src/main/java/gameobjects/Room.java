package gameobjects;

import enums.rl;

import java.util.Vector;

public abstract class Room extends ThingHolder {
    protected rl n,s,w,e;
    protected rl previousRoom;

    public rl getPreviousRoom() {
        return previousRoom;
    }

    Room(String nm, String descr, rl north, rl south, rl west, rl east, ThingList tl, rl prevRoom) {
        super(nm, descr, tl);
        this.n = north;
        this.s = south;
        this.w = west;
        this.e = east;
        this.previousRoom = prevRoom;
    };
        Room(String nm, String descr, rl north, rl south, rl west, rl east, boolean tak ,ThingList tl, Vector<Actor> enemy) {
            super(nm, descr, tak, tl);
        this.n = north;
        this.s = south;
        this.w = west;
        this.e = east;
        };
    public rl getN() {
        return n;
    }
public rl getS() {
        return s;
        }

public rl getW() {
        return w;
        }

public rl getE() {
        return e;
        }
    public abstract Vector<Actor> getActor();

    public abstract String describeEnemy();

    public abstract void lossHelp();
}
