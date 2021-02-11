package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import project.Datamodel.Account;
import project.Datamodel.Datasource;

public class RegisterFormController {
    @FXML
    public BorderPane borderPane;
    @FXML
    public TextField userNameField;
    @FXML
    public TextField loginField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public PasswordField secPasswordField;

    @FXML
    public void displayPreviousPage(MouseEvent event) {
        RegisterPageLoader loader = new RegisterPageLoader("StartWindow");
        BorderPane temp = loader.load();
        this.borderPane.getScene().setRoot(temp);
    }

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
        AlertLoader alertLoader = new AlertLoader(type, "Utworzenie konta", contentText);
        alertLoader.load();
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
