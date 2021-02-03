package project;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class RootWindowController {
    @FXML
    public BorderPane borderPane;

    public void initialize(){
        loadStartWindow();
    }

    @FXML
    public void loadStartPage(ActionEvent event){
        loadStartWindow();
    }

    @FXML
    public void closeApp(ActionEvent event){
        Platform.exit();
    }

    private boolean loadStartWindow(){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("StartWindow.fxml"));

        try{
            borderPane.setCenter(fxmlLoader.load());
            return true;
        } catch (IOException e){
            System.out.println("Couldn't load start window: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
