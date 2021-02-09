package project;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import project.Datamodel.Commodity;
import project.Datamodel.Datasource;
import java.sql.SQLException;

public class CommodityDialogController {
    @FXML
    public TextField name;
    @FXML
    public TextField price;

    public boolean processResult(int id, String type) {
        if (type.equals("wstaw")) {
            if(!name.getText().isBlank() && !price.getText().isBlank()) {
                Commodity commodity = new Commodity(id, name.getText(), Double.parseDouble(price.getText()));
                try {
                    return Datasource.getInstance().insertCommodity(commodity);
                } catch (SQLException e) {
                    alertCreator("Błąd utworzenia towaru", e.getMessage());
                }
            }
            return false;
        } else if (type.equals("edytuj")) {
            if(!name.getText().isBlank() && !price.getText().isBlank()) {
                Commodity commodity = new Commodity(id, name.getText(), Double.parseDouble(price.getText()));
                try {
                    return Datasource.getInstance().updateCommodity(commodity);
                } catch (SQLException e) {
                    alertCreator("Błąd edycji towaru", e.getMessage());
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
