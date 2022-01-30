package projektpo.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import projektpo.java.Position;
import projektpo.models.LibraryDB;

import java.net.URL;
import java.util.ResourceBundle;

public class AddEmployeeController implements Initializable {
    @FXML private VBox sceneVBox;

    @FXML private TextField nameTF;

    @FXML private TextField lastNameTF;

    @FXML private ChoiceBox<Position> positionSelect;

    @FXML private TextField salaryTF;

    @FXML private Button addEmployeeBtn;

    @FXML private Button cancelBtn;

    @FXML private Label infoLabel;

    private LibraryDB libraryDB;

    public AddEmployeeController(){}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        positionSelect.getItems().setAll(Position.values());
        libraryDB = LibraryDB.getInstance();
    }

    @FXML private void addEmployee() {
        String name = nameTF.getText();
        String lastName = lastNameTF.getText();
        Position position = positionSelect.getValue();
        int salary;
        try {
            salary = Integer.parseInt(salaryTF.getText());
        } catch (NumberFormatException e) {
            infoLabel.setText("Wynagrodzenie musi być liczbą!");
            return;
        } catch (NullPointerException e){
            infoLabel.setText("Należy wybrać stanowisko!");
            return;
        } catch (Exception e) {
            infoLabel.setText("Nie udało się dodać pracownika.");
            return;
        }

        Stage stage = (Stage) sceneVBox.getScene().getWindow();
        libraryDB.addEmployee(name, lastName, position, salary);
        stage.close();

    }

    @FXML private void cancel(){
            Stage stage = (Stage) sceneVBox.getScene().getWindow();
            stage.close();
        }
}
