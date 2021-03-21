package project.Views;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import project.Datamodel.Account;
import project.Datamodel.Datasource;

public class LoginDialogController {
    @FXML
    public TextField login;
    @FXML
    public TextField password;
    @FXML
    public Label errorLabel;

    public boolean validateFields(){
        if(!login.getText().isBlank() && !password.getText().isBlank()){
            errorLabel.setVisible(false);
            return true;
        }
        errorLabel.setVisible(true);
        return false;
    }

    public boolean login(String username){
        Account account = Datasource.getInstance().isRecordExists(username);
        return account.getLogin().equals(login.getText()) && account.getPassword().equals(password.getText());
    }
}
