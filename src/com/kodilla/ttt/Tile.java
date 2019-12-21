package com.kodilla.ttt;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class Tile extends StackPane {

    private MoveType moveType = MoveType.EMPTY;
    private Text text = new Text();
    private boolean owned;


    public Tile() {
        setStyle("-fx-border-color: black; -fx-background-color: green");
        setPrefSize(141, 141);
        setAlignment(Pos.CENTER);
        getChildren().add(text);
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