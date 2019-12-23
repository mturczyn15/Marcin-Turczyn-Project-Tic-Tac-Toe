package com.kodilla.ttt;

import com.kodilla.ttt.computerStrategy.HardComputerStrategy;
import com.kodilla.ttt.computerStrategy.RandomComputerStrategy;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class UserInterface {

    private Board board;
    private GameDefinition gameDefinition;
    private Text infoText;
    private Text statisticsInfo;
    private boolean startPressed;

    public UserInterface(GameDefinition gameDefinition) {
        this.gameDefinition = gameDefinition;
        this.board = new Board();
        this.infoText = new Text();
        this.statisticsInfo = new Text();
    }

    /*public void moveComputer(Tile tile) {
        if (tile.getMoveType() != (MoveType.EMPTY)) {
            if (!tile.isOwned()) {
                if (gameDefinition.getDifficultyLevel().equals(DifficultyLevel.HARDER)) {
                    HardComputerStrategy.computerMove(board.getTiles());
                } else {
                    RandomComputerStrategy.computerMove(board.getTiles());
                }
                tile.setOwned(true);
            }
        }
    }

    public void movePlayer(Tile tile) {

        if (tile.getMoveType() == (MoveType.EMPTY)) {
            Move.moveO(tile);
            tile.setMoveType(MoveType.CIRCLE);
        }
    }*/

    public RoundResult move(Tile tile) {

        if (tile.getMoveType() == MoveType.EMPTY) {
            tile.setMoveType(MoveType.CIRCLE);
            Move.moveO(tile);
            RoundResult roundResult = new RoundResolver(board.getTiles(), this).findSameAs();
            if (roundResult == RoundResult.NONE) {

                if (gameDefinition.getDifficultyLevel().equals(DifficultyLevel.HARDER)) {
                    HardComputerStrategy.computerMove(board.getTiles());
                } else {
                    RandomComputerStrategy.computerMove(board.getTiles());
                }
                roundResult = new RoundResolver(board.getTiles(), this).findSameAs();
            }
            return roundResult;
        }
        return RoundResult.NONE;

    }






    public Pane menuAndBorder() {

        Text difficultyLevelText = new Text();
        difficultyLevelText.setText("Choose difficulty level: ");
        difficultyLevelText.setLayoutX(100);
        difficultyLevelText.setLayoutY(70);

        ComboBox<String> comboDifficultyLevel = new ComboBox<>();
        comboDifficultyLevel.getItems().addAll("Easy", "Hard");
        comboDifficultyLevel.getSelectionModel().select(0);
        comboDifficultyLevel.setLayoutX(100);
        comboDifficultyLevel.setLayoutY(90);

        statisticsInfo.setLayoutX(70);
        statisticsInfo.setLayoutY(280);

        Text numberRoundText = new Text("Choose number of rounds:");
        numberRoundText.setLayoutY(150);
        numberRoundText.setLayoutX(100);
        Spinner<Integer> spinner = new Spinner<>();
        spinner.setLayoutX(100);
        spinner.setLayoutY(170);
        spinner.setMaxWidth(100);
        final int initialValue = 5;
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 50, initialValue);
        spinner.setValueFactory(valueFactory);
        spinner.valueProperty().addListener(new ChangeListener<Integer>() {

            @Override
            public void changed(ObservableValue<? extends Integer> observable,//
                                Integer oldValue, Integer newValue) {
            }
        });

        Button startGameButton = new Button("Start Game");
        startGameButton.setLayoutX(100);
        startGameButton.setLayoutY(220);
        startGameButton.setOnAction(event -> {
            startPressed = true;
            if (comboDifficultyLevel.getValue().equals("Easy")) {
                gameDefinition.setDifficultyLevel(DifficultyLevel.EASY);
                System.out.println("Easy");
            } else {
                gameDefinition.setDifficultyLevel(DifficultyLevel.HARDER);
                System.out.println("Hard");
            }
            gameDefinition.setActualRound(1);
            getInfoText().setText("");
            gameDefinition.setEnemyPoints(0);
            gameDefinition.setPlayerPoints(0);
            gameDefinition.setMaxNumberOfRounds(spinner.getValue());
            statisticsInfo.setText("Player: "  + gameDefinition.getPlayerPoints() + " Enemy: " + gameDefinition.getEnemyPoints() + " Round: " + gameDefinition.getActualRound() + "/" + gameDefinition.getMaxNumberOfRounds());
            System.out.println(gameDefinition.getMaxNumberOfRounds());
        });


        Button exitButton = new Button();
        exitButton.setText("Exit Game");
        exitButton.setMinSize(200,60);
        exitButton.setLayoutX(50);
        exitButton.setLayoutY(300);
        exitButton.setOnAction(e -> {
            System.exit(0);
        });

        infoText.setFont(Font.font(15));
        infoText.setLayoutX(25);
        infoText.setLayoutY(400);

        Pane grid = new Pane();
        grid.setPrefSize(725, 425);
        grid.getChildren().addAll(statisticsInfo, numberRoundText, infoText, exitButton, startGameButton, comboDifficultyLevel, difficultyLevelText, spinner);
        grid.setStyle("-fx-border-color: black; -fx-background-color: #cdc06c");
        return grid;
    }

    Board getBoard() {
        return board;
    }

    Text getInfoText() {
        return infoText;
    }

    GameDefinition getGameDefinition() {
        return gameDefinition;
    }

    Text getStatisticsInfo() {
        return statisticsInfo;
    }

    boolean isStartPressed() {
        return startPressed;
    }
}
