package com.kodilla.ttt;

import javafx.geometry.Pos;
import javafx.scene.control.Cell;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Move {

    public static void moveX (Tile tile) {
        Text text = new Text();
        text.setFont(Font.font(60));
        text.setText("X");
        tile.getChildren().add(text);
    }

    public static void moveO (Tile tile) {
        Text text = new Text();
        text.setFont(Font.font(60));
        text.setText("O");
        tile.getChildren().add(text);
    }
}
