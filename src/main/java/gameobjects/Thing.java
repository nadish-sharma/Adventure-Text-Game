package gameobjects;

public abstract class Thing {
    String name;
    String description;

    public Thing() {

    }

    String getName() {
        return name;
    }

    String getDescription() {
        return description;
    }

    void setName(String nm) {
        name = nm;
    }

    void setDescription(String descr) {
        description = descr;
    }
    Thing(String nm, String descr) {
        name = nm;
        description = descr;
    };
}
