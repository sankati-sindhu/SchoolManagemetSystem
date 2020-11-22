package com.group10.SchooManagementSystem.StudentModule;

import com.group10.SchooManagementSystem.ControllerUtil.PaneLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    @FXML
    AnchorPane rootPane;

    PaneLoader paneLoader;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paneLoader = new PaneLoader(rootPane);
        this.loadPersonalPane();

    }

    public void loadPersonalPane() {
        paneLoader.loadPane("/com/group10/SchooManagementSystem/StudentModule/personal.fxml");

    }

    public void loadAttendance(ActionEvent event) {
        paneLoader.loadPane("/com/group10/SchooManagementSystem/StudentModule/attendance.fxml");
    }

    public void loadPerformance(ActionEvent event) {
        paneLoader.loadPane("/com/group10/SchooManagementSystem/StudentModule/performance.fxml");
    }

    public void loadFeedback(ActionEvent event) {
        paneLoader.loadPane("/com/group10/SchooManagementSystem/StudentModule/feedback.fxml");
    }
}
