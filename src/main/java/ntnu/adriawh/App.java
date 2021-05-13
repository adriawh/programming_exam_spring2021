package ntnu.adriawh;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import ntnu.adriawh.exception.FileTypeException;
import ntnu.adriawh.model.PostalCode;
import ntnu.adriawh.model.PostalCodeRegister;
import ntnu.adriawh.persistance.TXTReader;

import java.io.IOException;
import java.util.Optional;

/**
 * JavaFX App
 */
public class App extends Application {

    private static PostalCodeRegister register;

    /**
     * Accessor method
     * @return an observableList of the register
     */
    public static ObservableList<PostalCode> getRegisterWrapper() {
        return FXCollections.observableList(register.getRegister());
    }

    public static void main(String[] args) {
        launch();
    }

    /**
     * Method ran at launch.
     * Loads the register from the txt file and launches primary.fxml file.
     *
     * If there are thrown any exceptions the user is met with an alert with the error message.
     *
     * @param stage the stage to be shown
     */
    @Override
    public void start(Stage stage){
        TXTReader reader = new TXTReader();
        try{
            register = reader.readPostalCodeRegister("src/main/resources/ntnu/adriawh/Postnummerregister-UTF-8.txt");
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