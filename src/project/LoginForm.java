package project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import project.Datamodel.Account;
import project.Datamodel.Datasource;

import java.io.IOException;
import java.util.Optional;

public class LoginForm {
    @FXML
    public ListView<Account> accountsList;
    @FXML
    public HBox hBox;
    @FXML
    public BorderPane borderPane;

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

    @FXML
    public void login(ActionEvent event){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("LoginDialog.fxml"));

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Logowanie");
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e){
            System.out.println("Couldn't load login dialog: " + e.getMessage());
            e.printStackTrace();
        }

        Optional<ButtonType> response = dialog.showAndWait();
        if((response.isPresent()) && (response.get() == ButtonType.OK)){
            LoginDialog controller = fxmlLoader.getController();
            if(controller.validateFields()){
                String user = accountsList.getSelectionModel().getSelectedItem().getUsername();
                if(controller.login(user)){
                    dialog.close();
                    fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("Magazine.fxml"));
                    try{
                        borderPane.setCenter(fxmlLoader.load());
                    } catch(IOException e){
                        System.out.println("Couldn't load magazine page: " + e.getMessage());
                        e.printStackTrace();
                    }
                } else {
                    alertCreator(Alert.AlertType.ERROR, "Błąd logowania", "Błędne dane logowania!");
                }
            } else {
                alertCreator(Alert.AlertType.ERROR, "Błąd logowania", "W formularzu są puste pola!");
            }
        }
    }

    @FXML
    public void editAccount(ActionEvent event){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("EditDialog.fxml"));

        Dialog<ButtonType> dialog = new Dialog<ButtonType>();
        dialog.setTitle("Edycja konta");
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e){
            System.out.println("Couldn't load edit dialog: " + e.getMessage());
            e.printStackTrace();
        }

        Optional<ButtonType> response = dialog.showAndWait();
        if(response.isPresent() && (response.get() == ButtonType.OK)){
            EditDialog controller = fxmlLoader.getController();
            if(controller.validateFields()){
                String username = accountsList.getSelectionModel().getSelectedItem().getUsername();
                if(controller.update(username)){
                    alertCreator(Alert.AlertType.INFORMATION, "Edycja konta", "Edycja konta zakończona sukcesem");
                } else {
                    alertCreator(Alert.AlertType.ERROR, "Edycja konta", "Błąd w trakcie edycji konta!");
                }
            } else if (controller.blankFields()){
                alertCreator(Alert.AlertType.ERROR, "Edycja konta", "W formularzu są puste pola!");
            } else {
                alertCreator(Alert.AlertType.ERROR, "Edycja konta", "Niezgodne hasła!");
            }
        }
    }

    @FXML
    public void deleteAccount(ActionEvent event){
        DialogPane dialogPane = new DialogPane();
        dialogPane.setHeaderText(null);
        dialogPane.setContentText("Czy na pewno chcesz usunąć konto?");
        dialogPane.getButtonTypes().add(ButtonType.OK);
        dialogPane.getButtonTypes().add(ButtonType.CLOSE);
        Dialog<ButtonType> dialog = new Dialog<ButtonType>();
        dialog.setTitle("Usunięcie konta");
        dialog.setDialogPane(dialogPane);

        Optional<ButtonType> result = dialog.showAndWait();

        if(result.isPresent() && (result.get() == ButtonType.OK)){
            if(Datasource.getInstance().deleteAccount(accountsList.getSelectionModel().getSelectedItem().getUsername())){
                alertCreator(Alert.AlertType.INFORMATION, "Usunięcie konta", "Konto zostało sukcesywnie usunięte");
                Task<ObservableList<Account>> task = new GetAccounts();
                accountsList.itemsProperty().bind(task.valueProperty());
                new Thread(task).start();
            } else {
                alertCreator(Alert.AlertType.ERROR, "Usunięcie konta", "Błąd podczas usuwania konta!");
            }
        }
    }

    private void alertCreator(Alert.AlertType type, String title, String content){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);

        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent()){
            alert.close();
        }
    }
}

class GetAccounts extends Task {
    @Override
    public ObservableList<Account> call() throws Exception {
        return FXCollections.observableArrayList(Datasource.getInstance().getAccounts());
    }
}
