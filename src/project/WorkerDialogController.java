package project;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import project.Datamodel.Datasource;
import project.Datamodel.Worker;

import java.sql.SQLException;

public class WorkerDialogController {
    @FXML
    public TextField name;
    @FXML
    public TextField surname;
    @FXML
    public TextField email;

    public boolean processResult(int id, String type) {
        if (type.equals("wstaw")) {
            if(!name.getText().isEmpty() && !surname.getText().isEmpty() && !email.getText().isEmpty()) {
                Worker worker = new Worker(id, name.getText(), surname.getText(), email.getText());
                try {
                    return Datasource.getInstance().insertWorker(worker);
                } catch (SQLException e) {
                    alertCreator("Błąd utworzenia pracownika", e.getMessage());
                }
            }
            return false;
        } else if (type.equals("edytuj")) {
            if(!name.getText().isEmpty() && !surname.getText().isEmpty() && !email.getText().isEmpty()) {
                Worker worker = new Worker(id, name.getText(), surname.getText(), email.getText());
                try {
                    return Datasource.getInstance().updateWorker(worker);
                } catch (SQLException e) {
                    alertCreator("Błąd edycji pracownika", e.getMessage());
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

