package project.Views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import project.Datamodel.*;

public class ReportController {
    @FXML
    public ListView itemsList;
    @FXML
    public BorderPane borderPane;
    @FXML
    public HBox hBox;
    @FXML
    public Label countLabel;

    public void initialize() {
        hBox.setVisible(false);
    }

    @FXML
    public void displayPreviousPage(MouseEvent event) {
        PageLoader loader = new PageLoader("WarehouseWindow");
        BorderPane temp = loader.load();
        this.borderPane.getScene().setRoot(temp);
    }

    public void setReport(String type) {
        if (type.equals("department")) {
            Task<ObservableList<Department>> task = new GetListOfDepartments();
            itemsList.itemsProperty().bind(task.valueProperty());
            new Thread(task).start();
            countLabel.setText(Integer.toString(Datasource.getInstance().getNumberOfRows(Datasource.TABLE_DEPARTMENT)));
            hBox.setVisible(true);
        } else if (type.equals("manager")) {
            Task<ObservableList<Manager>> task = new GetListOfManagers();
            itemsList.itemsProperty().bind(task.valueProperty());
            new Thread(task).start();
            countLabel.setText(Integer.toString(Datasource.getInstance().getNumberOfRows(Datasource.TABLE_MANAGER)));
            hBox.setVisible(true);
        } else if (type.equals("worker")) {
            Task<ObservableList<Worker>> task = new GetListOfWorkers();
            itemsList.itemsProperty().bind(task.valueProperty());
            new Thread(task).start();
            countLabel.setText(Integer.toString(Datasource.getInstance().getNumberOfRows(Datasource.TABLE_WORKER)));
            hBox.setVisible(true);
        } else if (type.equals("designer")) {
            Task<ObservableList<Designer>> task = new GetListOfDesigners();
            itemsList.itemsProperty().bind(task.valueProperty());
            new Thread(task).start();
            countLabel.setText(Integer.toString(Datasource.getInstance().getNumberOfRows(Datasource.TABLE_DESIGNER)));
            hBox.setVisible(true);
        } else if (type.equals("duty")) {
            Task<ObservableList<Duty>> task = new GetListOfDuties();
            itemsList.itemsProperty().bind(task.valueProperty());
            new Thread(task).start();
            countLabel.setText(Integer.toString(Datasource.getInstance().getNumberOfRows(Datasource.TABLE_DUTIES)));
            hBox.setVisible(true);
        } else if (type.equals("vacation")) {
            Task<ObservableList<Vacation>> task = new GetListOfVacations();
            itemsList.itemsProperty().bind(task.valueProperty());
            new Thread(task).start();
            countLabel.setText(Integer.toString(Datasource.getInstance().getNumberOfRows(Datasource.TABLE_VACATION)));
            hBox.setVisible(true);
        } else if (type.equals("exposition")) {
            Task<ObservableList<Exposition>> task = new GetListOfExpositions();
            itemsList.itemsProperty().bind(task.valueProperty());
            new Thread(task).start();
            countLabel.setText(Integer.toString(Datasource.getInstance().getNumberOfRows(Datasource.TABLE_EXPOSITION)));
            hBox.setVisible(true);
        } else if (type.equals("commodity")) {
            Task<ObservableList<Commodity>> task = new GetListOfCommodities();
            itemsList.itemsProperty().bind(task.valueProperty());
            new Thread(task).start();
            countLabel.setText(Integer.toString(Datasource.getInstance().getNumberOfRows(Datasource.TABLE_COMMODITY)));
            hBox.setVisible(true);
        } else if (type.equals("opinion")) {
            Task<ObservableList<Opinion>> task = new GetListOfOpinions();
            itemsList.itemsProperty().bind(task.valueProperty());
            new Thread(task).start();
            countLabel.setText(Integer.toString(Datasource.getInstance().getNumberOfRows(Datasource.TABLE_OPINION)));
            hBox.setVisible(true);
        } else if (type.equals("portfolio")) {
            Task<ObservableList<Portfolio>> task = new GetListOfPortfolios();
            itemsList.itemsProperty().bind(task.valueProperty());
            new Thread(task).start();
            countLabel.setText(Integer.toString(Datasource.getInstance().getNumberOfRows(Datasource.TABLE_PORTFOLIO)));
            hBox.setVisible(true);
        }
    }
}

class GetListOfCommodities extends Task {
    @Override
    public ObservableList<Commodity> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().getCommodities());
    }
}

class GetListOfDesigners extends Task {
    @Override
    public ObservableList<Designer> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().getDesigners());
    }
}

class GetListOfDuties extends Task {
    @Override
    public ObservableList<Duty> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().getDuties());
    }
}

class GetListOfExpositions extends Task {
    @Override
    public ObservableList<Exposition> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().getExpositions());
    }
}

class GetListOfManagers extends Task {
    @Override
    public ObservableList<Manager> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().getManagers());
    }
}

class GetListOfOpinions extends Task {
    @Override
    public ObservableList<Opinion> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().getOpinions());
    }
}

class GetListOfVacations extends Task {
    @Override
    public ObservableList<Vacation> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().getVacations());
    }
}

class GetListOfWorkers extends Task {
    @Override
    public ObservableList<Worker> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().getWorkers());
    }
}

class GetListOfPortfolios extends Task {
    @Override
    public ObservableList<Portfolio> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().getPortfolios());
    }
}