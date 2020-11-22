package com.group10.SchooManagementSystem.AdminModule;

import com.group10.SchooManagementSystem.ControllerUtil.PaneLoader;
import com.group10.SchooManagementSystem.Data.*;
import com.group10.SchooManagementSystem.StudentModule.StudentController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML
    private AnchorPane rootPane;

//    @FXML
//    private TextField searchTf;
//
//    @FXML
//    private ComboBox<SearchTypes> searchCb;
//
//    @FXML
//    private ComboBox<UserTypes> filterCb;
//
//    @FXML
//    private Button searchBt;
//
//    @FXML
//    private TableView<UserData> userTable;
//
//    @FXML
//    private TableColumn<UserData, String> userIdCol,  nameCol, userTypeCol, emailIdCol, phoneNoCol;

//    protected AdminModel adminModel;
//    private ObservableList<UserData> userData;

    PaneLoader paneLoader;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paneLoader = new PaneLoader(this.rootPane);
        this.loadUsersPane();
        //this.paneLoader.loadPane("/com/group10/SchooManagementSystem/AdminModule/users.fxml");
//        this.filterCb.setItems(FXCollections.observableArrayList(UserTypes.values()));
//        this.searchCb.setItems(FXCollections.observableArrayList(SearchTypes.values()));
    }

    public void loadUsersPane() {
        this.paneLoader.loadPane("/com/group10/SchooManagementSystem/AdminModule/users.fxml");
    }

    public void loadIssuesPane(ActionEvent event) {
        this.paneLoader.loadPane("/com/group10/SchooManagementSystem/AdminModule/issues.fxml");
    }

    public void loadLogsPane(ActionEvent event) {
        this.paneLoader.loadPane("/com/group10/SchooManagementSystem/AdminModule/logs.fxml");
    }



//
//    @FXML
//    public void loadStudentData(javafx.event.ActionEvent event) {
////        this.userData = FXCollections.observableArrayList();
////        this.userData = this.adminModel.loadStudentData();
////        this.setUserTable();
//    }
//
//    public void clickedSearch(ActionEvent event){
//        System.out.println("clicked search");
//        try {
//            //this.loadUsers();
//            this.rootPane.getChildren().clear();
//            FXMLLoader fxmlLoader = new FXMLLoader();
//            AnchorPane pane = fxmlLoader.load(getClass().getResource("users.fxml").openStream());
//            UsersController usersController = fxmlLoader.getController();
//            System.out.println(usersController);
//            this.rootPane.getChildren().setAll(pane);
//            this.userData = FXCollections.observableArrayList();
//            this.userData = this.adminModel.getSearchData("userid","123", "admin");
//            usersController.setUserTable(this.userData);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
////        this.userData = FXCollections.observableArrayList();
////        this.userData = this.adminModel.getSearchData("userid","123", "admin");
////        this.setUserTable();
//
//    }
//
//    public void setUserTable(){
////        this.userIdCol.setCellValueFactory(new PropertyValueFactory<UserData, String>("userId"));
////        this.nameCol.setCellValueFactory(new PropertyValueFactory<UserData, String>("name"));
////        this.userTypeCol.setCellValueFactory(new PropertyValueFactory<UserData, String>("userType"));
////        this.emailIdCol.setCellValueFactory(new PropertyValueFactory<UserData, String>("mail"));
////        this.phoneNoCol.setCellValueFactory(new PropertyValueFactory<UserData, String>("phone"));
////        this.userTable.setItems(null);
////        this.userTable.setItems(userData);
//    }
//
//    public  void addUser(ActionEvent event) throws IOException {
//        this.rootPane.getChildren().clear();
//        AnchorPane pane = FXMLLoader.load(getClass().getResource("add.fxml"));
//        this.rootPane.getChildren().setAll(pane);
//    }
//
//    public  void loadLog() throws IOException {
//        this.rootPane.getChildren().clear();
//        AnchorPane pane = FXMLLoader.load(getClass().getResource("logs.fxml"));
//        this.rootPane.getChildren().setAll(pane);
//    }
//
//    public  void loadUsers()throws IOException {
//        this.rootPane.getChildren().clear();
//        AnchorPane pane = FXMLLoader.load(getClass().getResource("users.fxml"));
//        this.rootPane.getChildren().setAll(pane);
//    }
//
//
//    public void loadUsersloadUsers(ActionEvent event) {
//
//    }
}
