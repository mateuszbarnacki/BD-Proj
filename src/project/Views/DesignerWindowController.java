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
import project.Datamodel.Designer;
import project.Utilities.DatabasePath;

import java.io.IOException;
import java.util.Optional;

public class DesignerWindowController {
    @FXML
    public BorderPane borderPane;
    @FXML
    public HBox hBox;
    @FXML
    public TableView<Designer> designersList;
    @FXML
    public Button addDesignerButton;

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
        if(!designersList.getSelectionModel().isEmpty()){
            addDesignerButton.setVisible(false);
            hBox.setVisible(true);
        }
    }

    @FXML
    public void addDesigner(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("DesignerDialog.fxml"));

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load designer dialog window: " + e.getMessage());
            e.printStackTrace();
        }

        Optional<ButtonType> result = dialog.showAndWait();

        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            DesignerDialogController controller = fxmlLoader.getController();
            if (controller.processResult(1, "wstaw")) {
                AlertLoader alertLoader = new AlertLoader(Alert.AlertType.INFORMATION, "Zaktualizowano listę rekordów", "Dodanie projektanta");
                alertLoader.load();
                refreshListView();
            }
        }
    }

    @FXML
    public void editDesigner(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("DesignerDialog.fxml"));

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load designer dialog window: " + e.getMessage());
            e.printStackTrace();
        }

        Optional<ButtonType> result = dialog.showAndWait();

        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            DesignerDialogController controller = fxmlLoader.getController();
            if (controller.processResult(designersList.getSelectionModel().getSelectedItem().getId(), "edytuj")) {
                AlertLoader alertLoader = new AlertLoader(Alert.AlertType.INFORMATION, "Zaktualizowano listę rekordów", "Edycja projektanta");
                alertLoader.load();
                refreshListView();
            }
        }
    }

    @FXML
    public void deleteDesigner(ActionEvent event) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        dialog.setTitle("Usunięcie projektanta");
        dialog.setContentText("Czy na pewno chcesz zwolnić tego projektanta?");

        Optional<ButtonType> response = dialog.showAndWait();
        if (response.isPresent() && (response.get() == ButtonType.OK)) {
            Datasource.getInstance().deleteDesigner(designersList.getSelectionModel().getSelectedItem().getId());
            refreshListView();
            addDesignerButton.setVisible(true);
            hBox.setVisible(false);
        }
    }

    @FXML
    public void loadPortfolioPage(ActionEvent event) {
        PageLoader pageLoader = new PageLoader("PortfolioWindow");
        BorderPane temp = pageLoader.load();
        this.borderPane.getScene().setRoot(temp);
    }

    private void refreshListView() {
        Task<ObservableList<Designer>> task = new GetDesignersByExposition();
        designersList.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }
}

class GetDesignersByExposition extends Task {
    @Override
    public ObservableList<Designer> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().getDesignersByExposition(DatabasePath.getInstance().getIdExposition()));
    }
}