package project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import project.Datamodel.Account;
import project.Datamodel.Datasource;

public class LoginForm {
    @FXML
    public ListView<Account> accountsList;
    @FXML
    public HBox hBox;

    public void initialize(){
        Task<ObservableList<Account>> task = new GetAccounts();
        accountsList.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }

    @FXML
    public void showOptions(Event event){
        if(!accountsList.getSelectionModel().isEmpty()){
            hBox.setVisible(true);
        }
    }
}

class GetAccounts extends Task {
    @Override
    public ObservableList<Account> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().getAccounts());
    }
}
