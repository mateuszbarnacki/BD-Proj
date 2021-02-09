package project.Datamodel;

import java.sql.Date;

public class Vacation {
    private final int id;
    private final Date beginning;
    private final Date end;

    public Vacation(int id, Date... data) {
        this.id = id;
        this.beginning = data[0];
        this.end = data[1];
    }

    public int getId() {
        return this.id;
    }

    public Date getBeginning() {
        return this.beginning;
    }

    public Date getEnd() {
        return this.end;
    }

    @Override
    public String toString() {
        return "Data rozpoczęcia: " + this.beginning + " \nData zakończenia: " + this.end;
    }
}
