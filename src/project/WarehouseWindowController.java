package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import project.Datamodel.Datasource;
import project.Datamodel.Warehouse;

import java.io.IOException;
import java.util.Optional;

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
    public Button updateWarehouseButton;
    @FXML
    public Button manageDepartmentButton;
    @FXML
    public BorderPane borderPane;
    @FXML
    public GridPane gridPane;

    public void initialize(){
        Datasource.getInstance().createSchema();
        Datasource.getInstance().openUserEnvironment();
        if(Datasource.getInstance().isWarehouseExists()){
            setLabels();
            gridPane.setVisible(true);
            createWarehouseButton.setVisible(false);
            updateWarehouseButton.setVisible(true);
            manageDepartmentButton.setVisible(true);
        } else {
            gridPane.setVisible(false);
            createWarehouseButton.setVisible(true);
            updateWarehouseButton.setVisible(false);
            manageDepartmentButton.setVisible(false);
        }
    }

    @FXML
    public void createWarehouse(ActionEvent event){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("WarehouseDialog.fxml"));

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Kreator magazynu");
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e){
            System.out.println("Couldn't load create warehouse dialog: " + e.getMessage());
            e.printStackTrace();
        }

        Optional<ButtonType> response = dialog.showAndWait();
        if(response.isPresent() && (response.get() == ButtonType.OK)) {
            WarehouseDialogController controller = fxmlLoader.getController();
            if(controller.processResult("wstaw")){
                setLabels();
                gridPane.setVisible(true);
                createWarehouseButton.setVisible(false);
                updateWarehouseButton.setVisible(true);
                manageDepartmentButton.setVisible(true);
            }
        }
    }

    @FXML
    public void editWarehouse(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("WarehouseDialog.fxml"));

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Edytor magazynu");
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e){
            System.out.println("Couldn't load update warehouse dialog: " + e.getMessage());
            e.printStackTrace();
        }

        Optional<ButtonType> response = dialog.showAndWait();
        if(response.isPresent() && (response.get() == ButtonType.OK)) {
            WarehouseDialogController controller = fxmlLoader.getController();
            if(controller.processResult("edytuj")){
                setLabels();
            }
        }
    }

    @FXML
    public void manageDepartment(ActionEvent event){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("DepartmentWindow.fxml"));

        BorderPane temp = new BorderPane();
        try{
            temp.setCenter(fxmlLoader.load());
        } catch (IOException e){
            System.out.println("Couldn't load department window: " + e.getMessage());
            e.printStackTrace();
        }
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("AppTopMenu.fxml"));
        try{
            temp.setTop(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load top menu bar: " + e.getMessage());
        }

        this.borderPane.getScene().setRoot(temp);
    }

    private void setLabels(){
        Warehouse warehouse = Datasource.getInstance().getWarehouseData();
        nameLabel.setText(warehouse.getName());
        streetLabel.setText(warehouse.getStreet());
        cityLabel.setText(warehouse.getCity());
        postcodeLabel.setText(warehouse.getPostcode());
    }
}
