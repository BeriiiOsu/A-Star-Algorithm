package com.beriii.astaralgoproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
    @FXML
    Button start;

    public void startBtn(ActionEvent event){
        View.windowSwitcher("AStarScreen.fxml");
    }
}
