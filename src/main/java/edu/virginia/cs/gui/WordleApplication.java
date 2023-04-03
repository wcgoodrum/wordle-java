package edu.virginia.cs.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WordleApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(WordleApplication.class.getResource("wordle-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load()); // creates a scene with the pane and defines size of scene
        stage.setTitle("Wordel(TM) Application");
        stage.setScene(scene); // sets the stage to the scene we made
        stage.show(); // displays the stage as the window
    }

    public static void main(String[] args) {
        launch(args);
    }
}