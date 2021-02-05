package project;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import project.Datamodel.Datasource;

public class AppTopMenuController {

    @FXML
    public void close(ActionEvent event){
        Platform.exit();
    }
}
