package project;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class AppTopMenuController {
    @FXML
    public BorderPane borderPane;

    @FXML
    public void logout(ActionEvent event) {
        Session.getInstance().setToken(null);
        Session.getInstance().lock();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("RootWindow.fxml"));
        BorderPane temp = null;
        try {
            temp = fxmlLoader.load();
        } catch (IOException e) {
            System.out.println("Couldn't load start page: " + e.getMessage());
            e.printStackTrace();
        }
        this.borderPane.getScene().setRoot(temp);
    }

    @FXML
    public void close(ActionEvent event){
        Platform.exit();
    }

    @FXML
    public void printDepartments(ActionEvent event) {
        ReportCreator creator = new ReportCreator("department");
        creator.load(this.borderPane);
    }

    @FXML
    public void printManagers(ActionEvent event) {
        ReportCreator creator = new ReportCreator("manager");
        creator.load(this.borderPane);
    }

    @FXML
    public void printWorkers(ActionEvent event) {
        ReportCreator creator = new ReportCreator("worker");
        creator.load(this.borderPane);
    }

    @FXML
    public void printDesigners(ActionEvent event) {
        ReportCreator creator = new ReportCreator("designer");
        creator.load(this.borderPane);
    }

    @FXML
    public void printDuties(ActionEvent event) {
        ReportCreator creator = new ReportCreator("duty");
        creator.load(this.borderPane);
    }

    @FXML
    public void printVacations(ActionEvent event) {
        ReportCreator creator = new ReportCreator("vacation");
        creator.load(this.borderPane);
    }

    @FXML
    public void printExpositions(ActionEvent event) {
        ReportCreator creator = new ReportCreator("exposition");
        creator.load(this.borderPane);
    }

    @FXML
    public void printCommodities(ActionEvent event) {
        ReportCreator creator = new ReportCreator("commodity");
        creator.load(this.borderPane);
    }

    @FXML
    public void printOpinions(ActionEvent event) {
        ReportCreator creator = new ReportCreator("opinion");
        creator.load(this.borderPane);
    }

}
