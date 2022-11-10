package gameobjects;

import enums.rl;

public abstract class Room extends Thing {
    protected rl n,s,w,e;
        Room(String nm, String descr, rl north, rl south, rl west, rl east) {
            super(nm, descr);
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
