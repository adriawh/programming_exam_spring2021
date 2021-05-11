package ntnu.adriawh.view;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Dialog to show descriptions about each category contained in the tableView of the application
 */
public class AboutCategoryDialog extends Dialog<String> {

    public AboutCategoryDialog(){

        setTitle("Category information");

        // Set the button types.
        getDialogPane().getButtonTypes().addAll(ButtonType.CLOSE);


        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));


        Label bLabel= new Label("B:");
        Label bInformation = new Label(CategoryInformation.get("B"));

        Label fLabel= new Label("F:");
        Label fInformation = new Label(CategoryInformation.get("F"));

        Label gLabel= new Label("G:");
        Label gInformation = new Label(CategoryInformation.get("G"));

        Label pLabel= new Label("P:");
        Label pInformation = new Label(CategoryInformation.get("P"));

        Label sLabel= new Label("S:");
        Label sInformation = new Label(CategoryInformation.get("S"));


        grid.add(bLabel, 1, 1);
        grid.add(bInformation, 2, 1);
        grid.add(fLabel, 1, 2);
        grid.add(fInformation, 2, 2);
        grid.add(gLabel, 1, 3);
        grid.add(gInformation, 2, 3);
        grid.add(pLabel, 1, 4);
        grid.add(pInformation, 2, 4);
        grid.add(sLabel, 1, 5);
        grid.add(sInformation, 2, 5);

        getDialogPane().setContent(grid);

    }
}

