package com.group10.SchooManagementSystem.AdminModule;

import com.group10.SchooManagementSystem.Data.*;
import com.group10.SchooManagementSystem.databaseUtil.ConnectDb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML
    private TextField searchTf;

    @FXML
    private ComboBox<UserTypes> searchCb;

    @FXML
    private ComboBox<FilterTypes> filterCb;

    @FXML
    private Button searchBt;

    @FXML
    private TableView<UserData> userTable;

    @FXML
    private TableColumn<UserData, String> userIdCol;

    @FXML
    private TableColumn<UserData, String> nameCol;

    @FXML
    private TableColumn<UserData, String> userTypeCol;

    @FXML
    private TableColumn<UserData, String> emailIdCol;

    @FXML
    private TableColumn<UserData, String> phoneNoCol;

    private ConnectDb db;
    private ObservableList<UserData> userData;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.db = new ConnectDb();


    }

    @FXML
    public void loadStudentData(javafx.event.ActionEvent event) {
        Connection connection = db.getConnection();
        this.userData = FXCollections.observableArrayList();
        String sqlQuery = "SELECT * FROM users";
        try {
            ResultSet resultSet = (ResultSet) connection.createStatement().executeQuery(sqlQuery);
            while(resultSet.next()){
                this.userData.add(new UserData(
                        resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        this.userIdCol.setCellValueFactory(new PropertyValueFactory<UserData, String>("userId"));
        this.nameCol.setCellValueFactory(new PropertyValueFactory<UserData, String>("name"));
        this.userTypeCol.setCellValueFactory(new PropertyValueFactory<UserData, String>("userType"));
        this.emailIdCol.setCellValueFactory(new PropertyValueFactory<UserData, String>("mail"));
        this.phoneNoCol.setCellValueFactory(new PropertyValueFactory<UserData, String>("phone"));

        this.userTable.setItems(null);
        this.userTable.setItems(this.userData);

    }
}
