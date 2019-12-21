package com.kodilla.ttt;

import javafx.scene.Parent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;



public class Board extends GridPane {

    private final Tile[][] tiles;

    public Board() {
        super();
        tiles = new Tile[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile();
                tiles[i][j] = tile;
            }
        }
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                this.addColumn(col, tiles[row][col]);
            }
        }
    }

    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tiles[i][j].setMoveType(MoveType.EMPTY);
                tiles[i][j].setOwned(false);
                tiles[i][j].getChildren().clear();
                tiles[i][j].setStyle("-fx-border-color: black; -fx-background-color: green");
            }
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }





}

