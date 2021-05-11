package ntnu.adriawh.view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import ntnu.adriawh.model.PostalCode;


/**
 * Dialog to show information about a given postal code
 */
public class AboutDialog extends Dialog<PostalCode> {

    public AboutDialog(PostalCode postalCode){

        setTitle("Postal code information");

        getDialogPane().getButtonTypes().addAll(ButtonType.CLOSE);


        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));


        Label postalCodeLabel= new Label("Postal code: ");
        Label code = new Label(postalCode.getCode());

        Label postOfficeLabel= new Label("Post Office: ");
        Label office = new Label(postalCode.getPostOffice());

        Label municipalCodeLabel= new Label("Municipal code ");
        Label municipalCode = new Label(postalCode.getMunicipalCode());

        Label municipalityNameLabel= new Label("Municipality name: ");
        Label municipalityName = new Label(postalCode.getMunicipalityName());

        Label categoryLabel= new Label("Category: ");
        Label category = new Label(CategoryInformation.get(postalCode.getCategory()));


        grid.add(postalCodeLabel, 1, 1);
        grid.add(code, 2, 1);
        grid.add(postOfficeLabel, 1, 2);
        grid.add(office, 2, 2);
        grid.add(municipalCodeLabel, 1, 3);
        grid.add(municipalCode, 2, 3);
        grid.add(municipalityNameLabel, 1, 4);
        grid.add(municipalityName, 2, 4);
        grid.add(categoryLabel, 1, 5);
        grid.add(category, 2, 5);

        getDialogPane().setContent(grid);
    }
}

