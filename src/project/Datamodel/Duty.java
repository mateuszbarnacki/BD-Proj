package project.Datamodel;

public class Duty {
    private final int id;
    private final String description;

    public Duty(int id, String data) {
        this.id = id;
        this.description = data;
    }

    public int getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }
}
