package project;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class RegisterPageLoader {
    private final String fileName;

    public RegisterPageLoader(String fileName) {
        this.fileName = fileName;
    }

    public BorderPane load() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(this.fileName + ".fxml"));
        BorderPane temp = new BorderPane();

        try {
            temp.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load " + this.fileName + " window: " + e.getMessage());
            e.printStackTrace();
        }

        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("RootWindow.fxml"));

        try {
            temp.setTop(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load app top menu: " + e.getMessage());
            e.printStackTrace();
        }

        return temp;
    }
}
