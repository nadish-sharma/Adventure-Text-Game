package gameobjects;

public abstract class Thing {
    protected String name;
    protected String description;

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
