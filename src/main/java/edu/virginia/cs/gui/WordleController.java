package edu.virginia.cs.gui;

import edu.virginia.cs.wordle.Wordle;
import edu.virginia.cs.wordle.WordleImplementation;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class WordleController {
    Wordle wordle;
    @FXML
    private Button newGameButton;
    @FXML
    private Button endGameButton;
    @FXML
    private Label playAgainText;
    @FXML
    private List<Label> LetterList;

    @FXML
    protected void playGame() {
        wordle = new WordleImplementation();
        if (wordle.isGameOver())
            initializeEnd();
    }

    @FXML
    protected void initializeEnd() {
        playAgainText.setVisible(true);
        newGameButton.setVisible(true);
        endGameButton.setVisible(true);
    }

    @FXML
    protected void restartGame(ActionEvent event) {
        // reset variables
    }

    @FXML
    protected void endGame(ActionEvent event){
        javafx.application.Platform.exit();
    }
}