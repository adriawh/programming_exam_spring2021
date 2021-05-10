package ntnu.adriawh;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import ntnu.adriawh.exception.FileTypeException;
import ntnu.adriawh.model.PostalCode;
import ntnu.adriawh.persistance.TxtReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

/**
 * JavaFX App
 */
public class App extends Application {

    private static ArrayList<PostalCode> register;

    public static ArrayList<PostalCode> getRegister() {
        return register;
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        TxtReader reader = new TxtReader();
        try{
            register = reader.readRegister("src/main/resources/ntnu/adriawh/Postnummerregister-ansi.txt");
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("primary" + ".fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.setOnCloseRequest(event ->{
                exit();
                event.consume();
            });
            stage.show();

        }catch (IOException | FileTypeException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("There was an error starting the application");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    /**
     * Method called when the system is to close. User is met with confirmation dialog to
     * confirm if this is intended.
     */
    public static void exit(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit confirmation");
        alert.setHeaderText("Are you sure you want to exit the application");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.exit(1);
        }
    }
}