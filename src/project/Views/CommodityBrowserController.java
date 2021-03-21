package project.Views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import project.Datamodel.Commodity;
import project.Datamodel.Datasource;
import project.Datamodel.Department;

public class CommodityBrowserController {
    @FXML
    public BorderPane borderPane;
    @FXML
    public ComboBox<Department> departmentsList;
    @FXML
    public RadioButton minButton;
    @FXML
    public RadioButton maxButton;
    @FXML
    public RadioButton otherButton;
    @FXML
    public TextField minValue;
    @FXML
    public TextField maxValue;
    @FXML
    public TableView<Commodity> resultTable;
    @FXML
    public HBox hBox;

    public void initialize() {
        hBox.setVisible(false);
        Task<ObservableList<Department>> task = new GetListOfDepartments();
        departmentsList.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }

    @FXML
    public void displayPreviousPage(MouseEvent event) {
        PageLoader loader = new PageLoader("WarehouseWindow");
        BorderPane temp = loader.load();
        this.borderPane.getScene().setRoot(temp);
    }

    @FXML
    public void showHBox(ActionEvent event) {
        if (!otherButton.isSelected()) {
            hBox.setVisible(false);
        } else {
            hBox.setVisible(true);
        }
    }

    @FXML
    public void processResult(ActionEvent event) {
        if (departmentsList.getSelectionModel().isEmpty()) {
            AlertLoader alert = new AlertLoader(Alert.AlertType.ERROR, "Błąd wyszukiwania", "Brak zaznaczonego działu!");
            alert.load();
        } else {
            if (minButton.isSelected()) {
                Task<ObservableList<Commodity>> task = new FindTheCheapestCommodity(departmentsList.getSelectionModel().getSelectedItem().getId());
                resultTable.itemsProperty().bind(task.valueProperty());
                new Thread(task).start();
            } else if (maxButton.isSelected()) {
                Task<ObservableList<Commodity>> task = new FindTheMostExpensiveCommodity(departmentsList.getSelectionModel().getSelectedItem().getId());
                resultTable.itemsProperty().bind(task.valueProperty());
                new Thread(task).start();
            } else if (otherButton.isSelected()) {
                if (minValue.getText().matches("^\\d+\\.?\\d*$") && maxValue.getText().matches("^\\d+\\.?\\d*$")) {
                    double min = Double.parseDouble(minValue.getText());
                    double max = Double.parseDouble(maxValue.getText());
                    if (min <= max) {
                        Task<ObservableList<Commodity>> task = new GetSpecialCommodities(departmentsList.getSelectionModel().getSelectedItem().getId(), min, max);
                        resultTable.itemsProperty().bind(task.valueProperty());
                        new Thread(task).start();
                    } else {
                        AlertLoader alert = new AlertLoader(Alert.AlertType.ERROR, "Błąd wyszukiwania", "Błędny zakres wartości!");
                        alert.load();
                    }
                } else {
                    AlertLoader alert = new AlertLoader(Alert.AlertType.ERROR, "Błąd wyszukiwania", "Błędna wartość zakresu: nie wprowadzono liczby!");
                    alert.load();
                }
            } else {
                AlertLoader alert = new AlertLoader(Alert.AlertType.ERROR, "Błąd wyszukiwania", "Nieokreślone krytetia wyszukiwania!");
                alert.load();
            }
        }
    }

}

class FindTheCheapestCommodity extends Task {
    private final int departmentIdx;

    @Override
    public ObservableList<Commodity> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().findTheCheapestCommodity(this.departmentIdx));
    }

    public FindTheCheapestCommodity(int id) {
        this.departmentIdx = id;
    }
}

class FindTheMostExpensiveCommodity extends Task {
    private final int departmentIdx;

    @Override
    public ObservableList<Commodity> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().findTheMostExpensiveCommodity(this.departmentIdx));
    }

    public FindTheMostExpensiveCommodity(int id) {
        this.departmentIdx = id;
    }
}

class GetSpecialCommodities extends Task {
    private final int departmentIdx;
    private final double minPrice;
    private final double maxPrice;

    @Override
    public ObservableList<Commodity> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().getSpecialCommodities(departmentIdx, minPrice, maxPrice));
    }

    public GetSpecialCommodities(int id, double min, double max) {
        this.departmentIdx = id;
        this.minPrice = min;
        this.maxPrice = max;
    }
}