package project.Views;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import project.Datamodel.Datasource;
import project.Datamodel.Portfolio;
import project.Views.AlertLoader;

import java.sql.Date;
import java.sql.SQLException;

public class PortfolioDialogController {
    @FXML
    public TextField name;
    @FXML
    public DatePicker date;

    public boolean processResult(int id, String type) {
        Date date = Date.valueOf(this.date.getValue());
        if(type.equals("wstaw")) {
            if (!name.getText().isBlank()) {
                Portfolio portfolio = new Portfolio(id, name.getText(), date);
                try {
                    return Datasource.getInstance().insertPortfolio(portfolio);
                } catch (SQLException e) {
                    AlertLoader alertLoader = new AlertLoader(Alert.AlertType.ERROR, "Dodanie portfolio", "Nie można dodać portfolio: " + e.getMessage());
                    alertLoader.load();
                    return false;
                }
            }
        } else if (type.equals("edytuj")) {
            if (!name.getText().isBlank()) {
                Portfolio portfolio = new Portfolio(id, name.getText(), date);
                try {
                   return Datasource.getInstance().updatePortfolio(portfolio);
                } catch (SQLException e) {
                    AlertLoader alertLoader = new AlertLoader(Alert.AlertType.ERROR, "Edycja portfolio", "Nie można edytować portfolio: " + e.getMessage());
                    alertLoader.load();
                    return false;
                }
            }
        }
        return false;
    }

}
