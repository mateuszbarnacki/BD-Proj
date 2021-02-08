package project;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class AlertLoader {
    private final Alert.AlertType type;
    private final String title;
    private final String content;

    public AlertLoader(Alert.AlertType type, String title, String content) {
        this.type = type;
        this.title = title;
        this.content = content;
    }

    public void load(){
        Alert alert = new Alert(this.type);
        alert.setTitle(this.title);
        alert.setHeaderText(null);
        alert.setContentText(this.content);
        Optional<ButtonType> response = alert.showAndWait();
        if (response.isPresent()) {
            alert.close();
        }
    }
}
