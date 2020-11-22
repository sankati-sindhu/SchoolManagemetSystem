package com.group10.SchooManagementSystem.LoginModule;

import com.group10.SchooManagementSystem.databaseUtil.ConnectDb;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class LoginApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("School Management System");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
