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
import project.Datamodel.Worker;

import java.io.IOException;
import java.util.Optional;

public class WorkerWindowController {
    @FXML
    public BorderPane borderPane;
    @FXML
    public HBox hBox;
    @FXML
    public TableView<Worker> workersList;
    @FXML
    public Button addWorkerButton;

    public void initialize() {
        hBox.setVisible(false);
        refreshListView();
    }

    @FXML
    public void displayPreviousPage(MouseEvent event) {
        PageLoader pageLoader = new PageLoader("ManagerWindow");
        BorderPane temp = pageLoader.load();
        this.borderPane.getScene().setRoot(temp);
    }

    @FXML
    public void showOptions(MouseEvent event) {
        if(!workersList.getSelectionModel().isEmpty()){
            addWorkerButton.setVisible(false);
            hBox.setVisible(true);
            DatabasePath.getInstance().setIdWorker(workersList.getSelectionModel().getSelectedItem().getId());
        }
    }

    @FXML
    public void addWorker(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("WorkerDialog.fxml"));

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load worker dialog window: " + e.getMessage());
            e.printStackTrace();
        }

        Optional<ButtonType> result = dialog.showAndWait();

        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            WorkerDialogController controller = fxmlLoader.getController();
            if (controller.processResult(1, "wstaw")) {
                AlertLoader alertLoader = new AlertLoader(Alert.AlertType.INFORMATION, "Zaktualizowano listę rekordów", "Dodanie pracownika");
                alertLoader.load();
                refreshListView();
            }
        }
    }

    @FXML
    public void editWorker(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("WorkerDialog.fxml"));

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load worker dialog window: " + e.getMessage());
            e.printStackTrace();
        }

        Optional<ButtonType> result = dialog.showAndWait();

        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            WorkerDialogController controller = fxmlLoader.getController();
            if (controller.processResult(workersList.getSelectionModel().getSelectedItem().getId(), "edytuj")) {
                AlertLoader alertLoader = new AlertLoader(Alert.AlertType.INFORMATION, "Zaktualizowano listę rekordów", "Edycja pracownika");
                alertLoader.load();
                refreshListView();
            }
        }
    }

    @FXML
    public void deleteWorker(ActionEvent event) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        dialog.setTitle("Usunięcie pracownika");
        dialog.setContentText("Czy na pewno chcesz zwolnić tego pracownika?");

        Optional<ButtonType> response = dialog.showAndWait();
        if (response.isPresent() && (response.get() == ButtonType.OK)) {
            Datasource.getInstance().deleteWorker(workersList.getSelectionModel().getSelectedItem().getId());
            refreshListView();
            addWorkerButton.setVisible(true);
            hBox.setVisible(false);
        }
    }

    @FXML
    public void loadDutyPage(ActionEvent event) {
        PageLoader pageLoader = new PageLoader("DutyWindow");
        BorderPane temp = pageLoader.load();
        this.borderPane.getScene().setRoot(temp);
    }

    private void refreshListView() {
        Task<ObservableList<Worker>> task = new GetWorkersByManager();
        workersList.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }
}

class GetWorkersByManager extends Task {
    @Override
    public ObservableList<Worker> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().getWorkersByManagers(DatabasePath.getInstance().getIdManager()));
    }
}