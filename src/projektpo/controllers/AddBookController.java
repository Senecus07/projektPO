package projektpo.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import projektpo.java.BookGenre;
import projektpo.java.Position;
import projektpo.models.LibraryDB;

import java.net.URL;
import java.util.ResourceBundle;

public class AddBookController implements Initializable {
    @FXML
    private Button addBookBtn;

    @FXML
    private TextField authorTF;

    @FXML
    private Button cancelBtn;

    @FXML
    private ChoiceBox<BookGenre> genreSelect;

    @FXML
    private Label infoLabel;

    @FXML
    private TextField numOfPagesTF;

    @FXML
    private VBox sceneVBox;

    @FXML
    private TextField titleTF;

    private LibraryDB libraryDB;

    public AddBookController(){}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genreSelect.getItems().setAll(BookGenre.values());
        libraryDB = LibraryDB.getInstance();
    }

    @FXML private void addBook() {
        String title = titleTF.getText();
        String author = authorTF.getText();
        int numOfPages;
        BookGenre bookGenre;

        try {
            numOfPages = Integer.parseInt(numOfPagesTF.getText());
            bookGenre = genreSelect.getValue();
        } catch (NumberFormatException e) {
            infoLabel.setText("Ilość stron musi być liczbą!");
            return;
        } catch (NullPointerException e){
            infoLabel.setText("Należy wybrać gatunek!");
            return;
        } catch (Exception e) {
            infoLabel.setText("Nie udało się dodać książki.");
            return;
        }

        Stage stage = (Stage) sceneVBox.getScene().getWindow();
        libraryDB.addBook(title, numOfPages, author, bookGenre);
        stage.close();

    }

    @FXML private void cancel(){
            Stage stage = (Stage) sceneVBox.getScene().getWindow();
            stage.close();
        }
}
