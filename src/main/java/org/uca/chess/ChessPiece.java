package org.uca.chess;

import java.nio.file.Path;

public abstract class ChessPiece {
    private final Character color;
    private final Path imagepath;

    public ChessPiece(Character color, Path path) throws Exception{
        if (color != 'b' && color != 'w') throw new Exception("The color of the piece should either be b or w!!!");
        this.color = color;
        this.imagepath = path;
    }

    public Character getColor() {
        return color;
    }

    public Path getImagePath() {
        return imagepath;
    }

//    public abstract List<Chess>
}
