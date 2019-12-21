package com.kodilla.ttt.computerStrategy;

import com.kodilla.ttt.Move;
import com.kodilla.ttt.MoveType;
import com.kodilla.ttt.Tile;

public class HardComputerStrategy {

    public static void computerMove(Tile[][] tiles) {
        //end to win
        for (int i = 0; i < 3; i++) {
            if (tiles[i][0].getMoveType().equals(MoveType.CROSS) && tiles[i][1].getMoveType().equals(MoveType.CROSS)
                    && tiles[i][2].getMoveType().equals(MoveType.EMPTY)) {
                tiles[i][2].setMoveType(MoveType.CROSS);
                Move.moveX(tiles[i][2]);
                return;
            }
            if (tiles[i][0].getMoveType().equals(MoveType.CROSS) && tiles[i][2].getMoveType().equals(MoveType.CROSS)
                    && tiles[i][1].getMoveType().equals(MoveType.EMPTY)) {
                tiles[i][1].setMoveType(MoveType.CROSS);
                Move.moveX(tiles[i][1]);
                return;
            }
            if (tiles[i][2].getMoveType().equals(MoveType.CROSS) && tiles[i][1].getMoveType().equals(MoveType.CROSS)
                    && tiles[i][0].getMoveType().equals(MoveType.EMPTY)) {
                tiles[i][0].setMoveType(MoveType.CROSS);
                Move.moveX(tiles[i][0]);
                return;
            }
            if (tiles[0][i].getMoveType().equals(MoveType.CROSS) && tiles[1][i].getMoveType().equals(MoveType.CROSS)
                    && tiles[2][i].getMoveType().equals(MoveType.EMPTY)) {
                tiles[2][i].setMoveType(MoveType.CROSS);
                Move.moveX(tiles[2][i]);
                return;
            }
            if (tiles[0][i].getMoveType().equals(MoveType.CROSS) && tiles[2][i].getMoveType().equals(MoveType.CROSS)
                    && tiles[1][i].getMoveType().equals(MoveType.EMPTY)) {
                tiles[1][i].setMoveType(MoveType.CROSS);
                Move.moveX(tiles[1][i]);
                return;
            }
            if (tiles[2][i].getMoveType().equals(MoveType.CROSS) && tiles[1][i].getMoveType().equals(MoveType.CROSS)
                    && tiles[0][i].getMoveType().equals(MoveType.EMPTY)) {
                tiles[0][i].setMoveType(MoveType.CROSS);
                Move.moveX(tiles[0][i]);
                return;
            }
        }
        if (tiles[0][0].getMoveType().equals(MoveType.CROSS) && tiles[1][1].getMoveType().equals(MoveType.CROSS)
                && tiles[2][2].getMoveType().equals(MoveType.EMPTY)) {
            tiles[2][2].setMoveType(MoveType.CROSS);
            Move.moveX(tiles[2][2]);
            return;
        }
        if (tiles[0][0].getMoveType().equals(MoveType.CROSS) && tiles[2][2].getMoveType().equals(MoveType.CROSS)
                && tiles[1][1].getMoveType().equals(MoveType.EMPTY)) {
            tiles[1][1].setMoveType(MoveType.CROSS);
            Move.moveX(tiles[1][1]);
            return;
        }
        if (tiles[2][2].getMoveType().equals(MoveType.CROSS) && tiles[1][1].getMoveType().equals(MoveType.CROSS)
                && tiles[0][0].getMoveType().equals(MoveType.EMPTY)) {
            tiles[0][0].setMoveType(MoveType.CROSS);
            Move.moveX(tiles[0][0]);
            return;
        }
        if (tiles[0][2].getMoveType().equals(MoveType.CROSS) && tiles[1][1].getMoveType().equals(MoveType.CROSS)
                && tiles[2][0].getMoveType().equals(MoveType.EMPTY)) {
            tiles[2][0].setMoveType(MoveType.CROSS);
            Move.moveX(tiles[2][0]);
            return;
        }
        if (tiles[0][2].getMoveType().equals(MoveType.CROSS) && tiles[2][0].getMoveType().equals(MoveType.CROSS)
                && tiles[1][1].getMoveType().equals(MoveType.EMPTY)) {
            tiles[1][1].setMoveType(MoveType.CROSS);
            Move.moveX(tiles[1][1]);
            return;
        }
        if (tiles[2][0].getMoveType().equals(MoveType.CROSS) && tiles[1][1].getMoveType().equals(MoveType.CROSS)
                && tiles[0][2].getMoveType().equals(MoveType.EMPTY)) {
            tiles[0][2].setMoveType(MoveType.CROSS);
            Move.moveX(tiles[0][2]);
            return;
        }

//block user
        for (int i = 0; i < 3; i++) {
            if (tiles[i][0].getMoveType().equals(MoveType.CIRCLE) && tiles[i][1].getMoveType().equals(MoveType.CIRCLE)
                    && tiles[i][2].getMoveType().equals(MoveType.EMPTY)) {
                tiles[i][2].setMoveType(MoveType.CROSS);
                Move.moveX(tiles[i][2]);
                return;
            }
            if (tiles[i][0].getMoveType().equals(MoveType.CIRCLE) && tiles[i][2].getMoveType().equals(MoveType.CIRCLE)
                    && tiles[i][1].getMoveType().equals(MoveType.EMPTY)) {
                tiles[i][1].setMoveType(MoveType.CROSS);
                Move.moveX(tiles[i][1]);
                return;
            }
            if (tiles[i][2].getMoveType().equals(MoveType.CIRCLE) && tiles[i][1].getMoveType().equals(MoveType.CIRCLE)
                    && tiles[i][0].getMoveType().equals(MoveType.EMPTY)) {
                tiles[i][0].setMoveType(MoveType.CROSS);
                Move.moveX(tiles[i][0]);
                return;
            }
            if (tiles[0][i].getMoveType().equals(MoveType.CIRCLE) && tiles[1][i].getMoveType().equals(MoveType.CIRCLE)
                    && tiles[2][i].getMoveType().equals(MoveType.EMPTY)) {
                tiles[2][i].setMoveType(MoveType.CROSS);
                Move.moveX(tiles[2][i]);
                return;
            }
            if (tiles[0][i].getMoveType().equals(MoveType.CIRCLE) && tiles[2][i].getMoveType().equals(MoveType.CIRCLE)
                    && tiles[1][i].getMoveType().equals(MoveType.EMPTY)) {
                tiles[1][i].setMoveType(MoveType.CROSS);
                Move.moveX(tiles[1][i]);
                return;
            }
            if (tiles[2][i].getMoveType().equals(MoveType.CIRCLE) && tiles[1][i].getMoveType().equals(MoveType.CIRCLE)
                    && tiles[0][i].getMoveType().equals(MoveType.EMPTY)) {
                tiles[0][i].setMoveType(MoveType.CROSS);
                Move.moveX(tiles[0][i]);
                return;
            }
        }
        if (tiles[0][0].getMoveType().equals(MoveType.CIRCLE) && tiles[1][1].getMoveType().equals(MoveType.CIRCLE)
                && tiles[2][2].getMoveType().equals(MoveType.EMPTY)) {
            tiles[2][2].setMoveType(MoveType.CROSS);
            Move.moveX(tiles[2][2]);
            return;
        }
        if (tiles[0][0].getMoveType().equals(MoveType.CIRCLE) && tiles[2][2].getMoveType().equals(MoveType.CIRCLE)
                && tiles[1][1].getMoveType().equals(MoveType.EMPTY)) {
            tiles[1][1].setMoveType(MoveType.CROSS);
            Move.moveX(tiles[1][1]);
            return;
        }
        if (tiles[2][2].getMoveType().equals(MoveType.CIRCLE) && tiles[1][1].getMoveType().equals(MoveType.CIRCLE)
                && tiles[0][0].getMoveType().equals(MoveType.EMPTY)) {
            tiles[0][0].setMoveType(MoveType.CROSS);
            Move.moveX(tiles[0][0]);
            return;
        }
        if (tiles[0][2].getMoveType().equals(MoveType.CIRCLE) && tiles[1][1].getMoveType().equals(MoveType.CIRCLE)
                && tiles[2][0].getMoveType().equals(MoveType.EMPTY)) {
            tiles[2][0].setMoveType(MoveType.CROSS);
            Move.moveX(tiles[2][0]);
            return;
        }
        if (tiles[0][2].getMoveType().equals(MoveType.CIRCLE) && tiles[2][0].getMoveType().equals(MoveType.CIRCLE)
                && tiles[1][1].getMoveType().equals(MoveType.EMPTY)) {
            tiles[1][1].setMoveType(MoveType.CROSS);
            Move.moveX(tiles[1][1]);
            return;
        }
        if (tiles[2][0].getMoveType().equals(MoveType.CIRCLE) && tiles[1][1].getMoveType().equals(MoveType.CIRCLE)
                && tiles[0][2].getMoveType().equals(MoveType.EMPTY)) {
            tiles[0][2].setMoveType(MoveType.CROSS);
            Move.moveX(tiles[0][2]);
            return;
        }

        RandomComputerStrategy.computerMove(tiles);
    }
}
