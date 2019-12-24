package com.kodilla.ttt;

public class GameDefinition {

    private DifficultyLevel difficultyLevel = DifficultyLevel.EASY;
    private int maxNumberOfRounds = 5;

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


}
