package org.uca.chess;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends ChessPiece {
    public Bishop(String color, String coor) {
        super("Bishop", color, coor);
    }

    public List<Coordinates> getPossibleMoves(ChessPiece[][] board) {
        List<Coordinates> pmoves = new ArrayList<>();
        int coorx = this.getCoorX();
        int coory = this.getCoorY();
        // Getting all the possible moves for a bishop in the top-left direction
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
        // Getting all the possible moves for a bishop in the top-right direction
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

        // Getting all the possible moves for a bishop in the bottom-left direction
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
        // Getting all the possible moves for a bishop in the bottom-right direction
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
        System.out.println(pmoves);
        return pmoves;
    }
}