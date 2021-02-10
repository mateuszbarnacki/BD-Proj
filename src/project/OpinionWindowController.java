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
import project.Datamodel.Opinion;

import java.io.IOException;
import java.util.Optional;

public class OpinionWindowController {
    @FXML
    public BorderPane borderPane;
    @FXML
    public ListView<Opinion> opinionsList;
    @FXML
    public Button addOpinionButton;
    @FXML
    public Button deleteOpinionButton;

    public void initialize() {
        deleteOpinionButton.setVisible(false);
        refreshListView();
    }

    @FXML
    public void displayPreviousPage(MouseEvent event) {
        PageLoader pageLoader = new PageLoader("CommodityWindow");
        BorderPane temp = pageLoader.load();
        this.borderPane.getScene().setRoot(temp);
    }

    @FXML
    public void showOptions(MouseEvent event) {
        if(!opinionsList.getSelectionModel().isEmpty()){
            addOpinionButton.setVisible(false);
            deleteOpinionButton.setVisible(true);
        }
    }

    @FXML
    public void addOpinion(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("OpinionDialog.fxml"));

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load opinion dialog window: " + e.getMessage());
            e.printStackTrace();
        }

        Optional<ButtonType> result = dialog.showAndWait();

        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            OpinionDialogController controller = fxmlLoader.getController();
            if (controller.processResult()) {
                AlertLoader alertLoader = new AlertLoader(Alert.AlertType.INFORMATION, "Zaktualizowano listę rekordów", "Dodanie opini");
                alertLoader.load();
                refreshListView();
            }
        }
    }

    @FXML
    public void deleteOpinion(ActionEvent event) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        dialog.setTitle("Usunięcie opini");
        dialog.setContentText("Czy na pewno chcesz usunąć opinię?");

        Optional<ButtonType> response = dialog.showAndWait();
        if (response.isPresent() && (response.get() == ButtonType.OK)) {
            Datasource.getInstance().deleteOpinion(opinionsList.getSelectionModel().getSelectedItem().getId());
            refreshListView();
            addOpinionButton.setVisible(true);
            deleteOpinionButton.setVisible(false);
        }
    }

    private void refreshListView() {
        Task<ObservableList<Opinion>> task = new GetOpinionsByCommodity();
        opinionsList.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }
}

class GetOpinionsByCommodity extends Task {
    @Override
    public ObservableList<Opinion> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().getOpinionsByCommodity(DatabasePath.getInstance().getIdCommodity()));
    }
}