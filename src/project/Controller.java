package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class Controller {
    @FXML
    public BorderPane borderPane;

    @FXML
    public void loadRegisterForm(ActionEvent event){
        RegisterPageLoader loader = new RegisterPageLoader("RegisterForm");
        BorderPane temp = loader.load();
        this.borderPane.getScene().setRoot(temp);
    }

    @FXML
    public void loadLoginForm(ActionEvent event){
        RegisterPageLoader loader = new RegisterPageLoader("LoginForm");
        BorderPane temp = loader.load();
        this.borderPane.getScene().setRoot(temp);
    }

}
