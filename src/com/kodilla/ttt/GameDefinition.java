package com.kodilla.ttt;

public class GameDefinition {

    private boolean isRoundFinished = false;
    private DifficultyLevel difficultyLevel = DifficultyLevel.EASY;
    private int maxNumberOfRounds = 5;
    private int playerPoints;
    private int enemyPoints;
    private int actualRound = 1;




    public DifficultyLevel getDifficultyLevel () {
        return difficultyLevel;
    }

    public void setDifficultyLevel (DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public int getMaxNumberOfRounds () {
        return maxNumberOfRounds;
    }

    public void setMaxNumberOfRounds (int maxNumberOfRounds) {
        this.maxNumberOfRounds = maxNumberOfRounds;
    }

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

    public boolean isRoundFinished () {
        return isRoundFinished;
    }

    public void setRoundFinished (boolean roundFinished) {
        isRoundFinished = roundFinished;
    }
}
