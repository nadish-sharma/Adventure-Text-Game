package gameobjects;

import java.util.ArrayList;
import java.util.Vector;

public class Map extends Room{

    Map(String nm, String descr, int north, int south, int west, int east) {
        super(nm, descr, north, south, west, east);
    }
    public static void main(String[] args) {
        Vector<Room> map = new Vector<Room>();
        map.add(new Room1("Dungean", "This is a dark place!", -1,2,-1,-1));
        map.add(new Room1("Cave", "Darkness own home", -1,-1,0,-1));
        map.add(new Room2("Forest", "Here the wild animals and trees traverse", 0,-1,-1,3));
    }
}
