package com.kodilla.ttt;

import javafx.scene.layout.StackPane;

public class Tile extends StackPane {

    private MoveType moveType = MoveType.EMPTY;
    private boolean owned;

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

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }
}