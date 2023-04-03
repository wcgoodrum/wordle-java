package edu.virginia.cs.gui;

import edu.virginia.cs.wordle.Wordle;
import edu.virginia.cs.wordle.WordleImplementation;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class WordleController {

    // new wordle game state
    Wordle wordle = new WordleImplementation();
    @FXML
    private Button newGameButton;
    @FXML
    private Button endGameButton;
    @FXML
    private Label playAgainText;
    @FXML
    private List<Label> LetterList;

    @FXML
    protected void initializeEnd() {
        if (wordle.isGameOver()) {
            playAgainText.setVisible(true);
            newGameButton.setVisible(true);
            endGameButton.setVisible(true);
        }
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