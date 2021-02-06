package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class StuffSectionController {
    @FXML
    public BorderPane borderPane;

    @FXML
    public void displayPreviousPage(MouseEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("DepartmentWindow.fxml"));
        BorderPane temp = new BorderPane();

        try {
            temp.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load department window: " + e.getMessage());
            e.printStackTrace();
        }

        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("AppTopMenu.fxml"));
        try {
            temp.setTop(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load top menu: " + e.getMessage());
        }

        this.borderPane.getScene().setRoot(temp);
    }

    @FXML
    public void loadManagerPage(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("ManagerWindow.fxml"));
        BorderPane temp = new BorderPane();

        try {
            temp.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load manager window: " + e.getMessage());
            e.printStackTrace();
        }

        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("AppTopMenu.fxml"));
        try {
            temp.setTop(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load app top menu: " + e.getMessage());
            e.printStackTrace();
        }

        this.borderPane.getScene().setRoot(temp);
    }

    @FXML
    public void loadVacationPage(ActionEvent event) {

    }

}
