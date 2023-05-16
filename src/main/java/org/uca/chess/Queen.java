package org.uca.chess;

import java.util.ArrayList;
import java.util.List;

public class Queen extends ChessPiece {
    public Queen(String color, String coor) {
        super("Queen", color, coor);
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
        int coorx = this.getCoorX();
        int coory = this.getCoorY();
        for (int i = 1; i < 20; i++) {
            Coordinates c = new Coordinates(coory-i, coorx-i);
            if (!c.isOnBoard()) break;
            if (board[c.getRow()][c.getCol()-1] == null) {
                pmoves.add(c);
            } else if (!board[c.getRow()][c.getCol()-1].getColor().equals(this.getColor())) {
                pmoves.add(c);
                break;
            } else {
                break;
            }
        }
        for (int i = 1; i < 20; i++) {
            Coordinates c = new Coordinates(coory-i, coorx+i);
            if (!c.isOnBoard()) break;
            if (board[c.getRow()][c.getCol()-1] == null) {
                pmoves.add(c);
            } else if (!board[c.getRow()][c.getCol()-1].getColor().equals(this.getColor())) {
                pmoves.add(c);
                break;
            } else {
                break;
            }
        }

        for (int i = 1; i < 20; i++) {
            Coordinates c = new Coordinates(coory+i, coorx-i);
            if (!c.isOnBoard()) break;
            if (board[c.getRow()][c.getCol()-1] == null) {
                pmoves.add(c);
            } else if (!board[c.getRow()][c.getCol()-1].getColor().equals(this.getColor())) {
                pmoves.add(c);
                break;
            } else {
                break;
            }
        }
        for (int i = 1; i < 20; i++) {
            Coordinates c = new Coordinates(coory+i, coorx+i);
            if (!c.isOnBoard()) break;
            if (board[c.getRow()][c.getCol()-1] == null) {
                pmoves.add(c);
            } else if (!board[c.getRow()][c.getCol()-1].getColor().equals(this.getColor())) {
                pmoves.add(c);
                break;
            } else {
                break;
            }
        }
        return pmoves;
    }
}