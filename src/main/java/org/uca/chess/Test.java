package org.uca.chess;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Test extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Rectangle r = new Rectangle(10, 10, 100, 100);
        Image image = new Image("/org/uca/chess/images/BBishop.png");
        Rectangle2D rect = new Rectangle2D(0, 0, 100, 100);
        ImagePattern pattern = new ImagePattern(image);
        r.setFill(pattern);

        // Create a VBox layout and add the label and button
        VBox root = new VBox();
        root.getChildren().addAll();

        // Create a Scene with the layout and set it as the primary stage's scene
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);

        // Set the primary stage's title and show it
        primaryStage.setTitle("Basic JavaFX Application");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
