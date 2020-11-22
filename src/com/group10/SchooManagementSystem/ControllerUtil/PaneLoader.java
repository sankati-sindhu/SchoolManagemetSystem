package com.group10.SchooManagementSystem.ControllerUtil;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class PaneLoader {
    AnchorPane rootPane;

    public PaneLoader(AnchorPane rootPane) {
        this.rootPane = rootPane;
    }

    public void loadPane(String fileName){
        this.rootPane.getChildren().clear();
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource(fileName));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}

