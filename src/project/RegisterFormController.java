package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import project.Datamodel.Account;
import project.Datamodel.Datasource;

import java.util.Optional;

public class RegisterFormController {
    @FXML
    public TextField userNameField;
    @FXML
    public TextField loginField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public PasswordField secPasswordField;

    @FXML
    public void addAccount(ActionEvent event){
        if(fieldsValidation()){
            Account account = new Account(userNameField.getText(), loginField.getText(), passwordField.getText());
            if(Datasource.getInstance().isRecordExists(account.getUsername()) == null){
                if(Datasource.getInstance().insertAccount(account)){
                    alertCreator(Alert.AlertType.INFORMATION, "Konto użytkownika " + userNameField.getText() + " zostało utworzone");
                } else {
                    alertCreator(Alert.AlertType.ERROR, "Nie można utworzyć konta użytkownika " + userNameField.getText() + "!");
                }
            } else {
                alertCreator(Alert.AlertType.ERROR, "Konto użytkownika " + userNameField.getText() + " istnieje już w bazie danych!");
            }
        } else {
            if(!passwordField.getText().equals(secPasswordField.getText())){
                alertCreator(Alert.AlertType.ERROR, "Różne hasła!");
            } else {
                alertCreator(Alert.AlertType.ERROR, "W formularzu występują puste pola!");
            }
        }
    }

    private void alertCreator(Alert.AlertType type, String contentText){
        Alert alert = new Alert(type);
        alert.setTitle("Utworzenie konta");
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        Optional<ButtonType> response = alert.showAndWait();
        if(response.isPresent()){
            alert.close();
        }
    }

    private boolean fieldsValidation(){
        if(!userNameField.getText().isBlank() && !loginField.getText().isBlank() && !passwordField.getText().isBlank() && !secPasswordField.getText().isBlank()){
            if(passwordField.getText().equals(secPasswordField.getText())){
                return true;
            }
        }
        return false;
    }
}
