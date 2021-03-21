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
import project.Datamodel.Datasource;
import project.Datamodel.Vacation;
import project.Utilities.DatabasePath;

import java.io.IOException;
import java.util.Optional;

public class VacationWindowController {
    @FXML
    public BorderPane borderPane;
    @FXML
    public TableView<Vacation> vacationsList;
    @FXML
    public Button addVacationButton;
    @FXML
    public Button deleteVacationButton;

    public void initialize() {
        deleteVacationButton.setVisible(false);
        refreshListView();
    }

    @FXML
    public void displayPreviousPage(MouseEvent event) {
        PageLoader pageLoader = new PageLoader("SecondWorkerWindow");
        BorderPane temp = pageLoader.load();
        this.borderPane.getScene().setRoot(temp);
    }

    @FXML
    public void showOptions(MouseEvent event) {
        if(!vacationsList.getSelectionModel().isEmpty()){
            addVacationButton.setVisible(false);
            deleteVacationButton.setVisible(true);
        }
    }

    @FXML
    public void addVacation(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("VacationDialog.fxml"));

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load vacation dialog window: " + e.getMessage());
            e.printStackTrace();
        }

        Optional<ButtonType> result = dialog.showAndWait();

        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            VacationDialogController controller = fxmlLoader.getController();
            if (controller.processResult()) {
                AlertLoader alertLoader = new AlertLoader(Alert.AlertType.INFORMATION, "Zaktualizowano listę rekordów", "Dodano urlop");
                alertLoader.load();
                refreshListView();
            }
        }
    }

    @FXML
    public void deleteVacation(ActionEvent event) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        dialog.setTitle("Usunięcie urlopu");
        dialog.setContentText("Czy na pewno chcesz usunąć ten urlop?");

        Optional<ButtonType> response = dialog.showAndWait();
        if (response.isPresent() && (response.get() == ButtonType.OK)) {
            Datasource.getInstance().deleteVacation(vacationsList.getSelectionModel().getSelectedItem().getId());
            refreshListView();
            addVacationButton.setVisible(true);
            deleteVacationButton.setVisible(false);
        }
    }

    private void refreshListView() {
        Task<ObservableList<Vacation>> task = new GetVacationsByWorker();
        vacationsList.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }
}

class GetVacationsByWorker extends Task {
    @Override
    public ObservableList<Vacation> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().getVacationsByWorker(DatabasePath.getInstance().getIdWorker()));
    }
}
