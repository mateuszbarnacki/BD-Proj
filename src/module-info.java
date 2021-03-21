module BD.Proj {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;

    opens project.Utilities;
    opens project.Datamodel;
    opens project.Views;
    opens project;
}