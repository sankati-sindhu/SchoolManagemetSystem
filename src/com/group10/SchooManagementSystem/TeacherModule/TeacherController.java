package com.group10.SchooManagementSystem.TeacherModule;

import com.group10.SchooManagementSystem.ControllerUtil.PaneLoader;
import com.group10.SchooManagementSystem.Data.TeachersData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TeacherController implements Initializable {
    @FXML
    private AnchorPane rootPane;

    PaneLoader paneLoader;
    private final String userId;
    private final PersonalModel personalModel;
    TeachersData teachersData;
    public TeacherController(String userId) {
        this.userId = userId;
        personalModel = new PersonalModel(userId);
        try {
            teachersData = personalModel.getData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println(teachersData.getDepartment());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paneLoader = new PaneLoader(rootPane);
        this.loadPersonalPane();
    }

    public void loadPersonalPane() {
        this.paneLoader.loadPane("/com/group10/SchooManagementSystem/TeacherModule/personal.fxml",teachersData );
    }

    public void loadAttendancePane(ActionEvent event) {
        this.paneLoader.loadPane("/com/group10/SchooManagementSystem/TeacherModule/attendance.fxml", teachersData);
    }

    public void loadExamsPane(ActionEvent event) {
        this.paneLoader.loadPane("/com/group10/SchooManagementSystem/TeacherModule/exams.fxml");
    }

    public void loadFeedbackPane(ActionEvent event) {
        this.paneLoader.loadPane("/com/group10/SchooManagementSystem/TeacherModule/feedback.fxml");

    }
}
