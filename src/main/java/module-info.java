module ntnu.adriawh {
    requires javafx.controls;
    requires javafx.fxml;

    opens ntnu.adriawh to javafx.fxml;
    opens ntnu.adriawh.model to javafx.graphics,javafx.base, javafx.fxml;
    exports ntnu.adriawh;
}