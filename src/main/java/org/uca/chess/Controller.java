package org.uca.chess;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Controller {
    @FXML
    private GridPane grid;

    private Color light = Color.rgb(238, 238, 210);
    private Color dark = Color.rgb(118, 150, 86);
    public void initialize() {
        int col = 1;
        int row = 0;
        for (int i = 0; i < 64; i++) {
            Pane p = new Pane();
            if ((row+col) % 2 != 0) {
                p.setStyle("-fx-background-color: " + toRGBCode(light) + ";");
            } else {
                p.setStyle("-fx-background-color: " + toRGBCode(dark) + ";");
            }
            grid.add(p, col++, row);
            if (col == 9) {
                col = 1;
                row++;
            }
        }
    }

    public Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();
        for (Node node : childrens) {
            if(GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                return result;
            }
        }
        return result;
    }

    public static String toRGBCode(Color color) {
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }
}
