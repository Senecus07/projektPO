package projektpo.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import projektpo.java.GraphicCardBrand;
import projektpo.java.PrinterType;
import projektpo.java.ProcessorBrand;
import projektpo.models.LibraryDB;

import java.net.URL;
import java.util.ResourceBundle;

public class AddPrinterController implements Initializable {
    @FXML
    private Button addPrinterBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private Label infoLabel;

    @FXML
    private TextField manufacturerTF;

    @FXML
    private TextField modelTF;

    @FXML
    private TextField nameTF;

    @FXML
    private ChoiceBox<String> scannerSelect;

    @FXML
    private VBox sceneVBox;

    @FXML
    private ChoiceBox<PrinterType> typeSelect;

    private LibraryDB libraryDB;

    public AddPrinterController(){}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        typeSelect.getItems().setAll(PrinterType.values());
        scannerSelect.getItems().add("tak");
        scannerSelect.getItems().add("nie");
        libraryDB = LibraryDB.getInstance();
    }

    @FXML private void addPrinter() {
        String name = nameTF.getText();
        String manufacturer = manufacturerTF.getText();
        String model = modelTF.getText();
        PrinterType printerType;
        boolean integratedScanner;

        try {
            printerType = typeSelect.getValue();

            integratedScanner = scannerSelect.getValue().equals("tak");

        } catch (NullPointerException e){
            infoLabel.setText("Należy wybrać typ drukarki!");
            return;
        } catch (Exception e) {
            infoLabel.setText("Nie udało się dodać drukarki.");
            return;
        }

        Stage stage = (Stage) sceneVBox.getScene().getWindow();
        libraryDB.addPrinter(name, manufacturer, model, printerType, integratedScanner);
        stage.close();

    }

    @FXML private void cancel(){
            Stage stage = (Stage) sceneVBox.getScene().getWindow();
            stage.close();
        }
}
