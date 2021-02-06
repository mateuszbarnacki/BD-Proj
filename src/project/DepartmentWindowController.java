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
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("WarehouseWindow.fxml"));
        BorderPane temp = new BorderPane();

        try {
            temp.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load warehouse window: " + e.getMessage());
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
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Kreator działów");
                alert.setHeaderText(null);
                alert.setContentText("Zaktualizowano listę działów");
                Optional<ButtonType> response = alert.showAndWait();
                if (response.isPresent()) {
                    Task<ObservableList<Department>> task = new GetListOfDepartments();
                    departmentsList.itemsProperty().bind(task.valueProperty());
                    new Thread(task).start();
                    alert.close();
                }
            }
        }
    }

    @FXML
    public void loadStuffSection(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("StuffSection.fxml"));
        BorderPane temp = new BorderPane();

        try{
            temp.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load stuff section page: " + e.getMessage());
            e.printStackTrace();
        }

        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("AppTopMenu.fxml"));
        try{
            temp.setTop(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load app top menu: " + e.getMessage());
            e.printStackTrace();
        }

        this.borderPane.getScene().setRoot(temp);
    }

    @FXML
    public void loadProductsSection(ActionEvent event) {

    }
}

class GetListOfDepartments extends Task {
    @Override
    public ObservableList<Department> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().getDepartments());
    }
}
