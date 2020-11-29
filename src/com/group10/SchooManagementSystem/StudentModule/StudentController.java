package com.group10.SchooManagementSystem.StudentModule;

import com.group10.SchooManagementSystem.ControllerUtil.PaneLoader;
import com.group10.SchooManagementSystem.Data.StudentData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    @FXML
    AnchorPane rootPane;

    PaneLoader paneLoader;

    private String userId;
    private StudentData studentData;
    private StudentPersonalModel personalModel;

    public StudentController(String userId){
        this.userId = userId;
        this.personalModel = new StudentPersonalModel(this.userId);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paneLoader = new PaneLoader(rootPane);
        try {
            this.studentData = personalModel.getData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        this.loadPersonalPane();

    }

    public void loadPersonalPane() {
        paneLoader.loadPane("/com/group10/SchooManagementSystem/StudentModule/personal.fxml", studentData);

    }

    public void loadAttendance(ActionEvent event) {
        paneLoader.loadPane("/com/group10/SchooManagementSystem/StudentModule/attendance.fxml", studentData);
    }

    public void loadPerformance(ActionEvent event) {
        paneLoader.loadPane("/com/group10/SchooManagementSystem/StudentModule/performance.fxml");
    }

    public void loadFeedback(ActionEvent event) {
        paneLoader.loadPane("/com/group10/SchooManagementSystem/StudentModule/feedback.fxml");
    }
}
