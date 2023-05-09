module org.uca.chess {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.uca.chess to javafx.fxml;
    exports org.uca.chess;
}