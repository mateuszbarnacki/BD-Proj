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
import project.Datamodel.Portfolio;

import java.io.IOException;
import java.util.Optional;

public class PortfolioWindowController {
    @FXML
    public BorderPane borderPane;
    @FXML
    public TableView<Portfolio> portfolioTable;
    @FXML
    public Button addButton;
    @FXML
    public HBox hBox;

    public void initialize() {
        addButton.setVisible(true);
        hBox.setVisible(false);
        refreshTableView();
    }

    @FXML
    public void displayPreviousPage(MouseEvent event) {
        PageLoader pageLoader = new PageLoader("DesignerWindow");
        BorderPane temp = pageLoader.load();
        this.borderPane.getScene().setRoot(temp);
    }

    @FXML
    public void addPortfolio(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("PortfolioDialog"));
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load portfolio dialog: " + e.getMessage());
            e.printStackTrace();
        }

        Optional<ButtonType> response = dialog.showAndWait();

        if (response.isPresent() && (response.get() == ButtonType.OK)) {
            PortfolioDialogController controller = fxmlLoader.getController();
            if (controller.processResult(1, "wstaw")) {
                AlertLoader loader = new AlertLoader(Alert.AlertType.INFORMATION, "Dodanie portfolio", "Sukcesywnie dodano portfolio");
                loader.load();
                refreshTableView();
            }
        }

    }

    @FXML
    public void editPortfolio(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("PortfolioDialog"));
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load portfolio dialog: " + e.getMessage());
            e.printStackTrace();
        }

        Optional<ButtonType> response = dialog.showAndWait();

        if (response.isPresent() && (response.get() == ButtonType.OK)) {
            PortfolioDialogController controller = fxmlLoader.getController();
            if (controller.processResult(portfolioTable.getSelectionModel().getSelectedItem().getId(), "edytuj")) {
                AlertLoader alertLoader = new AlertLoader(Alert.AlertType.INFORMATION, "Edycja portfolio", "Sukcesywnie edytowano rekord");
                alertLoader.load();
                refreshTableView();
            }
        }
    }

    @FXML
    public void deletePortfolio(ActionEvent event) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().setContentText("Czy na pewno chcesz usunąć ten projekt z porfolio?");
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> response = dialog.showAndWait();
        if (response.isPresent() && (response.get() == ButtonType.OK)) {
            Datasource.getInstance().deletePortfolio(portfolioTable.getSelectionModel().getSelectedItem().getId());
            AlertLoader alertLoader = new AlertLoader(Alert.AlertType.INFORMATION, "Usunięcie projektu", "Sukcesywnie usunięto projekt");
            alertLoader.load();
            refreshTableView();
            addButton.setVisible(true);
            hBox.setVisible(false);
        }
    }

    private void refreshTableView() {
        Task<ObservableList<Portfolio>> task = new GetPortfoliosByDesigner();
        portfolioTable.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }

}

class GetPortfoliosByDesigner extends Task {
    @Override
    public ObservableList<Portfolio> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().getPortfoliosByDesigner(DatabasePath.getInstance().getIdDesigner()));
    }
}
