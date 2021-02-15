package project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import project.Datamodel.Datasource;
import project.Datamodel.Reference;

public class ReferenceWindowController {
    @FXML
    public BorderPane borderPane;
    @FXML
    public TableView<Reference> referencesTable;

    public void initialize() {
        Task<ObservableList<Reference>> task = new GetReferences();
        this.referencesTable.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }

    @FXML
    public void displayPreviousPage(MouseEvent event) {
        PageLoader pageLoader = new PageLoader("StuffSection");
        BorderPane temp = pageLoader.load();
        this.borderPane.getScene().setRoot(temp);
    }

}

class GetReferences extends Task {
    @Override
    public ObservableList<Reference> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().getReferences());
    }
}