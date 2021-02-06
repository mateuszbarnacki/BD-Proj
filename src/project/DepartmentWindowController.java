package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import project.Datamodel.Department;

public class DepartmentWindowController {
    @FXML
    public ListView<Department> departmentsList;
    @FXML
    public Button insertDepartmentButton;
    @FXML
    public HBox hBox;

    @FXML
    public void displayPreviousPage(MouseEvent event) {

    }

    @FXML
    public void insertDepartment(ActionEvent event) {

    }

    @FXML
    public void loadStuffSection(ActionEvent event) {

    }

    @FXML
    public void loadProductsSection(ActionEvent event) {

    }
}
