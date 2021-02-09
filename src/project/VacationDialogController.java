package project;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import project.Datamodel.Datasource;
import project.Datamodel.Vacation;

import java.sql.Date;
import java.sql.SQLException;

public class VacationDialogController {
    @FXML
    public DatePicker beginningDate;
    @FXML
    public DatePicker endDate;

    public boolean processResult(){
        Date begin = Date.valueOf(beginningDate.getValue());
        Date end = Date.valueOf(endDate.getValue());
        Vacation vacation = new Vacation(1, begin, end);
        try {
            if (begin.compareTo(end) <= 0) {
                return Datasource.getInstance().insertVacation(vacation);
            } else {
                throw new SQLException("Błędny przydział czasu!");
            }
        } catch (SQLException e) {
            AlertLoader loader = new AlertLoader(Alert.AlertType.ERROR, "Błąd dodania urlopu", "Nie można zapisać urlopu: " + e.getMessage().split("!")[0] + "!");
            loader.load();
            return false;
        }
    }
}
