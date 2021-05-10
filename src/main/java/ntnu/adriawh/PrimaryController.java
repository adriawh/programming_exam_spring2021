package ntnu.adriawh;

import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ntnu.adriawh.model.PostalCode;

public class PrimaryController {

    @FXML
    private TextField searchField;

    @FXML
    private TableView<PostalCode> tableView;

    @FXML
    private TableColumn<PostalCode, String> postalCode;

    @FXML
    private TableColumn<PostalCode, String> postOffice;

    @FXML
    private TableColumn<PostalCode, String> municipalCode;

    @FXML
    private TableColumn<PostalCode, String> municipalityName;

    @FXML
    private TableColumn<PostalCode, String> category;


    private ObservableList<PostalCode> register;

    public void initialize() {
        columnFactory();
        register = FXCollections.observableList(App.getRegister());
        tableView.setItems(register);

        searchField.textProperty().addListener((observable, oldValue, newValue) -> updateList());
    }


    private void updateList(){
        if(searchField.getText().matches(".*\\d.*")){
            tableView.setItems(FXCollections.observableArrayList(register.stream()
                    .filter(postalCode -> postalCode.getCode().contains(searchField.getText()))
                    .collect(Collectors.toList())));
        }else{
            tableView.setItems(FXCollections.observableArrayList(register.stream()
                    .filter(postalCode ->
                            postalCode.getPostOffice().toLowerCase()
                                    .contains(searchField.getText().toLowerCase()))
                    .collect(Collectors.toList())));
        }
    }

    /**
     * Sets the values of the TableView
     */
    private void columnFactory(){
        postalCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        postOffice.setCellValueFactory(new PropertyValueFactory<>("postOffice"));
        municipalCode.setCellValueFactory(new PropertyValueFactory<>("municipalCode"));
        municipalityName.setCellValueFactory(new PropertyValueFactory<>("municipalityName"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
    }

}
