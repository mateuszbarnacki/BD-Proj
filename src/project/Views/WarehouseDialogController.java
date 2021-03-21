package project.Views;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import project.Datamodel.Datasource;
import project.Datamodel.Warehouse;
import project.Views.AlertLoader;

import java.sql.SQLException;

public class WarehouseDialogController {
    @FXML
    public TextField name;
    @FXML
    public TextField street;
    @FXML
    public TextField city;
    @FXML
    public TextField postcode;

    public boolean processResult(String type){
        Warehouse warehouse = new Warehouse(name.getText(), street.getText(), city.getText(), postcode.getText());
        if (type.equals("wstaw")) {
            try {
                if (Datasource.getInstance().insertWarehouse(warehouse)) {
                    AlertLoader loader = new AlertLoader(Alert.AlertType.INFORMATION, "Kreator magazynu", "Magazyn został utworzony");
                    loader.load();
                }
                return true;
            } catch (SQLException e) {
                AlertLoader loader = new AlertLoader(Alert.AlertType.ERROR, "Błąd utworzenia magazynu", "Nie można utworzyć magazynu: " + e.getMessage().split("!")[0] + "!");
                loader.load();
                return false;
            }
        } else if (type.equals("edytuj")) {
            try{
                if(Datasource.getInstance().updateWarehouse(warehouse)){
                    AlertLoader loader = new AlertLoader(Alert.AlertType.INFORMATION, "Edytor magazynu", "Magazyn został edytowany");
                    loader.load();
                }
                return true;
            } catch (SQLException e) {
                AlertLoader loader = new AlertLoader(Alert.AlertType.ERROR, "Błąd edycji magazynu", "Nie można edytować magazynu: " + e.getMessage().split("!")[0] + "!");
                loader.load();
                return false;
            }
        }
        return false;
    }
}
