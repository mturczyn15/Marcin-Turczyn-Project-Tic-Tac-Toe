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

    public Game(UserInterface userInterface, GameDefinition gameDefinition) {
        this.userInterface = userInterface;
        this.gameDefinition = gameDefinition;
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
            RoundResult result = RoundResult.NONE;

            @Override
            public void handle(MouseEvent mouseEvent) {
                if (gameDefinition.getActualRound() <= gameDefinition.getMaxNumberOfRounds()) {
                    if (!gameDefinition.isRoundFinished()) {

                        if (mouseEvent.getTarget() instanceof Tile) {
                            Tile tile = (Tile) mouseEvent.getTarget();
                            if (result == RoundResult.NONE) {
                                userInterface.movePlayer(tile);
                            } else {
                                gameDefinition.setRoundFinished(true);

                            }
                            if (new RoundResolver(userInterface.getBoard().getTiles(), userInterface).findSameAs() == RoundResult.NONE) {
                                userInterface.moveComputer(tile);
                                if (new RoundResolver(userInterface.getBoard().getTiles(), userInterface).findSameAs() != RoundResult.NONE) {
                                    gameDefinition.setRoundFinished(true);
                                }
                            } else {
                                gameDefinition.setRoundFinished(true);
                            }
                        }
                    } else {

                        userInterface.getBoard().resetBoard();
                        if (userInterface.isStartPressed()) {userInterface.getStatisticsInfo().setText("Player: "  + userInterface.getGameDefinition().getPlayerPoints() + " Enemy: " + userInterface.getGameDefinition().getEnemyPoints() + " Round: " + userInterface.getGameDefinition().getActualRound() + "/" + userInterface.getGameDefinition().getMaxNumberOfRounds());}
                        gameDefinition.setRoundFinished(false);
                        result = RoundResult.NONE;
                        userInterface.getInfoText().setText("");
                    }
                } else {
                    gameDefinition.setRoundFinished(false);
                    userInterface.getBoard().resetBoard();
                    userInterface.getStatisticsInfo().setText("Player: "  + gameDefinition.getPlayerPoints() + " Enemy: " + gameDefinition.getEnemyPoints() + " Round: " + (gameDefinition.getActualRound() -1) + "/" + gameDefinition.getMaxNumberOfRounds());
                    userInterface.getInfoText().setText("Click start Game !!");
                }
            }
        });
        return scene;
    }
}