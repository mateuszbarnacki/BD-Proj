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
import project.Datamodel.Exposition;

import java.io.IOException;
import java.util.Optional;

public class ExpositionWindowController {
    @FXML
    public BorderPane borderPane;
    @FXML
    public HBox hBox;
    @FXML
    public TableView<Exposition> expositionsList;
    @FXML
    public Button addExpositionButton;

    public void initialize() {
        hBox.setVisible(false);
        refreshListView();
    }

    @FXML
    public void displayPreviousPage(MouseEvent event) {
        PageLoader pageLoader = new PageLoader("DepartmentWindow");
        BorderPane temp = pageLoader.load();
        this.borderPane.getScene().setRoot(temp);
    }

    @FXML
    public void showOptions(MouseEvent event) {
        if(!expositionsList.getSelectionModel().isEmpty()){
            addExpositionButton.setVisible(false);
            hBox.setVisible(true);
        }
    }

    @FXML
    public void addExposition(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("ExpositionDialog.fxml"));

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load exposition dialog window: " + e.getMessage());
            e.printStackTrace();
        }

        Optional<ButtonType> result = dialog.showAndWait();

        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            ExpositionDialogController controller = fxmlLoader.getController();
            if (controller.processResult(1, "wstaw", 0.0)) {
                AlertLoader alertLoader = new AlertLoader(Alert.AlertType.INFORMATION, "Zaktualizowano listę rekordów", "Dodanie ekspozycji");
                alertLoader.load();
                refreshListView();
            }
        }
    }

    public void editExpositionPrice(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("ExpositionDialog.fxml"));

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
            ExpositionDialogController controller = fxmlLoader.getController();
            if (controller.processResult(expositionsList.getSelectionModel().getSelectedItem().getId(), "edytuj", 0.0)) {
                AlertLoader alertLoader = new AlertLoader(Alert.AlertType.INFORMATION, "Zaktualizowano listę rekordów", "Edycja kierownika");
                alertLoader.load();
                refreshListView();
            }
        }
    }

    @FXML
    public void deleteExposition(ActionEvent event) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        dialog.setTitle("Usunięcie ekspozycji");
        dialog.setContentText("Czy na pewno chcesz usunąć tą ekspozycję?");

        Optional<ButtonType> response = dialog.showAndWait();
        if (response.isPresent() && (response.get() == ButtonType.OK)) {
            Datasource.getInstance().deleteExposition(expositionsList.getSelectionModel().getSelectedItem().getId());
            refreshListView();
            addExpositionButton.setVisible(true);
            hBox.setVisible(false);
        }
    }

    @FXML
    public void loadCommodityPage(ActionEvent event) {
        PageLoader pageLoader = new PageLoader("CommodityWindow");
        BorderPane temp = pageLoader.load();
        DatabasePath.getInstance().setIdExposition(expositionsList.getSelectionModel().getSelectedItem().getId());
        this.borderPane.getScene().setRoot(temp);
    }

    @FXML
    public void loadDesignerPage(ActionEvent event) {
        PageLoader pageLoader = new PageLoader("DesignerWindow");
        BorderPane temp = pageLoader.load();
        DatabasePath.getInstance().setIdExposition(expositionsList.getSelectionModel().getSelectedItem().getId());
        this.borderPane.getScene().setRoot(temp);
    }

    private void refreshListView() {
        Task<ObservableList<Exposition>> task = new GetListOfExpositions();
        expositionsList.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }
}

class GetListOfExpositions extends Task {
    @Override
    public ObservableList<Exposition> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().getExpositions());
    }
}