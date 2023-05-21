package org.uca.chess;

public class Coordinates {
    private int row, col;

    public Coordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Coordinates(String coor) {
        this.col = "abcdefgh".indexOf(coor.charAt(0)) + 1;
        this.row = "87654321".indexOf(coor.charAt(1));
    }

    public int getRow() {
        return row;
    }
    public String getStr() {
        return String.valueOf("abcdefgh".charAt(this.col - 1)) + String.valueOf("87654321".charAt(this.row));
    }
    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public boolean isOnBoard() {
        return (this.row >= 0 && this.row <= 7 && this.col >= 1 && this.col <= 8);
    }
    public boolean equal(Coordinates other) {
        return this.col == other.getCol() && this.row == other.getRow();
    }
    public String toString() {
        return getStr();
    }
}
