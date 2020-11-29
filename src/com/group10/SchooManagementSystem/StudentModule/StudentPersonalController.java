package com.group10.SchooManagementSystem.StudentModule;

import com.group10.SchooManagementSystem.Data.StudentData;
import com.group10.SchooManagementSystem.Data.TeachersData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentPersonalController implements Initializable {

    @FXML
    private Label nameTf, rollnoTf, mailTf, phoneTf, gradeTf, sectionTf;
    private  String userId;
    private StudentData studentData;
    public StudentPersonalController(StudentData studentData){
        this.userId = userId;
        this.studentData = studentData;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.setStudentData();
    }

    private void setStudentData(){

        this.nameTf.setText(studentData.getName());
        this.rollnoTf.setText(studentData.getUserId());
        this.mailTf.setText(studentData.getMail());
        this.phoneTf.setText(studentData.getPhone());
        this.gradeTf.setText(studentData.getGrade());
        this.sectionTf.setText(studentData.getSection());
    }
}
