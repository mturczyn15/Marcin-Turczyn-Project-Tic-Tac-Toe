package com.kodilla.ttt;

public class GameResolver {
    private Tile[][] tiles;
    private UserInterface userInterface;
    private Tile temp;

    public GameResolver(Tile[][] tiles, UserInterface userInterface) {
        this.tiles = tiles;
        this.userInterface = userInterface;
    }

    public Result findSameAs() {
        if (findInARow()) {
            return checkWinner(temp);
        }
        if (findInACol()) {
            return checkWinner(temp);
        }
        if (findDiagonallyFromLeftToRight()) {
            return checkWinner(temp);
        }
        if (findDiagonallyFromRightToLeft()) {
            return checkWinner(temp);
        }
        return isBoardFull();

    }

    private static Result checkWinner (Tile tile) {
        if (tile.getMoveType() == MoveType.CIRCLE) {
            return Result.USER;
        }
        return Result.COMPUTER;
    }


    private boolean findInARow() {
        int count;
        for (int row = 0; row < 3; row++) {
            temp = tiles[row][0];
            count = 0;
            if (!temp.getMoveType().equals(MoveType.EMPTY)) {
                for (int col = 0; col < 3; col++) {
                    if (temp.getMoveType().equals(tiles[row][col].getMoveType())) {
                        temp = tiles[row][col];
                        count++;
                    }
                }
            }
            if (count == 3) {
                showWinner(tiles[row]);
                return true;
            }
        }
        return false;
    }

    private boolean findInACol() {
        int count;
        for (int col = 0; col < 3; col++) {
            count = 0;
            temp = tiles[0][col];
            if (temp.getMoveType() != MoveType.EMPTY) {
                for (int row = 0; row < 3; row++) {
                    if (temp.getMoveType().equals(tiles[row][col].getMoveType())) {
                        temp = tiles[row][col];
                        count++;
                    }
                }
            }
            if (count == 3) {
                Tile[] tempTile = new Tile[3];
                for (int row = 0; row < 3; row++) {
                    tempTile[row] = tiles[row][col];
                }
                showWinner(tempTile);
                return true;
            }
        }
        return false;
    }

    private boolean findDiagonallyFromLeftToRight() {
        int count = 0;
        Tile temp = tiles[0][0];
        for (int row = 0, col = 0; row < 3 && col < 3; row++, col++) {
            if (!temp.getMoveType().equals(MoveType.EMPTY)) {
                if (temp.getMoveType().equals(tiles[row][col].getMoveType())) {
                    temp = tiles[row][col];
                    count++;
                }
            }
            if (count == 3) {
                Tile[] tempTile = new Tile[3];
                for (row = 0, col = 0; row < 3 && col < 3; row++, col++) {
                    tempTile[row] = tiles[row][col];
                }
                showWinner(tempTile);
                return true;
            }
        }
        return false;
    }

    private boolean findDiagonallyFromRightToLeft() {
        int count = 0;
        Tile temp = tiles[0][2];
        for (int row = 0, col = 3 - 1; row < 3 && col >= 0; row++, col--) {
            if (!temp.getMoveType().equals(MoveType.EMPTY)) {
                if (temp.getMoveType().equals(tiles[row][col].getMoveType())) {
                    temp = tiles[row][col];
                    count++;
                }
            }
            if (count == 3) {
                Tile[] tempTile = new Tile[3];
                for (row = 0, col = 3 - 1; row < 3 && col >= 0; row++, col--) {
                    tempTile[row] = tiles[row][col];
                }
                showWinner(tempTile);
                return true;
            }
        }
        return false;
    }

    private void showWinner(Tile[] cell) {
        for (int i = 0; i < 3; i++) {
            if (cell[0].getMoveType().equals(MoveType.CIRCLE)) {
                cell[i].setStyle("-fx-border-color: black; -fx-background-color: #15c6cd");
            } else {
                cell[i].setStyle("-fx-border-color: black; -fx-background-color: #cd6427");
            }
        }
        if (cell[0].getMoveType().equals(MoveType.CIRCLE)) {
            /*userInterface.getGameDefinition().addPointsO();
            userInterface.getLblResultO().setText("Punkty O: " + userInterface.getGameDefinition().getPointsO());
            userInterface.getLblState().setText("Wygrał O");*/
        } else {
            /*userInterface.getGameDefinition().addPointsX();
            userInterface.getLblResultX().setText("Punkty X: " + userInterface.getGameDefinition().getPointsX());
            userInterface.getLblState().setText("Wygrał X");*/
        }
    }

    private Result isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (tiles[row][col].getMoveType().equals(MoveType.EMPTY)) {
                    return Result.NONE;
                }
            }
        }
        //userInterface.getLblState().setText("Remis");
        return Result.DRAFT;
    }
}
