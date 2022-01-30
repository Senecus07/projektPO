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
import projektpo.java.UserType;
import projektpo.models.LibraryDB;

import java.net.URL;
import java.util.ResourceBundle;

public class AddUserController implements Initializable {
    @FXML private VBox sceneVBox;

    @FXML private TextField nameTF;

    @FXML private TextField lastNameTF;

    @FXML private ChoiceBox<UserType> typeSelect;

    @FXML private Button addUserBtn;

    @FXML private Button cancelBtn;

    @FXML private Label infoLabel;

    private LibraryDB libraryDB;

    public AddUserController(){}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        typeSelect.getItems().setAll(UserType.values());
        libraryDB = LibraryDB.getInstance();
    }

    @FXML private void addUser() {
        String name = nameTF.getText();
        String lastName = lastNameTF.getText();
        UserType userType;

        try {
            userType = typeSelect.getValue();
        } catch (NullPointerException e){
            infoLabel.setText("Należy wybrać stanowisko!");
            return;
        } catch (Exception e) {
            infoLabel.setText("Nie udało się dodać pracownika.");
            return;
        }

        Stage stage = (Stage) sceneVBox.getScene().getWindow();
        libraryDB.addUser(name, lastName, userType);
        stage.close();

    }

    @FXML private void cancel(){
            Stage stage = (Stage) sceneVBox.getScene().getWindow();
            stage.close();
        }
}
