package project.Views;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import project.Datamodel.Datasource;
import project.Datamodel.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDialogController {
    @FXML
    public RadioButton kitchenButton;
    @FXML
    public RadioButton bathroomButton;
    @FXML
    public RadioButton bedroomButton;
    @FXML
    public RadioButton hallButton;
    @FXML
    public RadioButton childRoomButton;
    @FXML
    public RadioButton livingRoomButton;
    @FXML
    public Label kitchen;
    @FXML
    public Label bathroom;
    @FXML
    public Label bedroom;
    @FXML
    public Label hall;
    @FXML
    public Label childRoom;
    @FXML
    public Label livingRoom;
    @FXML
    public Label lackOfItemsLabel;

    public void initialize() {
        lackOfItemsLabel.setVisible(false);
        List<Department> departments = Datasource.getInstance().getDepartments();
        if(departments != null){
            for (Department department : departments) {
                if (department.getName().equals("Kuchnia")) {
                    kitchenButton.setVisible(false);
                    kitchen.setVisible(false);
                } else if (department.getName().equals("Łazienka")) {
                    bathroomButton.setVisible(false);
                    bathroom.setVisible(false);
                } else if (department.getName().equals("Sypialnia")) {
                    bedroomButton.setVisible(false);
                    bedroom.setVisible(false);
                } else if (department.getName().equals("Przedpokój")) {
                    hallButton.setVisible(false);
                    hall.setVisible(false);
                } else if (department.getName().equals("Pokój dziecięcy")) {
                    childRoomButton.setVisible(false);
                    childRoom.setVisible(false);
                } else if (department.getName().equals("Pokój dzienny")) {
                    livingRoomButton.setVisible(false);
                    livingRoom.setVisible(false);
                }
            }
        }
        if (!kitchen.isVisible() && !bathroom.isVisible() && !bedroom.isVisible() && !hall.isVisible() && !childRoom.isVisible() && !livingRoom.isVisible()){
            lackOfItemsLabel.setVisible(true);
        }
    }

    public boolean processResult() {
        boolean isSuccess = false;
        List<String> nameOfDepartments = new ArrayList<>();
        if (kitchenButton.isSelected()) {
            nameOfDepartments.add(kitchen.getText());
        }
        if (bathroomButton.isSelected()) {
            nameOfDepartments.add(bathroom.getText());
        }
        if (bedroomButton.isSelected()) {
            nameOfDepartments.add(bedroom.getText());
        }
        if (hallButton.isSelected()) {
            nameOfDepartments.add(hall.getText());
        }
        if (childRoomButton.isSelected()) {
            nameOfDepartments.add(childRoom.getText());
        }
        if (livingRoomButton.isSelected()) {
            nameOfDepartments.add(livingRoom.getText());
        }

        for(String element : nameOfDepartments) {
            isSuccess = Datasource.getInstance().insertDepartment(element);
        }

        return isSuccess;
    }
}
