package edu.virginia.cs.gui;

import edu.virginia.cs.wordle.Wordle;
import edu.virginia.cs.wordle.WordleImplementation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class WordleController {

    @FXML
    private Button newGameButton;
    @FXML
    private Button endGameButton;

    @FXML
    protected void buttons_initialize() {
        newGameButton.setVisible(false);
        endGameButton.setVisible(false);
        // set to true if game is over
    }

    @FXML
    protected void restartGame() {
        // reset variables
    }

    @FXML
    protected void endGame(ActionEvent event){
        javafx.application.Platform.exit();
    }

}