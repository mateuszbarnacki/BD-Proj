package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class Controller {
    @FXML
    public BorderPane borderPane;

    @FXML
    public void loadRegisterForm(ActionEvent event){
       formLoader("Register");
    }

    @FXML
    public void loadLoginForm(ActionEvent event){
        formLoader("Login");
    }

    private boolean formLoader(String type){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(type+"Form.fxml"));

        try{
            borderPane.setCenter(fxmlLoader.load());
            return true;
        }catch (IOException e){
            System.out.println("Couldn't load " + type + " form: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
