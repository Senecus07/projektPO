package projektpo.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import projektpo.java.MagazineCategory;
import projektpo.java.PeriodOfPublication;
import projektpo.models.LibraryDB;

import java.net.URL;
import java.util.ResourceBundle;

public class AddMagazineController implements Initializable {
    @FXML
    private Button addMagazineBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private ChoiceBox<MagazineCategory> categorySelect;

    @FXML
    private Label infoLabel;

    @FXML
    private TextField numOfPagesTF;

    @FXML
    private ChoiceBox<PeriodOfPublication> periodSelect;

    @FXML
    private VBox sceneVBox;

    @FXML
    private TextField titleTF;

    private LibraryDB libraryDB;

    public AddMagazineController(){}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        periodSelect.getItems().setAll(PeriodOfPublication.values());
        categorySelect.getItems().setAll(MagazineCategory.values());
        libraryDB = LibraryDB.getInstance();
    }

    @FXML private void addMagazine() {
        String title = titleTF.getText();
        int numOfPages;
        PeriodOfPublication periodOfPublication;
        MagazineCategory magazineCategory;

        try {
            numOfPages = Integer.parseInt(numOfPagesTF.getText());
            periodOfPublication = periodSelect.getValue();
            magazineCategory = categorySelect.getValue();
        } catch (NumberFormatException e) {
            infoLabel.setText("Ilość stron musi być liczbą!");
            return;
        } catch (NullPointerException e){
            infoLabel.setText("Należy wybrać okres publikacji oraz kategorię!");
            return;
        } catch (Exception e) {
            infoLabel.setText("Nie udało się dodać czasopisma.");
            return;
        }

        Stage stage = (Stage) sceneVBox.getScene().getWindow();
        libraryDB.addMagazine(title, numOfPages, periodOfPublication, magazineCategory);
        stage.close();

    }

    @FXML private void cancel(){
            Stage stage = (Stage) sceneVBox.getScene().getWindow();
            stage.close();
        }
}
