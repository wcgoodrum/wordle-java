package edu.virginia.cs.gui;

import edu.virginia.cs.wordle.Wordle;
import edu.virginia.cs.wordle.WordleImplementation;
import edu.virginia.cs.wordle.LetterResult;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class WordleController {
    Wordle game = new WordleImplementation();
    private int row = 0;
    private int col = 0;

    private void initializeLetters() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                getLetterLabel(i, j).setText("");
                getLetterLabel(i,j).setStyle("-fx-background-color: #e0e0e0; -fx-text-fill: #000000");
            }
        }
    }

    @FXML
    protected void keyHandler(KeyEvent keyEvent) {
        String VALID_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        if(!game.isGameOver()) {
            if (keyEvent.getCode() == KeyCode.BACK_SPACE && col > 0) {
                col--;
                getLetterLabel(row, col).setText("");
                invalidWord.setVisible(false);
            } else if (col<5 && VALID_LETTERS.contains(keyEvent.getCode().getChar())) {
                getLetterLabel(row, col).setText(keyEvent.getCode().getChar());

                if (col >= 4) {
                    checkWord();
                } else {
                    col++;
                }
            }
        }
    }

    @FXML
    private Label invalidWord;
    private void checkWord(){
        String guess = "";
        for(int i = 0; i < 5; i++){
            guess = guess.concat(getLetterLabel(row, i).getText());
        }

        try{
            LetterResult[] result = game.submitGuess(guess);
            setLetterColors(result);
            row++;
            col=0;
            if(game.isGameOver()){gameOver();}

        }catch(Exception IllegalWordException){
            invalidWord.setVisible(true);
            col++;
        }
    }

    private void setLetterColors(LetterResult[] result){
        for(int i = 0; i < 5; i++){
            switch(result[i]){
                case GRAY -> getLetterLabel(row, i).setStyle("-fx-background-color: #7e7e7e; -fx-text-fill: #FFFFFF");
                case YELLOW -> getLetterLabel(row, i).setStyle("-fx-background-color: #ffe940; -fx-text-fill: #FFFFFF");
                case GREEN -> getLetterLabel(row, i).setStyle("-fx-background-color: #4fdf73; -fx-text-fill: #FFFFFF");
            }
        }
    }

    @FXML
    private Label titleText;
    @FXML
    private Label endCard;
    private void gameOver(){
        titleText.setVisible(false);
        endCard.setVisible(true);
        gameReplay.setVisible(true);
        gameClose.setVisible(true);

        if (game.isWin()) {
            endCard.setText("Congratulations!");
        }else{
            endCard.setText("Answer:\n"+game.getAnswer());
        }
    }

    @FXML
    private Button gameReplay;
    @FXML
    protected void handleReplayButton(){
        titleText.setVisible(true);
        endCard.setVisible(false);
        gameReplay.setVisible(false);
        gameClose.setVisible(false);
        row = 0;
        col = 0;
        initializeLetters();
        game = new WordleImplementation();
    }

    @FXML
    private Button gameClose;
    @FXML
    protected void handleCloseButton(){
        Stage stage = (Stage) gameClose.getScene().getWindow();
        stage.close();
    }


    //  warning: this shit is fucking awful and i hate it and so will you
    @FXML private Label letter00;@FXML private Label letter01;@FXML private Label letter02;@FXML private Label letter03;@FXML private Label letter04;
    @FXML private Label letter10;@FXML private Label letter11;@FXML private Label letter12;@FXML private Label letter13;@FXML private Label letter14;
    @FXML private Label letter20;@FXML private Label letter21;@FXML private Label letter22;@FXML private Label letter23;@FXML private Label letter24;
    @FXML private Label letter30;@FXML private Label letter31;@FXML private Label letter32;@FXML private Label letter33;@FXML private Label letter34;
    @FXML private Label letter40;@FXML private Label letter41;@FXML private Label letter42;@FXML private Label letter43;@FXML private Label letter44;
    @FXML private Label letter50;@FXML private Label letter51;@FXML private Label letter52;@FXML private Label letter53;@FXML private Label letter54;
    private Label getLetterLabel(int row, int col){
        switch(row){
            case 0: switch(col){
                case 0: return letter00;
                case 1: return letter01;
                case 2: return letter02;
                case 3: return letter03;
                case 4: return letter04;
            }
            case 1: switch(col){
                case 0: return letter10;
                case 1: return letter11;
                case 2: return letter12;
                case 3: return letter13;
                case 4: return letter14;
            }break;
            case 2: switch(col){
                case 0: return letter20;
                case 1: return letter21;
                case 2: return letter22;
                case 3: return letter23;
                case 4: return letter24;
            }break;
            case 3: switch(col){
                case 0: return letter30;
                case 1: return letter31;
                case 2: return letter32;
                case 3: return letter33;
                case 4: return letter34;
            }break;
            case 4: switch(col){
                case 0: return letter40;
                case 1: return letter41;
                case 2: return letter42;
                case 3: return letter43;
                case 4: return letter44;
            }break;
            case 5: switch(col){
                case 0: return letter50;
                case 1: return letter51;
                case 2: return letter52;
                case 3: return letter53;
                case 4: return letter54;
            }break;
        }
        return letter00;
    }
}