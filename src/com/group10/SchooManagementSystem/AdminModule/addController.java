package com.group10.SchooManagementSystem.AdminModule;

import com.group10.SchooManagementSystem.ControllerUtil.PaneLoader;
import com.group10.SchooManagementSystem.Data.StudentData;
import com.group10.SchooManagementSystem.Data.TeachersData;
import com.group10.SchooManagementSystem.Data.UserData;
import com.group10.SchooManagementSystem.Data.UserTypes;
import com.group10.SchooManagementSystem.StudentModule.StudentAttendanceModel;
import com.group10.SchooManagementSystem.StudentModule.StudentPersonalController;
import com.group10.SchooManagementSystem.StudentModule.StudentPersonalModel;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class addController implements Initializable {

    @FXML
    private AnchorPane addRoot;
    @FXML
    private CheckBox A1, B1, C1, D1, E1;
    @FXML
    private CheckBox A2, B2, C2, D2, E2;
    @FXML
    private CheckBox A3, B3, C3, D3, E3;
    @FXML
    private CheckBox A4, B4, C4, D4, E4;
    @FXML
    private CheckBox A5, B5, C5, D5, E5;
    @FXML
    private CheckBox A6, B6, C6, D6, E6;
    @FXML
    private CheckBox A7, B7, C7, D7, E7;
    @FXML
    private CheckBox A8, B8, C8, D8, E8;
    @FXML
    private CheckBox A9, B9, C9, D9, E9;
    @FXML
    private CheckBox A10, B10, C10, D10, E10;
    @FXML
    private CheckBox A0, B0, C0, D0, E0;
    @FXML
    private TextField userTf,  nameTf, emailTf, phoneTf;
    @FXML
    private TextField departmentTf, subjectTf, gradeTf, sectionTf;

    @FXML
    private ComboBox<UserTypes> typeCb;

    private AddModel addModel;
    Boolean edit; UserData userData;
    public addController(Boolean edit, UserData userData){
        this.edit = edit;
        this.userData = userData;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.typeCb.setItems(FXCollections.observableArrayList(UserTypes.values()));
        this.addModel = new AddModel();
        if(edit){
            try {
                this.showData();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private void showData() throws SQLException {
        userTf.setText(userData.getUserId());
        nameTf.setText(userData.getName());
        emailTf.setText(userData.getMail());
        phoneTf.setText(userData.getPhone());
        if(userData.getUserType().equals("Student")){
            StudentData studentData;
            StudentPersonalModel studentPersonalModel = new StudentPersonalModel(userData.getUserId());
            studentData = studentPersonalModel.getData();
            gradeTf.setText(studentData.getGrade());
            sectionTf.setText(studentData.getSection());
        }else{
            System.out.println("is a teacher");
        }

    }

    public void addRecord(ActionEvent event) throws SQLException {
        if(edit){

        }else{
            System.out.print(userTf.getText()+ nameTf.getText()+ emailTf.getText()+
                    phoneTf.getText()+ (typeCb.getValue()).toString());

            try {
                switch (( this.typeCb.getValue()).toString()){
                    case "Admin":
                        UserData userData = new UserData(userTf.getText(), nameTf.getText(), emailTf.getText(),
                                phoneTf.getText(), (typeCb.getValue()).toString());
                        addModel.addUser(userData);
                        break;
                    case "Student":
                        StudentData studentData = new StudentData(userTf.getText(), nameTf.getText(), emailTf.getText(),
                                phoneTf.getText(), sectionTf.getText(), gradeTf.getText());
                        addModel.addStudent(studentData);
                        break;
                    case "Teacher":
                        TeachersData teachersData = new TeachersData(userTf.getText(), nameTf.getText(), emailTf.getText(),
                                phoneTf.getText(),gradeTf.getText(), sectionTf.getText(),
                                departmentTf.getText());
                        addModel.addTeacher(teachersData);
                        if(A1.isSelected()){
                            addModel.addPermission(teachersData.getUserId(), "1", "a");
                        }if(A2.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "2", "a");
                    }if(A3.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "3", "a");
                    }if(A4.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "4", "a");
                    }if(A5.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "5", "a");
                    }if(A6.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "6", "a");
                    }if(A7.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "7", "a");
                    }if(A8.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "8", "a");
                    }if(A9.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "9", "a");
                    }if(A10.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "10", "a");
                    }if(A0.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "0", "a");
                    }if(B1.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "1", "b");
                    }if(B2.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "2", "b");
                    }if(B3.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "3", "b");
                    }if(B4.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "4", "b");
                    }if(B5.isSelected()) {
                        addModel.addPermission(teachersData.getUserId(), "5", "b");
                    }if(B6.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "6", "b");
                    }if(B7.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "7", "b");
                    }if(B8.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "8", "b");
                    }if(B9.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "9", "b");
                    }if(B10.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "10", "b");
                    }if(B0.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "0", "b");
                    }if(C1.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "1", "c");
                    }if(C2.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "2", "c");
                    }if(C3.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "3", "c");
                    }if(C4.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "4", "c");
                    }if(C5.isSelected()) {
                        addModel.addPermission(teachersData.getUserId(), "5", "c");
                    }if(C6.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "6", "c");
                    }if(C7.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "7", "c");
                    }if(C8.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "8", "c");
                    }if(C9.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "9", "c");
                    }if(C10.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "10", "c");
                    }if(C0.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "0", "c");
                    }if(D1.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "1", "d");
                    }if(D2.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "2", "d");
                    }if(D3.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "3", "d");
                    }if(D4.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "4", "d");
                    }if(D5.isSelected()) {
                        addModel.addPermission(teachersData.getUserId(), "5", "d");
                    }if(D6.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "6", "d");
                    }if(D7.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "7", "d");
                    }if(D8.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "8", "d");
                    }if(D9.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "9", "d");
                    }if(D10.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "10", "d");
                    }if(D0.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "0", "d");
                    }if(E1.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "1", "e");
                    }if(E2.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "2", "e");
                    }if(E3.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "3", "e");
                    }if(E4.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "4", "e");
                    }if(E5.isSelected()) {
                        addModel.addPermission(teachersData.getUserId(), "5", "e");
                    }if(E6.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "6", "e");
                    }if(E7.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "7", "e");
                    }if(E8.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "8", "e");
                    }if(E9.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "9", "e");
                    }if(E10.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "10", "e");
                    }if(E0.isSelected()){
                        addModel.addPermission(teachersData.getUserId(), "0", "e");
                    }
                        break;
                    default:
                        System.out.println("NO such option");
                }
            }
            catch (Exception ex){
                throw (ex);
            }finally {
                userTf.setText(""); nameTf.setText(""); emailTf.setText("");
                phoneTf.setText(""); departmentTf.setText("");sectionTf.setText("");
                gradeTf.setText("");

            }

        }
    }
}
