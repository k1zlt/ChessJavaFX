package org.uca.chess;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.Arrays;
import java.util.List;

public class Game {

    private GridPane boardPane;
    private ChessPiece[][] board;
    private Color light = Color.rgb(238, 238, 210);
    private Color dark = Color.rgb(118, 150, 86);
    private ChessPiece[] pieces;
    private ObservableList<Node> boardPaneChildren;

    private ChessPiece selectedPiece = null;
    private Pane selectedPane = null;
    private String turn = "W";

    public Game(GridPane board) {
        this.boardPane = board;
        setup();
    }

    public void setup() {
        boardPaneChildren = this.boardPane.getChildren();
        board = new ChessPiece[8][8];
        int col = 1;
        int row = 0;
        for (int i = 0; i < 64; i++) {
            Pane p = new Pane();

            p.setOnMouseClicked(event -> {
                    cellClick(p, event);
            });

            p.setPrefWidth(100);
            p.setPrefHeight(100);


            boardPane.add(p, col++, row);
            if (col == 9) {
                col = 1;
                row++;
            }
        }
        paintTheCells();
        placePieces();
    }

    private void paintTheCells() {
        for (Node i: boardPaneChildren) {
            if (i instanceof Pane) {
                if ((GridPane.getRowIndex(i)+GridPane.getColumnIndex(i)) % 2 != 0) {
                    i.setStyle("-fx-background-color: " + toRGBCode(light) + ";");
                } else {
                    i.setStyle("-fx-background-color: " + toRGBCode(dark) + ";");
                }
                ((Pane) i).getChildren().removeIf(j -> j instanceof Circle);
            }

        }
    }
    private void cellClick(Pane pane, MouseEvent event) {
        paintTheCells();
        boolean moved = false;
        if (selectedPiece == null && getPieceFromPane(pane) != null) {
            if (!getPieceFromPane(pane).getColor().equals(turn)) {
                return;
            }
        }
        ChessPiece piece = getPieceFromPane(pane);
        Coordinates focus;
        if (selectedPiece != null) {
            focus = selectedPiece.getCoor();
        } else {
            focus = null;
        }
        Coordinates current;
        current = new Coordinates(GridPane.getRowIndex(pane), GridPane.getColumnIndex(pane));

        if (selectedPiece != null) {
            List<Coordinates> pmoves = selectedPiece.getPossibleMoves(this.board);
            for (int i = 0; i < pmoves.size(); i++) {
                if (pmoves.get(i).equal(current)) {
                    board[focus.getRow()][focus.getCol() - 1] = null;
                    board[pmoves.get(i).getRow()][pmoves.get(i).getCol() - 1] = selectedPiece;
                    if (focus != null) remove(focus);
                    if (current != null) remove(current);
                    selectedPiece.setCoor2(pmoves.get(i));
                    place(selectedPiece);
                    moved = true;
                    if (turn.equals("W")) {
                        turn = "B";
                    } else {
                        turn = "W";
                    }
                    break;
                }
            }
            selectedPiece = null;
            if (moved) {
                selectedPiece = piece;
            }
        } else {
            selectedPiece = piece;
            selectedPane = pane;
            ObservableList<Node> r = pane.getChildren();
            pane.setStyle("-fx-background-color: " + toRGBCode(Color.SKYBLUE) + ";");
            if (piece == null) {
                System.out.println("There is no any piece in this cell.");
                return;
            }
            List<Coordinates> pmoves = piece.getPossibleMoves(this.board);
            paintTheCells();
            for (Coordinates c : pmoves) {
                if (board[c.getRow()][c.getCol() - 1] == null) {
                    Circle circle = new Circle(58, 60, 25);
                    getPaneFromGridPane(this.boardPane, c.getRow(), c.getCol()).getChildren().add(circle);
                } else {
                    Circle circle = new Circle(58, 60, 50);
                    circle.setStroke(Color.BLACK);
                    circle.setStrokeWidth(10);
                    circle.setFill(Color.TRANSPARENT);
                    getPaneFromGridPane(this.boardPane, c.getRow(), c.getCol()).getChildren().add(circle);
                }
            }
        }
    }

