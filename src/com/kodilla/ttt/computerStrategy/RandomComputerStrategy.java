package com.kodilla.ttt.computerStrategy;

import com.kodilla.ttt.Move;
import com.kodilla.ttt.MoveType;
import com.kodilla.ttt.Tile;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomComputerStrategy {

    private static final Random RANDOM = new Random();

    public static void computerMove(final Tile[][] tiles) {
        List<Tile> remainedTiles = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tiles[i][j].getMoveType().equals(MoveType.EMPTY)) {
                    remainedTiles.add(tiles[i][j]);
                }
            }
        }

        if (remainedTiles.size() > 0) {
            int r = RANDOM.nextInt((remainedTiles.size()));
            Tile drawnTile = remainedTiles.get(r);
            Move.moveX(drawnTile);
            drawnTile.setMoveType(MoveType.CROSS);
            drawnTile.setOwned(true);
            remainedTiles.clear();
        }
    }
}
