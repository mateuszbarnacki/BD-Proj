package project.Datamodel;

import javafx.beans.property.SimpleStringProperty;
import java.sql.Date;

public class Reference {
    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleStringProperty surname = new SimpleStringProperty();
    private final SimpleStringProperty description = new SimpleStringProperty();
    private final Date date;

    public Reference(Date date, String... data) {
        this.date = date;
        this.name.set(data[0]);
        this.surname.set(data[1]);
        this.description.set(data[2]);
    }

    public String getName() {
        return this.name.get();
    }

    public String getSurname() {
        return this.surname.get();
    }

    public String getDescription() {
        return this.description.get();
    }

    public Date getDate() {
        return this.date;
    }
}
