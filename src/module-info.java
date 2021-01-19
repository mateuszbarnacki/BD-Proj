module BD.Proj {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;

    opens project.Datamodel;
    opens project;
}