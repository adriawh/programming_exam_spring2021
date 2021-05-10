package ntnu.adriawh;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ntnu.adriawh.model.PostalCode;
import ntnu.adriawh.persistance.TxtReader;

public class PrimaryController {

    @FXML
    private TableView<PostalCode> tableView;

    @FXML
    private TableColumn<PostalCode, Integer> postalCode;

    @FXML
    private TableColumn<PostalCode, String> postOffice;

    @FXML
    private TableColumn<PostalCode, Integer> municipalCode;

    @FXML
    private TableColumn<PostalCode, String> municipalityName;

    @FXML
    private TableColumn<PostalCode, String> category;


    private ObservableList<PostalCode> register;

    public void initialize() {
        columnFactory();
        register = FXCollections.observableList(App.getRegister());
        tableView.setItems(register);


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
