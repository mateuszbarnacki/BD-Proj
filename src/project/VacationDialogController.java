package project;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import org.w3c.dom.events.MouseEvent;
import project.Datamodel.Datasource;

import java.sql.Date;
import java.sql.SQLException;
import java.time.temporal.TemporalField;

public class VacationDialogController {
    @FXML
    public DatePicker beginningDate;
    @FXML
    public DatePicker endDate;

    public boolean processResult(){
        System.out.println(beginningDate.getValue());
        try {
            if (Datasource.getInstance().insertVacation(null)) {
                AlertLoader loader = new AlertLoader(Alert.AlertType.INFORMATION, "Kreator magazynu", "Magazyn został utworzony");
                loader.load();
            }
            return true;
        } catch (SQLException e) {
            AlertLoader loader = new AlertLoader(Alert.AlertType.ERROR, "Błąd utworzenia magazynu", "Nie można utworzyć magazynu: " + e.getMessage().split("!")[0] + "!");
            loader.load();
            return false;
        }
    }

    public void test(javafx.scene.input.MouseEvent event) {
        Date date = Date.valueOf(beginningDate.getValue());
        System.out.println(date);
    }
}
