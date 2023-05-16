package org.uca.chess;

import javafx.scene.layout.CornerRadii;

import java.util.ArrayList;
import java.util.List;

public class Rook extends ChessPiece {
    public Rook(String color, String coor) {
        super("Rook", color, coor);
    }

    public List<Coordinates> getPossibleMoves(ChessPiece[][] board) {
        List<Coordinates> pmoves = new ArrayList<>();

        for (int i = 1; i < 9; i++) {
            Coordinates c = new Coordinates(this.getCoorY()+i, this.getCoorX());

            if (!c.isOnBoard()) continue;
            if (board[c.getRow()][c.getCol()-1] != null) {
                if (!board[c.getRow()][c.getCol()-1].getColor().equals(this.getColor())) {
                    pmoves.add(c);
                }
                break;
            }
            pmoves.add(c);
        }
        for (int i = 1; i < 9; i++) {
            Coordinates c = new Coordinates(this.getCoorY(), this.getCoorX()-i);

            if (!c.isOnBoard()) continue;
            if (board[c.getRow()][c.getCol()-1] != null) {
                if (!board[c.getRow()][c.getCol()-1].getColor().equals(this.getColor())) {
                    pmoves.add(c);
                }
                break;
            }
            pmoves.add(c);
        }
        for (int i = 1; i < 9; i++) {
            Coordinates c = new Coordinates(this.getCoorY(), this.getCoorX()+i);

            if (!c.isOnBoard()) continue;
            if (board[c.getRow()][c.getCol()-1] != null) {
                if (!board[c.getRow()][c.getCol()-1].getColor().equals(this.getColor())) {
                    pmoves.add(c);
                }
                break;
            }
            pmoves.add(c);
        }
        for (int i = 1; i < 9; i++) {
            Coordinates c = new Coordinates(this.getCoorY()-i, this.getCoorX());

            if (!c.isOnBoard()) continue;
            if (board[c.getRow()][c.getCol()-1] != null) {
                if (!board[c.getRow()][c.getCol()-1].getColor().equals(this.getColor())) {
                    pmoves.add(c);
                }
                break;
            }
            pmoves.add(c);
        }

        return pmoves;
    }
}