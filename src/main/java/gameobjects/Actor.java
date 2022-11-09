package gameobjects;

public class Actor extends Thing{
    private Room loc; //Room where the actor is present
    public Actor(String nm, String descr, Room room) {
        super(nm, descr);
        this.loc = room;
    }
    public void setLoc(Room room) {
        this.loc = room;
    }
    public Room getLoc() {
        return loc;
    }
}
