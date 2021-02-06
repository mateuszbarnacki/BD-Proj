package project;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import project.Datamodel.Datasource;
import project.Datamodel.Warehouse;

import java.sql.SQLException;
import java.util.Optional;

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
                    informationAlertCreator("Kreator magazynu", "Magazyn został utworzony");
                }
                return true;
            } catch (SQLException e) {
                errorAlertCreator("Błąd utworzenia magazynu", "Nie można utworzyć magazynu: ", e);
                return false;
            }
        } else if (type.equals("edytuj")) {
            try{
                if(Datasource.getInstance().updateWarehouse(warehouse)){
                    informationAlertCreator("Edytor magazynu", "Magazyn został edytowany");
                }
                return true;
            } catch (SQLException e) {
                errorAlertCreator("Błąd edycji magazynu", "Nie można edytować magazynu: ", e);
                return false;
            }
        }
        return false;
    }

    private void informationAlertCreator(String title, String info){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(info);
        Optional<ButtonType> response = alert.showAndWait();
        if (response.isPresent()) {
            alert.close();
        }
    }

    private void errorAlertCreator(String title, String info, SQLException e){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(info + e.getMessage().split("!")[0] + "!");
        Optional<ButtonType> response = alert.showAndWait();
        if(response.isPresent()){
            alert.close();
        }
    }
}
