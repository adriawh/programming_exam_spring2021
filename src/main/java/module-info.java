module ntnu.adriawh {
    requires javafx.controls;
    requires javafx.fxml;

    opens ntnu.adriawh.controller to javafx.fxml;
    opens ntnu.adriawh.model to javafx.graphics,javafx.base, javafx.fxml;
    exports ntnu.adriawh;
}