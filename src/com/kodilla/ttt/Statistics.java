
package com.kodilla.ttt;

public final class Statistics {

    private int actualRound = 1;
    private int playerPoints;
    private int enemyPoints;
    private boolean hasNextMove;


    public int getPlayerPoints () {
        return playerPoints;
    }

    public void setPlayerPoints (int playerPoints) {
        this.playerPoints = playerPoints;
    }

    public int getEnemyPoints () {
        return enemyPoints;
    }

    public void setEnemyPoints (int enemyPoints) {
        this.enemyPoints = enemyPoints;
    }

    public void incPlayerPoints () {
        playerPoints ++;
    }

    public void incEnemyPoints () {
        enemyPoints ++;
    }

    public void incActualRounds () { actualRound ++;}

    public int getActualRound () {
        return actualRound;
    }

    public void setActualRound (int actualRound) {
        this.actualRound = actualRound;
    }



    /*public Winner whoWins() {
        if (wins > loses) return Winner.PLAYER;
        if (wins < loses) return Winner.ENEMY;
        return Winner.DRAW;
    }*/

    public boolean isHasNextMove() {
        return hasNextMove;
    }

    public void setHasNextMove(boolean hasNextMove) {
        this.hasNextMove = hasNextMove;
    }
}
