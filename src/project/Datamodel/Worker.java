package project.Datamodel;

public class Worker {
    private final int id;
    private final String name;
    private final String surname;
    private final String email;

    public Worker(int id, String... data) {
        this.id = id;
        this.name = data[0];
        this.surname = data[1];
        this.email = data[2];
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getEmail() {
        return this.email;
    }
}
