package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import project.Datamodel.Manager;

import java.io.IOException;

public class ManagerWindowController {
    @FXML
    public BorderPane borderPane;
    @FXML
    public HBox hBox;
    @FXML
    public ListView<Manager> managersList;

    public void initialize() {
        hBox.setVisible(false);
    }

    @FXML
    public void displayPreviousPage(MouseEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("StuffSection.fxml"));
        BorderPane temp = new BorderPane();

        try {
            temp.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load stuff section window: " + e.getMessage());
            e.printStackTrace();
        }

        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("AppTopMenu.fxml"));

        try {
            temp.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load app top menu: " + e.getMessage());
            e.printStackTrace();
        }

        this.borderPane.getScene().setRoot(temp);
    }

    @FXML
    public void showOptions(MouseEvent event) {
        if(!managersList.getSelectionModel().isEmpty()){
            hBox.setVisible(true);
        }
    }

    @FXML
    public void addManager(ActionEvent event) {

    }

    @FXML
    public void editManager(ActionEvent event) {

    }

    @FXML
    public void deleteManager(ActionEvent event) {

    }

    @FXML
    public void loadWorkerPage(ActionEvent event) {

    }
}
