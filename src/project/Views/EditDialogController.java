package project.Views;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import project.Datamodel.Datasource;

public class EditDialogController {
    @FXML
    public TextField login;
    @FXML
    public PasswordField password;
    @FXML
    public PasswordField secPassword;

    public boolean validateFields(){
        if(!login.getText().isBlank() && !password.getText().isBlank() && !secPassword.getText().isBlank()){
            if(password.getText().equals(secPassword.getText())){
                return true;
            }
        }
        return false;
    }

    public boolean blankFields(){
        return login.getText().isBlank() || password.getText().isBlank() || secPassword.getText().isBlank();
    }

    public boolean update(String username){
        return Datasource.getInstance().updateAccount(login.getText(), password.getText(), username);
    }
}
