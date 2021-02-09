package project.Datamodel;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Commodity {
    private final int id;
    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleDoubleProperty price = new SimpleDoubleProperty();

    public Commodity(int id, String name, double price) {
        this.id = id;
        this.name.set(name);
        this.price.set(price);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name.get();
    }

    public double getPrice() {
        return this.price.get();
    }

    @Override
    public String toString() {
        return "Nazwa: " + this.name.get() + " \nCena: " + this.price.get();
    }
}
