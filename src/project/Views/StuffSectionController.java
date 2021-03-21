package project.Views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class StuffSectionController {
    @FXML
    public BorderPane borderPane;

    @FXML
    public void displayPreviousPage(MouseEvent event) {
        PageLoader pageLoader = new PageLoader("DepartmentWindow");
        BorderPane temp = pageLoader.load();
        this.borderPane.getScene().setRoot(temp);
    }

    @FXML
    public void loadManagerPage(ActionEvent event) {
        PageLoader pageLoader = new PageLoader("ManagerWindow");
        BorderPane temp = pageLoader.load();
        this.borderPane.getScene().setRoot(temp);
    }

    @FXML
    public void loadVacationPage(ActionEvent event) {
        PageLoader pageLoader = new PageLoader("SecondWorkerWindow");
        BorderPane temp = pageLoader.load();
        this.borderPane.getScene().setRoot(temp);
    }

    @FXML
    public void loadPortfolioPage(ActionEvent event) {
        PageLoader pageLoader = new PageLoader("ReferenceWindow");
        BorderPane temp = pageLoader.load();
        this.borderPane.getScene().setRoot(temp);
    }

}
