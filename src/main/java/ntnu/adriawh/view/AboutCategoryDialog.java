package ntnu.adriawh.view;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import ntnu.adriawh.CategoryInformation;

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


        Label BLabel= new Label("B:");
        Label B = new Label(CategoryInformation.get("B"));

        Label FLabel= new Label("F:");
        Label F = new Label(CategoryInformation.get("F"));

        Label GLabel= new Label("G:");
        Label G = new Label(CategoryInformation.get("G"));

        Label PLabel= new Label("P:");
        Label P = new Label(CategoryInformation.get("P"));

        Label SLabel= new Label("S:");
        Label S = new Label(CategoryInformation.get("S"));


        grid.add(BLabel, 1, 1);
        grid.add(B, 2, 1);
        grid.add(FLabel, 1, 2);
        grid.add(F, 2, 2);
        grid.add(GLabel, 1, 3);
        grid.add(G, 2, 3);
        grid.add(PLabel, 1, 4);
        grid.add(P, 2, 4);
        grid.add(SLabel, 1, 5);
        grid.add(S, 2, 5);

        getDialogPane().setContent(grid);

    }
}

