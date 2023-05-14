package org.uca.chess;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class ChessPiece {
    private String name;
    private String color;
    private String path;

    private Coordinates coor;
    private ImagePattern pattern;

    public ChessPiece(String name, String color, Coordinates coor) {
        this.name = name;
        this.color = color;
        this.path = "/org/uca/chess/images/" + color + name + ".png";
        this.coor = coor;
        this.pattern = new ImagePattern(new Image(this.path));
    }

    public ChessPiece(String name, String color, String coor) {
        this.name = name;
        this.color = color;
        this.path = "/org/uca/chess/images/" + color + name + ".png";
        this.coor = new Coordinates(coor);
        this.pattern = new ImagePattern(new Image(this.path));
    }
    public ImagePattern getPattern() {
        return this.pattern;
    }
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getPath() {
        return path;
    }

    public Coordinates getCoor() {
        return coor;
    }

    public void setCoor(String coor) {
        this.coor = new Coordinates(coor);
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getCoorX() {
        return this.coor.getCol();
    }
    public int getCoorY() {
        return this.coor.getRow();
    }

    @Override
    public String toString() {
        return color+name;
    }
}