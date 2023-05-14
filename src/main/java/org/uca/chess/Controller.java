package org.uca.chess;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class Controller {
    @FXML
    private GridPane grid;

    public void initialize() {
        Game game = new Game(grid);
    }
}
