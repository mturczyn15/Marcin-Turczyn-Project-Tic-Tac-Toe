
package com.kodilla.ttt;

import com.kodilla.ttt.Round.RoundResult;

public final class Statistics {

    private  int actualRound = 1;
    private  int playerPoints;
    private  int enemyPoints;
    private boolean hasNextMove;

    public int getPlayerPoints () {
        return playerPoints;
    }

    public int getEnemyPoints () {
        return enemyPoints;
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

    public boolean getHasNextMove() {
        return hasNextMove;
    }

    public void setHasNextMove(boolean hasNextMove) {
        this.hasNextMove = hasNextMove;
    }

    public void updateStatistics (RoundResult result) {

        incActualRounds();
        if (result == RoundResult.COMPUTER) {
            incEnemyPoints();
        } else if (result == RoundResult.USER) {
            incPlayerPoints();
        }
    }

    public Winner whoWins() {
        if (playerPoints > enemyPoints) return Winner.PLAYER;
        if (playerPoints < enemyPoints) return Winner.ENEMY;
        return Winner.DRAW;
    }
}
