package gameobjects;

public abstract class Thing {
    protected String name;
    protected String description;

   public String getName() {
        return name;
    }

   public String getDescription() {
        return description;
    }

  /* public void setName(String nm) {
        name = nm;
    } *//*
   public void setDescription(String descr) {
        description = descr;
    }
    */
    Thing(String nm, String descr) {
        name = nm;
        description = descr;
    };
}
