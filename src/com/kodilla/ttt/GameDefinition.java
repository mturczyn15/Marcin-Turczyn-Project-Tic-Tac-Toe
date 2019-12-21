package com.kodilla.ttt;

public class GameDefinition {

    private boolean isRestarted = false;
    private boolean isClosed;
    private DifficultyLevel difficultyLevel = DifficultyLevel.EASY;
    private int maxNumberOfRounds = 5;


    public boolean getIsRestarted() {
        return isRestarted;
    }

    public void setRestarted(boolean restarted) {
        isRestarted = restarted;
    }

    public boolean getIsClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public int getMaxNumberOfRounds() {
        return maxNumberOfRounds;
    }

    public void setMaxNumberOfRounds(int maxNumberOfRounds) {
        this.maxNumberOfRounds = maxNumberOfRounds;
    }
}
