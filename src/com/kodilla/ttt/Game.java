package com.kodilla.ttt;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Game {

    private static final String TITLE = "Tic Tac Toe";
    private UserInterface userInterface;
    private GameDefinition gameDefinition;
    private Statistics statistics;

    public Game(UserInterface userInterface, GameDefinition gameDefinition) {
        this.userInterface = userInterface;
        this.gameDefinition = gameDefinition;
        this.statistics = new Statistics();
    }

    public String getTitle () {
        return TITLE;
    }

    public Scene play() {

        Pane root = userInterface.menuAndBorder();
        GridPane gridPane = userInterface.getBoard();
        gridPane.setLayoutX(307);
        gridPane.setLayoutY(8);

        root.getChildren().add(gridPane);

        Scene scene = new Scene(root, 725, 425);
        scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            RoundResult roundResult = RoundResult.NONE;

            @Override
            public void handle(MouseEvent mouseEvent) {
                if (statistics.getActualRound() <= gameDefinition.getMaxNumberOfRounds()) {
                    if (!statistics.isHasNextMove()) {
                        if (mouseEvent.getTarget() instanceof Tile) {
                            Tile tile = (Tile) mouseEvent.getTarget();
                            roundResult = userInterface.move(tile);
                            if (roundResult != RoundResult.NONE) {
                                statistics.setHasNextMove(true);
                            }
                        }
                    } else {

                        statistics.updateStatistics(roundResult);
                        if (statistics.getActualRound() > gameDefinition.getMaxNumberOfRounds()) {
                            Winner winner = statistics.whoWins();
                            userInterface.showWinner(winner);
                        } else {
                            userInterface.getInfoText().setText("");
                        }
                        userInterface.getBoard().resetBoard();
                        if (userInterface.isStartPressed() && statistics.getActualRound() <= gameDefinition.getMaxNumberOfRounds()) {userInterface.getStatisticsInfo().setText("Player: "  + statistics.getPlayerPoints() + " Enemy: " + statistics.getEnemyPoints() + " Round: " + statistics.getActualRound() + "/" + userInterface.getGameDefinition().getMaxNumberOfRounds());}
                        statistics.setHasNextMove(false);
                        roundResult = RoundResult.NONE;

                    }
                } else {

                    userInterface.getBoard().resetBoard();
                    userInterface.getStatisticsInfo().setText("Player: "  + statistics.getPlayerPoints() + " Enemy: " + statistics.getEnemyPoints() + " Round: " + (statistics.getActualRound() -1) + "/" + gameDefinition.getMaxNumberOfRounds());
                    userInterface.getInfoText().setText("Click start Game !!");
                    statistics = new Statistics();
                }
            }
        });
        return scene;
    }
}