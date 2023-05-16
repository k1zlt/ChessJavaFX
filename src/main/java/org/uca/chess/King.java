package org.uca.chess;

import java.util.ArrayList;
import java.util.List;

public class King extends ChessPiece {
    public King(String color, String coor) {
        super("King", color, coor);
    }

    public List<Coordinates> getPossibleMoves(ChessPiece[][] board) {
        List<Coordinates> pmoves = new ArrayList<>();

        int[][] m = {
                {-1, -1}, {0, -1}, {1, -1},
                {-1, 0}, {1, 0},
                {-1, 1}, {0, 1}, {1, 1},
        };
        for (int[] i: m) {
            Coordinates c = new Coordinates(this.getCoorY() + i[0], this.getCoorX() + i[1]);
            if (!c.isOnBoard()) continue;
            if (board[c.getRow()][c.getCol()-1] != null) {
                if (board[c.getRow()][c.getCol()-1].getColor().equals(this.getColor())) {
                    continue;
                }
            }
            pmoves.add(c);
        }

        return pmoves;
    }
}