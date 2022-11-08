package gameobjects;

public class Player extends Thing{
    private Room loc;
    public Player(String nm, String descr, Room room) {
        super(nm, descr);
        loc = room;
    }
}
