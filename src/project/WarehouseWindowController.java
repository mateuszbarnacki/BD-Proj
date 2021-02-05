package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import project.Datamodel.Datasource;

public class WarehouseWindowController {
    @FXML
    public Label nameLabel;
    @FXML
    public Label streetLabel;
    @FXML
    public Label cityLabel;
    @FXML
    public Label postcodeLabel;
    @FXML
    public Button createWarehouseButton;
    @FXML
    public Button manageDepartmentButton;
    @FXML
    public GridPane gridPane;

    public void initialize(){
        Datasource.getInstance().createSchema();
        Datasource.getInstance().openUserEnvironment();
        if(Datasource.getInstance().isWarehouseExists()){
            gridPane.setVisible(true);
            createWarehouseButton.setVisible(false);
            manageDepartmentButton.setVisible(true);
        } else {
            gridPane.setVisible(false);
            createWarehouseButton.setVisible(true);
            manageDepartmentButton.setVisible(false);
        }
    }

    @FXML
    public void createWarehouse(ActionEvent event){

    }

    @FXML
    public void manageDepartment(ActionEvent event){

    }

}
