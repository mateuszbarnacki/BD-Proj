package project.Datamodel;

public class Designer {
    private final int id;
    private final String name;
    private final String surname;
    private final String phoneNumber;
    private final String email;

    public Designer(int id, String... data) {
        this.id = id;
        this.name = data[0];
        this.surname = data[1];
        this.email = data[2];
        this.phoneNumber = data[3];
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

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }
}
