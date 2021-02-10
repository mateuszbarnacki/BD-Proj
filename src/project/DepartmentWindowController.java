package project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import project.Datamodel.Datasource;
import project.Datamodel.Department;

import java.io.IOException;
import java.util.Optional;

public class DepartmentWindowController {
    @FXML
    public BorderPane borderPane;
    @FXML
    public ListView<Department> departmentsList;
    @FXML
    public Button insertDepartmentButton;
    @FXML
    public HBox hBox;

    public void initialize() {
        hBox.setVisible(false);
        Task<ObservableList<Department>> task = new GetListOfDepartments();
        departmentsList.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }

    @FXML
    public void showOptions(MouseEvent event) {
        if(!departmentsList.getSelectionModel().isEmpty()){
            insertDepartmentButton.setVisible(false);
            hBox.setVisible(true);
        }
    }

    @FXML
    public void displayPreviousPage(MouseEvent event) {
        PageLoader pageLoader = new PageLoader("WarehouseWindow");
        BorderPane temp = pageLoader.load();
        this.borderPane.getScene().setRoot(temp);
    }

    @FXML
    public void insertDepartment(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("DepartmentDialog.fxml"));

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        dialog.setTitle("Tworzenie działu");

        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load department dialog: " + e.getMessage());
            e.printStackTrace();
        }

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && (result.get() == ButtonType.OK)) {
            DepartmentDialogController controller = fxmlLoader.getController();
            if (controller.processResult()) {
                AlertLoader loader = new AlertLoader(Alert.AlertType.INFORMATION, "Kreator działów", "Zaktualizowano listę działów");
                loader.load();
                Task<ObservableList<Department>> task = new GetListOfDepartments();
                departmentsList.itemsProperty().bind(task.valueProperty());
                new Thread(task).start();
            }
        }
    }

    @FXML
    public void loadStuffSection(ActionEvent event) {
        PageLoader loader = new PageLoader("StuffSection");
        BorderPane temp = loader.load();
        DatabasePath.getInstance().setIdDepartment(departmentsList.getSelectionModel().getSelectedItem().getId());
        this.borderPane.getScene().setRoot(temp);
    }

    @FXML
    public void loadProductsSection(ActionEvent event) {
        PageLoader loader = new PageLoader("ExpositionWindow");
        BorderPane temp = loader.load();
        DatabasePath.getInstance().setIdDepartment(departmentsList.getSelectionModel().getSelectedItem().getId());
        this.borderPane.getScene().setRoot(temp);
    }
}

class GetListOfDepartments extends Task {
    @Override
    public ObservableList<Department> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().getDepartments());
    }
}
