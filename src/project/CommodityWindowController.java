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
import project.Datamodel.Commodity;
import project.Datamodel.Datasource;
import project.Datamodel.Exposition;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class CommodityWindowController {
    @FXML
    public BorderPane borderPane;
    @FXML
    public HBox hBox;
    @FXML
    public TableView<Commodity> commoditiesList;
    @FXML
    public Button addCommodityButton;

    public void initialize() {
        hBox.setVisible(false);
        refreshListView();
    }

    @FXML
    public void displayPreviousPage(MouseEvent event) {
        PageLoader pageLoader = new PageLoader("ExpositionWindow");
        BorderPane temp = pageLoader.load();
        this.borderPane.getScene().setRoot(temp);
    }

    @FXML
    public void showOptions(MouseEvent event) {
        if(!commoditiesList.getSelectionModel().isEmpty()){
            addCommodityButton.setVisible(false);
            hBox.setVisible(true);
            DatabasePath.getInstance().setIdCommodity(commoditiesList.getSelectionModel().getSelectedItem().getId());
        }
    }

    @FXML
    public void addCommodity(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("CommodityDialog.fxml"));

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load commodity dialog window: " + e.getMessage());
            e.printStackTrace();
        }

        Optional<ButtonType> result = dialog.showAndWait();

        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            CommodityDialogController controller = fxmlLoader.getController();
            if (controller.processResult(1, "wstaw")) {
                AlertLoader alertLoader = new AlertLoader(Alert.AlertType.INFORMATION, "Zaktualizowano listę rekordów", "Dodanie towaru");
                alertLoader.load();
                refreshListView();
                updateExposition();
            }
        }
    }

    @FXML
    public void editCommodity(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("CommodityDialog.fxml"));

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load commodity dialog window: " + e.getMessage());
            e.printStackTrace();
        }

        Optional<ButtonType> result = dialog.showAndWait();

        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            CommodityDialogController controller = fxmlLoader.getController();
            if (controller.processResult(commoditiesList.getSelectionModel().getSelectedItem().getId(), "edytuj")) {
                AlertLoader alertLoader = new AlertLoader(Alert.AlertType.INFORMATION, "Zaktualizowano listę rekordów", "Edycja towaru");
                alertLoader.load();
                refreshListView();
                updateExposition();
            }
        }
    }

    @FXML
    public void deleteCommodity(ActionEvent event) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        dialog.setTitle("Usunięcie towaru");
        dialog.setContentText("Czy na pewno chcesz usunąć ten towar?");

        Optional<ButtonType> response = dialog.showAndWait();
        if (response.isPresent() && (response.get() == ButtonType.OK)) {
            Datasource.getInstance().deleteCommodity(commoditiesList.getSelectionModel().getSelectedItem().getId());
            refreshListView();
            addCommodityButton.setVisible(true);
            hBox.setVisible(false);
            updateExposition();
        }
    }

    @FXML
    public void loadOpinionPage(ActionEvent event) {
        PageLoader pageLoader = new PageLoader("OpinionWindow");
        BorderPane temp = pageLoader.load();
        this.borderPane.getScene().setRoot(temp);
    }

    private void updateExposition() {
        int idExposition = DatabasePath.getInstance().getIdExposition();
        double newPrice = Datasource.getInstance().calculateSumOfCommodities(idExposition);
        Exposition exposition = Datasource.getInstance().getExposition(idExposition);
        Exposition newExposition = new Exposition(exposition.getId(), exposition.getName(), newPrice);
        try {
            Datasource.getInstance().updateExposition(newExposition);
        } catch (SQLException e) {
            System.out.println("Couldn't update exposition: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void refreshListView() {
        Task<ObservableList<Commodity>> task = new GetListOfCommoditiesByExposition();
        commoditiesList.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }
}

class GetListOfCommoditiesByExposition extends Task {
    @Override
    public ObservableList<Commodity> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().getCommoditiesByExposition(DatabasePath.getInstance().getIdExposition()));
    }
}
