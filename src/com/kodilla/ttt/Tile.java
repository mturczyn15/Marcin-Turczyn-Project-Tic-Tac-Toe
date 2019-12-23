package com.kodilla.ttt;

import javafx.scene.layout.StackPane;

public class Tile extends StackPane {

    private MoveType moveType = MoveType.EMPTY;

    public Tile() {
        setStyle("-fx-border-color: black; -fx-background-color: green");
        setPrefSize(141, 141);
    }

    public MoveType getMoveType() {
        return moveType;
    }

    public void setMoveType(MoveType moveType) {
        this.moveType = moveType;
    }
}