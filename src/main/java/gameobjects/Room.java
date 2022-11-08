package gameobjects;
public abstract class Room extends Thing {
    int n,s,w,e;
        Room(String nm, String descr, int north, int south, int west, int east) {
        Thing(nm, descr);
        n = north;
        s = south;
        w = west;
        e = east;
        };
public void setN(int north) {
        n = north;
        }

public int getN() {
        return n;
        }

public void setS(int south) {
        s = south;
        }

public void setW(int west) {
        w = west;
        }

public void setE(int east) {
        e = east;
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
