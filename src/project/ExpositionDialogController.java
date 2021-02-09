package project;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import project.Datamodel.Datasource;
import project.Datamodel.Exposition;

import java.sql.SQLException;

public class ExpositionDialogController {
    @FXML
    public TextField name;

    public boolean processResult(int id, String type, double price) {
        if (type.equals("wstaw")) {
            if(!name.getText().isBlank()) {
                Exposition exposition = new Exposition(id, name.getText(), price);
                try {
                    return Datasource.getInstance().insertExposition(exposition);
                } catch (SQLException e) {
                    alertCreator("Błąd utworzenia ekspozycji", e.getMessage());
                }
            }
            return false;
        } else if (type.equals("edytuj")) {
            if(!name.getText().isBlank()) {
                Exposition exposition = new Exposition(id, name.getText(), price);
                try {
                    return Datasource.getInstance().updateExposition(exposition);
                } catch (SQLException e) {
                    alertCreator("Błąd edycji ekspozycji", e.getMessage());
                }
            }
            return false;
        } else {
            return false;
        }
    }

    private void alertCreator(String title, String content) {
        AlertLoader loader = new AlertLoader(Alert.AlertType.ERROR, title, content);
        loader.load();
    }
}