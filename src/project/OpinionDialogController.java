package project;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import project.Datamodel.Datasource;
import project.Datamodel.Opinion;

import java.sql.SQLException;

public class OpinionDialogController {
    @FXML
    public TextArea description;

    public boolean processResult() {
        if (!description.getText().isBlank()) {
            Opinion opinion = new Opinion(1, description.getText());
            try {
                return Datasource.getInstance().insertOpinion(opinion);
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
