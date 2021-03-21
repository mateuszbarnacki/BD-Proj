package project.Views;

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
import project.Datamodel.Manager;
import project.Utilities.DatabasePath;

import java.io.IOException;
import java.util.Optional;

public class ManagerWindowController {
    @FXML
    public BorderPane borderPane;
    @FXML
    public HBox hBox;
    @FXML
    public TableView<Manager> managersList;
    @FXML
    public Button addManagerButton;

    public void initialize() {
        hBox.setVisible(false);
        refreshListView();
    }

    @FXML
    public void displayPreviousPage(MouseEvent event) {
        PageLoader pageLoader = new PageLoader("StuffSection");
        BorderPane temp = pageLoader.load();
        this.borderPane.getScene().setRoot(temp);
    }

    @FXML
    public void showOptions(MouseEvent event) {
        if(!managersList.getSelectionModel().isEmpty()){
            addManagerButton.setVisible(false);
            hBox.setVisible(true);
            DatabasePath.getInstance().setIdManager(managersList.getSelectionModel().getSelectedItem().getId());
        }
    }

    @FXML
    public void addManager(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("ManagerDialog.fxml"));

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load manager dialog window: " + e.getMessage());
            e.printStackTrace();
        }

        Optional<ButtonType> result = dialog.showAndWait();

        if (result.isPresent() && (result.get() == ButtonType.OK)) {
           ManagerDialogController controller = fxmlLoader.getController();
           if (controller.processResult(1, "wstaw")) {
               AlertLoader alertLoader = new AlertLoader(Alert.AlertType.INFORMATION, "Zaktualizowano listę rekordów", "Dodanie kierownika");
               alertLoader.load();
               refreshListView();
           }
        }
    }

    @FXML
    public void editManager(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("ManagerDialog.fxml"));

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load manager dialog window: " + e.getMessage());
            e.printStackTrace();
        }

        Optional<ButtonType> result = dialog.showAndWait();

        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            ManagerDialogController controller = fxmlLoader.getController();
            if (controller.processResult(managersList.getSelectionModel().getSelectedItem().getId(), "edytuj")) {
                AlertLoader alertLoader = new AlertLoader(Alert.AlertType.INFORMATION, "Zaktualizowano listę rekordów", "Edycja kierownika");
                alertLoader.load();
                refreshListView();
            }
        }
    }

    @FXML
    public void deleteManager(ActionEvent event) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        dialog.setTitle("Usunięcie kierownika");
        dialog.setContentText("Czy na pewno chcesz zwolnić tego kierownika?");

        Optional<ButtonType> response = dialog.showAndWait();
        if (response.isPresent() && (response.get() == ButtonType.OK)) {
            Datasource.getInstance().deleteManager(managersList.getSelectionModel().getSelectedItem().getId());
            refreshListView();
            addManagerButton.setVisible(true);
            hBox.setVisible(false);
        }
    }

    @FXML
    public void loadWorkerPage(ActionEvent event) {
        PageLoader pageLoader = new PageLoader("WorkerWindow");
        BorderPane temp = pageLoader.load();
        this.borderPane.getScene().setRoot(temp);
    }

    private void refreshListView() {
        Task<ObservableList<Manager>> task = new GetManagersByDepartments();
        managersList.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }
}

class GetManagersByDepartments extends Task {
    @Override
    public ObservableList<Manager> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().getManagersByDepartments(DatabasePath.getInstance().getIdDepartment()));
    }
}