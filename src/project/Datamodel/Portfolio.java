package project.Datamodel;

import java.sql.Date;

public class Portfolio {
    private final int id;
    private final String description;
    private final Date date;

    public Portfolio(int id, String description, Date date) {
        this.id = id;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public Date getDate() {
        return this.date;
    }

}
