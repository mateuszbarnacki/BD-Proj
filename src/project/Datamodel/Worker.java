package project.Datamodel;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Worker {
    private final SimpleIntegerProperty id = new SimpleIntegerProperty();
    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleStringProperty surname = new SimpleStringProperty();
    private final SimpleStringProperty email = new SimpleStringProperty();

    public Worker(int id, String... data) {
        this.id.set(id);
        this.name.set(data[0]);
        this.surname.set(data[1]);
        this.email.set(data[2]);
    }

    public int getId() {
        return this.id.get();
    }

    public String getName() {
        return this.name.get();
    }

    public String getSurname() {
        return this.surname.get();
    }

    public String getEmail() {
        return this.email.get();
    }

    @Override
    public String toString() {
        return "Imie: " + this.name.get() + " \nNazwisko: " + this.surname.get() + " \nAdres email: " + this.email.get();
    }
}
