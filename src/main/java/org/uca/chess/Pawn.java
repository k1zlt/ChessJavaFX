package org.uca.chess;

import javafx.scene.layout.CornerRadii;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends ChessPiece {
    public Pawn(String color, String coor) {
        super("Pawn", color, coor);
    }

    public List<Coordinates> getPossibleMoves(ChessPiece[][] board) {
        List<Coordinates> pmoves = new ArrayList<>();
        int k = 1;
        if (this.getColor().equals("W")) k = -1;

        int[][] m = new int[10][2];
        int i = 0;
        m[i++] = new int[]{k, 0};
        if (isFirstRank()) m[i++] = new int[]{2*k, 0};
        for (int[] j: m) {
            Coordinates c = new Coordinates(this.getCoorY() + j[0], this.getCoorX() + j[1]);
            if (board[c.getRow()][c.getCol() - 1] != null) break;
            pmoves.add(c);
        }
        for (Coordinates coor: new Coordinates[]{
                new Coordinates(this.getCoorY()+k, this.getCoorX()+k),
                new Coordinates(this.getCoorY()+k, this.getCoorX()-k)
        })
        {
            if (!coor.isOnBoard()) continue;
            if (board[coor.getRow()][coor.getCol()-1] != null) {
                if (!board[coor.getRow()][coor.getCol()-1].getColor().equals(this.getColor())) {
                    pmoves.add(coor);
                }
            }
        }
        return pmoves;
    }

    public boolean isFirstRank() {
        return (this.getColor().equals("W") && this.getCoorY() == 6) || (this.getColor().equals("B") && this.getCoorY() == 1);
    }
}