package com.group10.SchooManagementSystem.AdminModule;

import com.group10.SchooManagementSystem.Data.UserData;
import com.group10.SchooManagementSystem.Data.UserTypes;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class addController implements Initializable {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.typeCb.setItems(FXCollections.observableArrayList(UserTypes.values()));
        this.addModel = new AddModel();

    }

    public void addRecord(ActionEvent event) throws SQLException {
        System.out.print(userTf.getText()+ nameTf.getText()+ emailTf.getText()+
                "3/4/5"+ phoneTf.getText()+ (typeCb.getValue()).toString());
        UserData userData = new UserData(userTf.getText(), nameTf.getText(), emailTf.getText(),
                "3/4/5", phoneTf.getText(), (typeCb.getValue()).toString());
        addModel.addUser(userData);


    }
}
