package project;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class ReportCreator {
    private final String type;

    public ReportCreator(String type) {
        this.type = type;
    }

    public void load(BorderPane pane) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("AppTopMenu.fxml"));
        BorderPane temp = new BorderPane();

        try {
            temp.setTop(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load app top menu: " + e.getMessage());
            e.printStackTrace();
        }

        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Report.fxml"));

        try {
            temp.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load report: " + e.getMessage());
            e.printStackTrace();
        }
        ReportController controller = fxmlLoader.getController();
        pane.getScene().setRoot(temp);
        controller.setReport(this.type);
    }
}
