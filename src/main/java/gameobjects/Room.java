package gameobjects;

import enums.rl;

public abstract class Room extends ThingHolder {
    protected rl n,s,w,e;
    Room(String nm, String descr, rl north, rl south, rl west, rl east, ThingList tl) {
        super(nm, descr, tl);
        this.n = north;
        this.s = south;
        this.w = west;
        this.e = east;
    };
        Room(String nm, String descr, rl north, rl south, rl west, rl east, boolean tak ,ThingList tl) {
            super(nm, descr, tak, tl);
        this.n = north;
        this.s = south;
        this.w = west;
        this.e = east;
        };
public void setN(rl north) {
        this.n = north;
        }

public void setS(rl south) {
        this.s = south;
        }

public void setW(rl west) {
        this.w = west;
        }

public void setE(rl east) {
        this.e = east;
        }
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
}
