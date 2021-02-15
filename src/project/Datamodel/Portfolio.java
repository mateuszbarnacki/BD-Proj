package project.Datamodel;

import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;

public class Portfolio {
    private final int id;
    private final SimpleStringProperty description = new SimpleStringProperty();
    private final Date date;

    public Portfolio(int id, String description, Date date) {
        this.id = id;
        this.description.set(description);
        this.date = date;
    }

    public int getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description.get();
    }

    public Date getDate() {
        return this.date;
    }

}
