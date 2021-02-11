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
    private static boolean isFirst = true;

    public void initialize(){
        if (isFirst) {
            loadStartWindow();
            isFirst = false;
        }
    }

    @FXML
    public void loadStartPage(ActionEvent event){
        RegisterPageLoader loader = new RegisterPageLoader("StartWindow");
        BorderPane temp = loader.load();
        this.borderPane.getScene().setRoot(temp);
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