    private void remove(Coordinates p) {
        Pane pane = getPaneFromGridPane(this.boardPane, p.getRow(), p.getCol());
        (pane).getChildren().removeIf(j -> j instanceof Rectangle);
    }

    private ChessPiece getPieceFromPane(Pane pane) {
        String coor = String.valueOf("abcdefgh".charAt(GridPane.getColumnIndex(pane)-1)) + "87654321".charAt(GridPane.getRowIndex(pane));
        System.out.println();
        for (ChessPiece i: this.pieces) {
            if (i == null) continue;
            if (i.getCoor().getStr().equals(coor)) {
                return i;
            }
        }
        return null;
    }
    public void place(ChessPiece piece) {
        Pane cell = getPaneFromGridPane(this.boardPane, piece.getCoor().getRow(), piece.getCoor().getCol());
        Rectangle r = new Rectangle(10, 10, 100, 100);
        r.setFill(Color.rgb(0,0,0,0));
        cell.getChildren().add(r);
        r.setFill(piece.getPattern());
        board[piece.getCoorY()][piece.getCoorX()-1] = piece;
    }

    public void placePieces() {
        pieces     = new ChessPiece[64];
        pieces[0]  = new Rook("B", "a8");
        pieces[1]  = new Rook("B", "h8");
        pieces[2]  = new Rook("W", "a1");
        pieces[3]  = new Rook("W", "h1");
        pieces[4]  = new Knight("B", "b8");
        pieces[5]  = new Knight("B", "g8");
        pieces[6]  = new Knight("W", "b1");
        pieces[7]  = new Knight("W", "g1");
        pieces[8]  = new Bishop("B", "c8");
        pieces[9]  = new Bishop("B", "f8");
        pieces[10] = new Bishop("W", "c1");
        pieces[11] = new Bishop("W", "f1");
        pieces[12] = new King("B", "e8");
        pieces[13] = new Queen("B", "d8");
        pieces[14] = new King("W", "e1");
        pieces[15] = new Queen("W", "d1");

//        pieces[0]  = new Rook("B", "a8");
//        pieces[1]  = new Rook("B", "h8");
//        pieces[2]  = new Rook("W", "a4");
//        pieces[3]  = new Rook("W", "h1");
//        pieces[4]  = new Knight("B", "b8");
//        pieces[5]  = new Knight("B", "g8");
//        pieces[6]  = new Knight("W", "d6");
//        pieces[7]  = new Knight("W", "g1");
//        pieces[8]  = new Bishop("B", "c8");
//        pieces[9]  = new Bishop("B", "f8");
//        pieces[10] = new Bishop("W", "c1");
//        pieces[11] = new Bishop("W", "f1");
//        pieces[12] = new King("B", "e6");
//        pieces[13] = new Queen("B", "d8");
//        pieces[14] = new King("W", "e1");
//        pieces[15] = new Queen("W", "d5");

        for (int i = 16; i < 24; i++) {
            pieces[i] = new Pawn("B", "abcdefgh".charAt(i-16)+"7");
            pieces[i+8] = new Pawn("W", "abcdefgh".charAt(i-16)+"2");
        }

        for (int i = 0; i < 32; i++) {
            System.out.println(pieces[i] + " is placed");
            place(pieces[i]);
        }

        soutBoard();
    }

    public static String toRGBCode(Color color) {
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }

    public Pane getPaneFromGridPane(GridPane gridPane, int row, int column) {
        ObservableList<Node> children = gridPane.getChildren();
        for (Node node : children) {
            try{
                if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                    return (Pane) node;
                }
            } catch (Exception ignored) {}
        }
        return null;
    }

    public void soutBoard() {
        for (ChessPiece[] i: board) {
            System.out.println(Arrays.deepToString(i));
        }
    }

}
