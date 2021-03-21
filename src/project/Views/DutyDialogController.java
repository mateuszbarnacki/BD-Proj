package project.Views;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import project.Datamodel.Datasource;
import project.Datamodel.Duty;
import project.Views.AlertLoader;

import java.sql.SQLException;

public class DutyDialogController {
    @FXML
    public TextArea description;

    public boolean processResult() {
        if (!description.getText().isBlank()) {
            Duty duty = new Duty(1, description.getText());
            try {
                return Datasource.getInstance().insertDuty(duty);
            } catch (SQLException e) {
                alertCreator("Błąd utworzenia obowiązku", e.getMessage());
            }
        }
        return false;
    }

    private void alertCreator(String title, String content) {
        AlertLoader loader = new AlertLoader(Alert.AlertType.ERROR, title, content);
        loader.load();
    }
}