package ntnu.adriawh.controller;

import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ntnu.adriawh.App;
import ntnu.adriawh.model.PostalCode;
import ntnu.adriawh.view.AboutCategoryDialog;
import ntnu.adriawh.view.AboutDialog;

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


    public void initialize() {
        columnFactory();

        FilteredList<PostalCode> register = new FilteredList<>(App.getRegisterWrapper());

        tableView.setItems(register);

        //Updates the tableview everytime there is a change in the searchBar
        searchField.textProperty().addListener((observable, oldValue, newValue) -> updateList(register));
    }


    /**
     * Updates the list based on the input from the user in the searchBar text field.
     * If the input contains numbers it checks the postal codes, else it searches by postal office name
     */
    private void updateList(FilteredList<PostalCode> register){
        if(searchField.getText().matches(".*\\d.*")){
            register.setPredicate(post -> post.getCode().contains(searchField.getText()));
        }else{
            register.setPredicate(post -> post.getPostOffice().toLowerCase()
                    .contains(searchField.getText().toLowerCase()));
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



    //Application menu

    /**
     * Shows a dialog containing basic information abut the application
     */
    @FXML
    private void aboutApplication(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Norwegian postal register");
        alert.setContentText("An application made for finding the wanted postal \n code and associated information");
        alert.showAndWait();
    }

    /**
     * Shows a confirmation dialog asking if the user really want to exit the application
     */
    @FXML
    private void closeApplication(){
        App.exit();
    }


    //Edit menu

    /**
     * Shows a dialog about the selected postal code
     * If the user hasn't chosen a postal code the user is alerted
     */
    @FXML
    private void aboutChosen(){
        PostalCode chosen = tableView.selectionModelProperty().get().getSelectedItem();
        if(chosen == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("No postal code selected");
            alert.setContentText("Please select a postal code and try again");
            alert.showAndWait();
        }else{
            AboutDialog about = new AboutDialog(chosen);
            about.showAndWait();
        }
    }

    /**
     * Method that clears the search bar
     */
    @FXML
    private void clearSearch(){
        searchField.clear();
    }


    //Help menu

    /**
     * Shows a dialog showing information about all categories shown in the list
     */
    @FXML
    private void categoryExplanation(){
        AboutCategoryDialog about = new AboutCategoryDialog();
        about.showAndWait();
    }

    /**
     * Shows a dialog that explains how to use the application
     */
    @FXML
    private void howTo(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("How to use");
        alert.setHeaderText("How to use the application");
        alert.setContentText("Click in the searchbar and start searching. You can search either by postal code or post office" +
                "\n\n You can also scroll thru the register with the scrollbar to the right of the list" +
                "\n\n To show more detailed information about a postal code, " +
                "\n click on a code and click the button \" Show more \" ");
        alert.showAndWait();
    }
}
