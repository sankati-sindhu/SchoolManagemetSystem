package com.group10.SchooManagementSystem.TeacherModule;

import com.group10.SchooManagementSystem.Data.TeachersData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PersonalController implements Initializable {
    @FXML
    private Label nameTf, departmentTf, mailTf, phoneTf, classteacherTf;

    private String userId;
    private TeachersData teachersData;

    public PersonalController(TeachersData teachersData){

        this.teachersData = teachersData;
    }
    public  PersonalController(String userId){
        this.userId = userId;
        PersonalModel personalModel = new PersonalModel(userId);
        try {
            this.teachersData = personalModel.getData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.setTeachersData();
    }

    private void setTeachersData(){
        this.nameTf.setText(teachersData.getName());
        this.departmentTf.setText(teachersData.getDepartment());
        this.mailTf.setText(teachersData.getMail());
        this.phoneTf.setText(teachersData.getPhone());
        this.classteacherTf.setText(teachersData.getGrade()+"-"+teachersData.getSection());
    }
}
