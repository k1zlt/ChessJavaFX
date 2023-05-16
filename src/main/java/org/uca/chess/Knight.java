package org.uca.chess;

import java.util.ArrayList;
import java.util.List;

public class Knight extends ChessPiece {
    public Knight(String color, String coor) {
        super("Knight", color, coor);
    }

    public List<Coordinates> getPossibleMoves(ChessPiece[][] board) {
        List<Coordinates> pmoves = new ArrayList<>();

        int[][] m = {
                    {-1, -2},       { 1, -2},
                {-2, -1},               { 2, -1},

                {-2, 1},                { 2, 1},
                    {-1, 2},        { 1, 2},
        };
        for (int[] i: m) {
            Coordinates c = new Coordinates(this.getCoorY() + i[0], this.getCoorX() + i[1]);
            if (!c.isOnBoard()) continue;
            if (board[c.getRow()][c.getCol()-1] != null) {
                if (board[c.getRow()][c.getCol()].getColor().equals(this.getColor())) {
                    continue;
                }
            }
            pmoves.add(c);
        }

        return pmoves;
    }
}