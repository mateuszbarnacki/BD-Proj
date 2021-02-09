package project;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import project.Datamodel.*;

public class ReportController {
    @FXML
    public ListView itemsList;

    public void setReport(String type) {
        if (type.equals("department")) {
            Task<ObservableList<Department>> task = new GetListOfDepartments();
            itemsList.itemsProperty().bind(task.valueProperty());
            new Thread(task).start();
        } else if (type.equals("manager")) {
            Task<ObservableList<Manager>> task = new GetListOfManagers();
            itemsList.itemsProperty().bind(task.valueProperty());
            new Thread(task).start();
        } else if (type.equals("worker")) {
            Task<ObservableList<Worker>> task = new GetListOfWorkers();
            itemsList.itemsProperty().bind(task.valueProperty());
            new Thread(task).start();
        } else if (type.equals("designer")) {
            Task<ObservableList<Designer>> task = new GetListOfDesigners();
            itemsList.itemsProperty().bind(task.valueProperty());
            new Thread(task).start();
        } else if (type.equals("duty")) {
            Task<ObservableList<Duty>> task = new GetListOfDuties();
            itemsList.itemsProperty().bind(task.valueProperty());
            new Thread(task).start();
        } else if (type.equals("vacation")) {
            Task<ObservableList<Vacation>> task = new GetListOfVacations();
            itemsList.itemsProperty().bind(task.valueProperty());
            new Thread(task).start();
        } else if (type.equals("exposition")) {
            Task<ObservableList<Exposition>> task = new GetListOfExpositions();
            itemsList.itemsProperty().bind(task.valueProperty());
            new Thread(task).start();
        } else if (type.equals("commodity")) {
            Task<ObservableList<Commodity>> task = new GetListOfCommodities();
            itemsList.itemsProperty().bind(task.valueProperty());
            new Thread(task).start();
        } else if (type.equals("opinion")) {
            Task<ObservableList<Opinion>> task = new GetListOfOpinions();
            itemsList.itemsProperty().bind(task.valueProperty());
            new Thread(task).start();
        }
    }
}
