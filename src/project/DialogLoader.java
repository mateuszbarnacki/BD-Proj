package project;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

import java.io.IOException;

public class DialogLoader {
    private final String fileName;

    public DialogLoader(String fileName) {
        this.fileName = fileName;
    }

    public Dialog<ButtonType> load() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(this.fileName + ".fxml"));

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load " + this.fileName + " window: " + e.getMessage());
            e.printStackTrace();
        }

        return dialog;
    }
}
