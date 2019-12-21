package com.kodilla.ttt;


import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Game {

    private UserInterface userInterface;
    private GameDefinition gameDefinition;

    public Game(UserInterface userInterface, GameDefinition gameDefinition) {
        this.userInterface = userInterface;
        this.gameDefinition = gameDefinition;
    }


    public Scene play() {

        Pane root = userInterface.menuAndBorder();
        GridPane gridPane = userInterface.getBoard();
        gridPane.setLayoutX(307);
        gridPane.setLayoutY(8);

        root.getChildren().add(gridPane);

        Scene scene = new Scene(root, 725, 425);

            scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                Result result = Result.NONE;

                @Override
                public void handle(MouseEvent mouseEvent) {


                    if (mouseEvent.getTarget() instanceof Tile) {

                        Tile tile = (Tile) mouseEvent.getTarget();

                        if (!gameDefinition.getIsRestarted()) {
                            if (result == Result.NONE) {
                                userInterface.movePlayer(tile);
                                result = new GameResolver(userInterface.getBoard().getTiles(), userInterface).findSameAs();

                            } else {
                                gameDefinition.setRestarted(true);
                            }

                            if (result == Result.NONE) {
                                userInterface.moveComputer(tile);
                                result = new GameResolver(userInterface.getBoard().getTiles(), userInterface).findSameAs();
                                if (result != Result.NONE) { gameDefinition.setRestarted(true); }
                            } else {
                                gameDefinition.setRestarted(true);
                            }
                        } else {
                            userInterface.getBoard().resetBoard();
                            gameDefinition.setRestarted(false);
                            result = Result.NONE;
                        }
                    }
                }
            });

        return scene;
    }
}

 /*if (mouseEvent.getTarget() instanceof Tile) {

         Tile tile = (Tile) mouseEvent.getTarget();
         userInterface.move(tile);
         if (!gameDefinition.getIsRestarted()) {
         if (userInterface.move(tile) != Result.NONE) {

         gameDefinition.setRestarted(true);
         } else {
         userInterface.getBoard().resetBoard();
         gameDefinition.setRestarted(false);
         result = Result.NONE;
         }
         }
         }*/