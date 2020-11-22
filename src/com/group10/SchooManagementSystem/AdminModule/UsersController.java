package com.group10.SchooManagementSystem.AdminModule;

import com.group10.SchooManagementSystem.Data.UserData;
import com.group10.SchooManagementSystem.ControllerUtil.PaneLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UsersController implements Initializable {

    @FXML
    private AnchorPane rootUserPane;
    @FXML
    private TableView<UserData> userTable;

    @FXML
    private TableColumn<UserData, String> userIdCol,  nameCol, userTypeCol, emailIdCol, phoneNoCol;

    private UsersModel usersModel;
    private ObservableList<UserData> userData;
    private PaneLoader paneLoader;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.usersModel = new UsersModel();
        paneLoader = new PaneLoader(this.rootUserPane);
        this.loadStudentData();
    }

    public void loadAdd(ActionEvent event) {
        paneLoader.loadPane("/com/group10/SchooManagementSystem/AdminModule/add.fxml");
        //this.loadPane("add.fxml");
    }

    public void loadStudentData() {

            //this.loadUsers();
            //this.rootUserPane.getChildren().clear();
            //FXMLLoader fxmlLoader = new FXMLLoader();
//            System.out.println(usersController);

            this.userData = FXCollections.observableArrayList();
            this.userData = this.usersModel.loadStudentData();
            this.setUserTable(this.userData);


    }


    public void setUserTable(ObservableList<UserData> userData){
        this.userIdCol.setCellValueFactory(new PropertyValueFactory<UserData, String>("userId"));
        this.nameCol.setCellValueFactory(new PropertyValueFactory<UserData, String>("name"));
        this.userTypeCol.setCellValueFactory(new PropertyValueFactory<UserData, String>("userType"));
        this.emailIdCol.setCellValueFactory(new PropertyValueFactory<UserData, String>("mail"));
        this.phoneNoCol.setCellValueFactory(new PropertyValueFactory<UserData, String>("phone"));
        this.userTable.setItems(null);
        this.userTable.setItems(userData);
    }


    public void clickedSearch(ActionEvent event) {
        this.userData = FXCollections.observableArrayList();
        this.userData = this.usersModel.loadStudentData();
        this.setUserTable(this.userData);

    }

}
