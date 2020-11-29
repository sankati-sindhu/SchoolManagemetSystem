package com.group10.SchooManagementSystem.AdminModule;

import com.group10.SchooManagementSystem.Data.SearchTypes;
import com.group10.SchooManagementSystem.Data.UserData;
import com.group10.SchooManagementSystem.ControllerUtil.PaneLoader;
import com.group10.SchooManagementSystem.Data.UserTypes;
import com.group10.SchooManagementSystem.StudentModule.StudentController;
import com.group10.SchooManagementSystem.TeacherModule.PersonalController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class UsersController implements Initializable {

    @FXML
    private AnchorPane rootUserPane;

    @FXML
    private TextField searchTf;
    @FXML
    private TableView<UserData> userTable;

    @FXML
    private TableColumn<UserData, String> userIdCol,  nameCol, userTypeCol, emailIdCol, phoneNoCol;

    @FXML
    private ComboBox<UserTypes> searchCb;

    @FXML
    private ComboBox<SearchTypes> filterCb;

    private UsersModel usersModel;
    private ObservableList<UserData> userData;
    private PaneLoader paneLoader;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.usersModel = new UsersModel();
        paneLoader = new PaneLoader(this.rootUserPane);
        this.loadStudentData();

      //  this.searchCb.setItems(FXCollections.observableArrayList(UserTypes.values()));
        this.filterCb.setItems(FXCollections.observableArrayList(SearchTypes.values()));
    }

    public void loadAdd(ActionEvent event) {
        paneLoader.loadPane("/com/group10/SchooManagementSystem/AdminModule/add.fxml", false, null);
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
        this.userData = this.usersModel.getSearchData(searchTf.getText(),filterCb.getValue().toString());
        this.setUserTable(this.userData);

    }

    public void viewUser(ActionEvent event) throws IOException {
        UserData user = userTable.getSelectionModel().getSelectedItem();
        if(user == null){
            System.out.println("user does not exusts");
            return;
        }
        paneLoader.loadPane("/com/group10/SchooManagementSystem/AdminModule/add.fxml", true, user);


    }

    public  void editUser(ActionEvent event){
        UserData user = userTable.getSelectionModel().getSelectedItem();
        if(user == null){
            System.out.println("user does not ex");
        }
        System.out.println("user delete"+user.getUserId());

    }

    public void deleteUser(ActionEvent event) throws SQLException {

        UserData user = userTable.getSelectionModel().getSelectedItem();
        if(user == null){
            System.out.println("user does not ex");
        }else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Deleting book");
            alert.setContentText("Are you sure you want to delete user  " + user.getName() + "?");
            Optional<ButtonType> answer = alert.showAndWait();
            if(answer.get() == ButtonType.OK){
               usersModel.deleteUser(user);
            }
        }


    }

}
