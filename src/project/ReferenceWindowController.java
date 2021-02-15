package project;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class ReferenceWindowController {
    @FXML
    public BorderPane borderPane;

    @FXML
    public void displayPreviousPage(MouseEvent event) {
        PageLoader pageLoader = new PageLoader("StuffSection");
        BorderPane temp = pageLoader.load();
        this.borderPane.getScene().setRoot(temp);
    }

}
