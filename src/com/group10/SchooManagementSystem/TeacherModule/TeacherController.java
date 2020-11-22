package com.group10.SchooManagementSystem.TeacherModule;

import com.group10.SchooManagementSystem.ControllerUtil.PaneLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class TeacherController implements Initializable {
    @FXML
    private AnchorPane rootPane;

    PaneLoader paneLoader;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paneLoader = new PaneLoader(rootPane);
        this.loadPersonalPane();

    }

    public void loadPersonalPane() {
        this.paneLoader.loadPane("/com/group10/SchooManagementSystem/TeacherModule/personal.fxml");
    }

    public void loadAttendancePane(ActionEvent event) {
        this.paneLoader.loadPane("/com/group10/SchooManagementSystem/TeacherModule/attendance.fxml");
    }

    public void loadExamsPane(ActionEvent event) {
        this.paneLoader.loadPane("/com/group10/SchooManagementSystem/TeacherModule/exams.fxml");
    }

    public void loadFeedbackPane(ActionEvent event) {
        this.paneLoader.loadPane("/com/group10/SchooManagementSystem/TeacherModule/feedback.fxml");

    }
}
