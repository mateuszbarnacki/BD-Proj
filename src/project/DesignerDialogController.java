package project;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import project.Datamodel.Datasource;
import project.Datamodel.Designer;
import project.Datamodel.Manager;

import java.sql.SQLException;

public class DesignerDialogController {
    @FXML
    public TextField name;
    @FXML
    public TextField surname;
    @FXML
    public TextField phoneNumber;
    @FXML
    public TextField email;

    public boolean processResult(int id, String type) {
        if (type.equals("wstaw")) {
            if(!name.getText().isEmpty() && !surname.getText().isEmpty() && !phoneNumber.getText().isEmpty() && !email.getText().isEmpty()) {
                Designer designer = new Designer(id, name.getText(), surname.getText(), email.getText(), phoneNumber.getText());
                try {
                    return Datasource.getInstance().insertDesigner(designer);
                } catch (SQLException e) {
                    alertCreator("Błąd utworzenia kierownika", e.getMessage());
                }
            }
            return false;
        } else if (type.equals("edytuj")) {
            if(!name.getText().isEmpty() && !surname.getText().isEmpty() && !phoneNumber.getText().isEmpty() && !email.getText().isEmpty()) {
                Designer designer = new Designer(id, name.getText(), surname.getText(), email.getText(), phoneNumber.getText());
                try {
                    return Datasource.getInstance().updateDesigner(designer);
                } catch (SQLException e) {
                    alertCreator("Błąd edycji kierownika", e.getMessage());
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
