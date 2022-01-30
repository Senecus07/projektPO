package projektpo.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import projektpo.Main;
import projektpo.exceptions.NotBorrowedException;
import projektpo.exceptions.NotUsedException;
import projektpo.java.*;
import projektpo.models.LibraryDB;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private LibraryDB libraryDB;

    @FXML
    private Label outputLabel;

    @FXML
    private TableView<LibraryOrganizationalUnit> tableView;

    @FXML
    private TableColumn<LibraryOrganizationalUnit, Integer> idColumn;

    @FXML
    private TableColumn<LibraryOrganizationalUnit, String> nameColumn;

    @FXML
    private TableColumn<LibraryOrganizationalUnit, SubType> typeColumn;

    @FXML
    private Button addEmployeeBtn;

    @FXML
    private Button addUserBtn;

    @FXML
    private Button searchBtn;

    @FXML
    private Button resetBtn;

    @FXML
    private TextField searchTF;

    @FXML
    private ChoiceBox<SubType> filterChoice;

    @FXML
    private Button deleteBtn;

    @FXML
    private TextField deleteTF;

    @FXML
    private Button borrowBtn;

    @FXML
    private TextField deviceTF;

    @FXML
    private Button prolongationBtn;

    @FXML
    private TextField resourceTF;

    @FXML
    private Button returnBtn;

    @FXML
    private Button addDeviceBtn;

    @FXML
    private Button deleteDeviceBtn;

    public MainController(){}

    ObservableList<LibraryOrganizationalUnit> data = FXCollections.observableArrayList();
    TableView.TableViewSelectionModel<LibraryOrganizationalUnit> selectionModel;
    ObservableList<LibraryOrganizationalUnit> selectedObject;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        libraryDB = LibraryDB.getInstance();
        data.setAll(libraryDB.getLibraryDB());
        tableView.setItems(data);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("index"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("subType"));

        selectionModel = tableView.getSelectionModel();
        selectedObject = selectionModel.getSelectedItems();

        selectedObject.addListener((ListChangeListener<LibraryOrganizationalUnit>) change -> {
            try {
                outputLabel.setText(change.getList().get(0).toString());

                if (change.getList().get(0) instanceof Person){
                    borrowBtn.setDisable(false);
                    returnBtn.setDisable(false);
                    prolongationBtn.setDisable(false);
                    resourceTF.setDisable(false);
                }else{
                    borrowBtn.setDisable(true);
                    returnBtn.setDisable(true);
                    prolongationBtn.setDisable(true);
                    resourceTF.setDisable(true);
                }

                if (change.getList().get(0) instanceof Employee){
                    addDeviceBtn.setDisable(false);
                    deleteDeviceBtn.setDisable(false);
                    deviceTF.setDisable(false);
                }else{
                    addDeviceBtn.setDisable(true);
                    deleteDeviceBtn.setDisable(true);
                    deviceTF.setDisable(true);
                }
            }catch (IndexOutOfBoundsException e){
                outputLabel.setText("");
            }
        });

        filterChoice.getItems().setAll(SubType.values());
        filterChoice.setValue(SubType.Wszystkie);

        filterChoice.setOnAction((event) -> {
            SubType selectedItem = filterChoice.getSelectionModel().getSelectedItem();

            data.setAll(libraryDB.filterByType(selectedItem));
        });
    }

    @FXML private void search() {
        String str = searchTF.getText();

        data.setAll(libraryDB.searchByName(str));
    }

    @FXML private void reset(){
        data.setAll(libraryDB.getLibraryDB());
        selectionModel.clearSelection();
    }

    @FXML private void deleteObject(){
        int id;

        try{
            id = Integer.parseInt(deleteTF.getText());
            libraryDB.deleteObject(id);
        }catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Usuwanie obiektu");
            alert.setHeaderText(null);
            alert.setContentText("ID musi być liczbą");
            alert.showAndWait();
            return;
        }catch(IndexOutOfBoundsException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Usuwanie obiektu");
            alert.setHeaderText(null);
            alert.setContentText("Nie ma obiektu o takim ID");
            alert.showAndWait();
            return;
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Usuwanie obiektu");
            alert.setHeaderText(null);
            alert.setContentText("Nie udało się usunąć obiektu");
            alert.showAndWait();
            e.printStackTrace();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Usuwanie obiektu");
        alert.setHeaderText(null);
        alert.setContentText("Obiekt został usunięty");
        alert.showAndWait();
        reset();

    }

    @FXML void addDevice() {
        int id;

        try{
            id = Integer.parseInt(deviceTF.getText());
            ((Employee)selectedObject.get(0)).addUsedDevice((Device)libraryDB.getObjectByID(id));
        }catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Przypisywanie urządzenia do pracownika");
            alert.setHeaderText(null);
            alert.setContentText("ID musi być liczbą");
            alert.showAndWait();
            return;
        }catch(IndexOutOfBoundsException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Przypisywanie urządzenia do pracownika");
            alert.setHeaderText(null);
            alert.setContentText("Nie ma obiektu o takim ID");
            alert.showAndWait();
            return;
            }catch(NotUsedException e){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Przypisywanie urządzenia do pracownika");
                alert.setHeaderText(null);
                alert.setContentText("Urządzenie jest już używane przez wskazanego pracownika");
                alert.showAndWait();
                return;
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Przypisywanie urządzenia do pracownika");
            alert.setHeaderText(null);
            alert.setContentText("Nie udało się przypisać urządzenia");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Przypisywanie urządzenia do pracownika");
        alert.setHeaderText(null);
        alert.setContentText("Urządzenie zostało przypisane");
        alert.showAndWait();
        deviceTF.setText("");
    }

    @FXML void deleteDevice() {
        int id;

        try{
            id = Integer.parseInt(deviceTF.getText());
            ((Employee)selectedObject.get(0)).removeUsedDevice((Device)libraryDB.getObjectByID(id));
        }catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Usuwanie przypisania urządzenia");
            alert.setHeaderText(null);
            alert.setContentText("ID musi być liczbą");
            alert.showAndWait();
            return;
        }catch(IndexOutOfBoundsException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Usuwanie przypisania urządzenia");
            alert.setHeaderText(null);
            alert.setContentText("Nie ma obiektu o takim ID");
            alert.showAndWait();
            return;
        }catch(NotUsedException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Usuwanie przypisania urządzenia");
            alert.setHeaderText(null);
            alert.setContentText("Urządzenie nie jest używane przez wskazanego pracownika");
            alert.showAndWait();
            return;
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Usuwanie przypisania urządzenia");
            alert.setHeaderText(null);
            alert.setContentText("Nie udało się usunąć przypisania");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Usuwanie przypisania urządzenia");
        alert.setHeaderText(null);
        alert.setContentText("Przypisanie zostało usunięte");
        alert.showAndWait();
        deviceTF.setText("");
    }

    @FXML void borrowResource() {
        int id;

        try{
            id = Integer.parseInt(resourceTF.getText());
            ((Person)selectedObject.get(0)).borrowBook((Resource)libraryDB.getObjectByID(id));
        }catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Wypożyczanie zasobu");
            alert.setHeaderText(null);
            alert.setContentText("ID musi być liczbą");
            alert.showAndWait();
            return;
        }catch(IndexOutOfBoundsException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Wypożyczanie zasobu");
            alert.setHeaderText(null);
            alert.setContentText("Nie ma obiektu o takim ID");
            alert.showAndWait();
            return;
        }catch(NotBorrowedException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Wypożyczanie zasobu");
            alert.setHeaderText(null);
            alert.setContentText("Zasób jest już wypożyczony");
            alert.showAndWait();
            return;
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Wypożyczanie zasobu");
            alert.setHeaderText(null);
            alert.setContentText("Nie udało się wypożyczyć zasobu");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Wypożyczanie zasobu");
        alert.setHeaderText(null);
        alert.setContentText("Zasób został wypożyczony");
        alert.showAndWait();
        resourceTF.setText("");
    }

    @FXML void prolongResource() {
        int id;

        try{
            id = Integer.parseInt(resourceTF.getText());
            ((User)selectedObject.get(0)).prolongation((Resource)libraryDB.getObjectByID(id));
        }catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Prolongata");
            alert.setHeaderText(null);
            alert.setContentText("ID musi być liczbą");
            alert.showAndWait();
            return;
        }catch(IndexOutOfBoundsException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Prolongata");
            alert.setHeaderText(null);
            alert.setContentText("Nie ma obiektu o takim ID");
            alert.showAndWait();
            return;
        }catch(NotBorrowedException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Prolongata");
            alert.setHeaderText(null);
            alert.setContentText("Zasób nie jest wypożyczony przez wskazanego użytkownika");
            alert.showAndWait();
            return;
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Prolongata");
            alert.setHeaderText(null);
            alert.setContentText("Nie udało się przedłużyć wypożyczenia");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Prolongata");
        alert.setHeaderText(null);
        alert.setContentText("Wypożyczenie zostało przedłużone");
        alert.showAndWait();
        resourceTF.setText("");
    }

    @FXML void returnResource() {
        int id;

        try{
            id = Integer.parseInt(resourceTF.getText());
            ((Person)selectedObject.get(0)).returnBook((Resource)libraryDB.getObjectByID(id));
        }catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Zwrot zasobu");
            alert.setHeaderText(null);
            alert.setContentText("ID musi być liczbą");
            alert.showAndWait();
            return;
        }catch(IndexOutOfBoundsException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Zwrot zasobu");
            alert.setHeaderText(null);
            alert.setContentText("Nie ma obiektu o takim ID");
            alert.showAndWait();
            return;
        }catch(NotBorrowedException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Zwrot zasobu");
            alert.setHeaderText(null);
            alert.setContentText("Zasób nie jest wypożyczony przez wskazanego użytkownika");
            alert.showAndWait();
            return;
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Zwrot zasobu");
            alert.setHeaderText(null);
            alert.setContentText("Nie udało się zwrócić zasobu");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Zwrot zasobu");
        alert.setHeaderText(null);
        alert.setContentText("Zasób został zwrócony");
        alert.showAndWait();
        resourceTF.setText("");
    }

    @FXML private void openAddEmployeeDialog() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("addEmployeeView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Dodawanie pracownika");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        reset();
    }

    @FXML private void openAddUserDialog() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("addUserView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Dodawanie użytkownika");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        reset();
    }

    @FXML private void openAddWorkstationDialog() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("addWorkstationView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Dodawanie stacji roboczej");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        reset();
    }

    @FXML private void openAddPrinterDialog() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("addPrinterView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Dodawanie drukarki");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        reset();
    }

    @FXML private void openAddBookDialog() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("addBookView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Dodawanie książki");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        reset();
    }

    @FXML private void openAddMagazineDialog() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("addMagazineView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Dodawanie czasopisma");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        reset();
    }


}