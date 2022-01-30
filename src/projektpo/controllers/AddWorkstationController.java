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
import projektpo.java.ProcessorBrand;
import projektpo.java.UserType;
import projektpo.models.LibraryDB;

import java.net.URL;
import java.util.ResourceBundle;

public class AddWorkstationController implements Initializable {
    @FXML
    private Button addWorkstationBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private ChoiceBox<GraphicCardBrand> graphicSelect;

    @FXML
    private Label infoLabel;

    @FXML
    private TextField manufacturerTF;

    @FXML
    private TextField modelTF;

    @FXML
    private TextField nameTF;

    @FXML
    private ChoiceBox<ProcessorBrand> processorSelect;

    @FXML
    private VBox sceneVBox;

    private LibraryDB libraryDB;

    public AddWorkstationController(){}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        processorSelect.getItems().setAll(ProcessorBrand.values());
        graphicSelect.getItems().setAll(GraphicCardBrand.values());
        libraryDB = LibraryDB.getInstance();
    }

    @FXML private void addWorkstation() {
        String name = nameTF.getText();
        String manufacturer = manufacturerTF.getText();
        String model = modelTF.getText();
        ProcessorBrand processorBrand;
        GraphicCardBrand graphicCardBrand;

        try {
            processorBrand = processorSelect.getValue();
            graphicCardBrand = graphicSelect.getValue();
        } catch (NullPointerException e){
            infoLabel.setText("Należy markę procesora oraz karty graficznej!");
            return;
        } catch (Exception e) {
            infoLabel.setText("Nie udało się dodać stacji roboczej.");
            return;
        }

        Stage stage = (Stage) sceneVBox.getScene().getWindow();
        libraryDB.addWorkstation(name, manufacturer, model, processorBrand, graphicCardBrand);
        stage.close();

    }

    @FXML private void cancel(){
            Stage stage = (Stage) sceneVBox.getScene().getWindow();
            stage.close();
        }
}
