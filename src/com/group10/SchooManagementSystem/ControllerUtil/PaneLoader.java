package com.group10.SchooManagementSystem.ControllerUtil;

import com.group10.SchooManagementSystem.Data.StudentData;
import com.group10.SchooManagementSystem.Data.TeachersData;
import com.group10.SchooManagementSystem.StudentModule.StudentPersonalController;
import com.group10.SchooManagementSystem.TeacherModule.AttendanceController;
import com.group10.SchooManagementSystem.TeacherModule.PersonalController;
import com.group10.SchooManagementSystem.TeacherModule.TeacherController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

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
    public void loadPane(String fileName, TeachersData teachersData){
        Callback<Class<?>, Object> controllerFactory = type -> {
            if (type == PersonalController.class) {
                return new PersonalController(teachersData);
            }else if(type == AttendanceController.class) {
                return new AttendanceController(teachersData);
            }
            else {
                try {
                    return type.newInstance() ; // default behavior - invoke no-arg construtor
                } catch (Exception exc) {
                    System.err.println("Could not create controller for "+type.getName());
                    throw new RuntimeException(exc);
                }
            }
        };
        this.rootPane.getChildren().clear();
        AnchorPane pane = null;
        try {
            FXMLLoader firstLoader = new FXMLLoader(getClass().getResource(fileName));
            firstLoader.setControllerFactory(controllerFactory);
            pane = firstLoader.load();
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void loadPane(String fileName, StudentData studentData){
        Callback<Class<?>, Object> controllerFactory = type -> {
            if (type == StudentPersonalController.class) {
                return new StudentPersonalController(studentData);
            }
//            else if(type == AttendanceController.class) {
//                return new AttendanceController(teachersData);
//            }
            else {
                try {
                    return type.newInstance() ; // default behavior - invoke no-arg construtor
                } catch (Exception exc) {
                    System.err.println("Could not create controller for "+type.getName());
                    throw new RuntimeException(exc);
                }
            }
        };
        this.rootPane.getChildren().clear();
        AnchorPane pane = null;
        try {
            FXMLLoader firstLoader = new FXMLLoader(getClass().getResource(fileName));
            firstLoader.setControllerFactory(controllerFactory);
            pane = firstLoader.load();
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}

