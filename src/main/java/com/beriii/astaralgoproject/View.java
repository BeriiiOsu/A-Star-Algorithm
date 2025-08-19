package com.beriii.astaralgoproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class View extends Application {
    private static Stage mainStage;
    private static final String mainFxml = "mainScreen.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        View.mainStage = stage;
        windowSwitcher(mainFxml);
        mainStage.setTitle("AStar Algorithm Project");
        mainStage.setResizable(false);
        mainStage.show();
    }

    public static void windowSwitcher(String fileName) {
        try{
            Parent root = FXMLLoader.load(View.class.getResource(fileName));
            mainStage.setScene(new Scene(root));
        }catch (Exception e){}
    }
}
