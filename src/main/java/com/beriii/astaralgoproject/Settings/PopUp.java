package com.beriii.astaralgoproject.Settings;

import javafx.scene.control.Alert;

public class PopUp {
    public PopUp(String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
