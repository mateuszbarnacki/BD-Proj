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
import project.Datamodel.Datasource;
import project.Datamodel.Duty;

import java.io.IOException;
import java.util.Optional;

public class DutyWindowController {
    @FXML
    public BorderPane borderPane;
    @FXML
    public ListView<Duty> dutiesList;
    @FXML
    public Button addDutyButton;
    @FXML
    public Button deleteDutyButton;

    public void initialize() {
        deleteDutyButton.setVisible(false);
        refreshListView();
    }

    @FXML
    public void displayPreviousPage(MouseEvent event) {
        PageLoader pageLoader = new PageLoader("WorkerWindow");
        BorderPane temp = pageLoader.load();
        this.borderPane.getScene().setRoot(temp);
    }

    @FXML
    public void showOptions(MouseEvent event) {
        if(!dutiesList.getSelectionModel().isEmpty()){
            addDutyButton.setVisible(false);
            deleteDutyButton.setVisible(true);
        }
    }

    @FXML
    public void addDuty(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("DutyDialog.fxml"));

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
            DutyDialogController controller = fxmlLoader.getController();
            if (controller.processResult()) {
                AlertLoader alertLoader = new AlertLoader(Alert.AlertType.INFORMATION, "Zaktualizowano listę rekordów", "Dodanie obowiązku");
                alertLoader.load();
                refreshListView();
            }
        }
    }

    @FXML
    public void deleteDuty(ActionEvent event) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        dialog.setTitle("Usunięcie obowiązku");
        dialog.setContentText("Czy na pewno chcesz odebrać pracownikowi ten obowiązek?");

        Optional<ButtonType> response = dialog.showAndWait();
        if (response.isPresent() && (response.get() == ButtonType.OK)) {
            Datasource.getInstance().deleteDuty(dutiesList.getSelectionModel().getSelectedItem().getId());
            refreshListView();
            addDutyButton.setVisible(true);
            deleteDutyButton.setVisible(false);
        }
    }

    private void refreshListView() {
        Task<ObservableList<Duty>> task = new GetListOfDuties();
        dutiesList.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }
}

class GetListOfDuties extends Task {
    @Override
    public ObservableList<Duty> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().getDuties());
    }
}