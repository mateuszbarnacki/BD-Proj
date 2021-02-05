package project;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CreateWarehouseDialogController {
    @FXML
    public TextField name;
    @FXML
    public TextField street;
    @FXML
    public TextField city;
    @FXML
    public TextField postcode;

    public boolean processResult(){
        if(!name.getText().isBlank() && !street.getText().isBlank() && !city.getText().isBlank() && !postcode.getText().isBlank()){
            return true;
        }
        return false;
    }
}
