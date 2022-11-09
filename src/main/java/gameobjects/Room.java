package gameobjects;
public abstract class Room extends Thing {
    protected int n,s,w,e;
        Room(String nm, String descr, int north, int south, int west, int east) {
            super(nm, descr);
        this.n = north;
        this.s = south;
        this.w = west;
        this.e = east;
        };
public void setN(int north) {
        this.n = north;
        }

public int getN() {
        return n;
        }

public void setS(int south) {
        this.s = south;
        }

public void setW(int west) {
        this.w = west;
        }

public void setE(int east) {
        this.e = east;
        }

public int getS() {
        return s;
        }

public int getW() {
        return w;
        }

public int getE() {
        return e;
        }
}
