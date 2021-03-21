package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.Datamodel.Datasource;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Views/RootWindow.fxml"));
        primaryStage.setTitle("Symulator hurtowni mebli");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 500, 720));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        Datasource.getInstance().open();
    }

    @Override
    public void stop() throws Exception{
        super.stop();
        Datasource.getInstance().close();
    }
}
