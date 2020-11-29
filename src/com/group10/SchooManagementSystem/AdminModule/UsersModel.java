package com.group10.SchooManagementSystem.AdminModule;

import com.group10.SchooManagementSystem.Data.StudentData;
import com.group10.SchooManagementSystem.Data.TeachersData;
import com.group10.SchooManagementSystem.Data.UserData;
import com.group10.SchooManagementSystem.databaseUtil.ConnectDb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersModel {


    Connection connection;
    private ObservableList<UserData> userData;
    public UsersModel(){
        ConnectDb connectDb = new ConnectDb();
        this.userData = FXCollections.observableArrayList();
        this.connection = connectDb.getConnection();
    }

    @FXML
    public ObservableList<UserData> loadStudentData() {
        this.userData = FXCollections.observableArrayList();
        String sqlQuery = "SELECT * FROM users";
        ResultSet resultSet = null;
        try {
            resultSet = (ResultSet) connection.createStatement().executeQuery(sqlQuery);
            while(resultSet.next()){
                this.userData.add(new UserData(
                        resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5)));
            }
            return this.userData;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

    @FXML
    public ObservableList<UserData> getSearchData(String by,String byOpt){
        this.userData = FXCollections.observableArrayList();

        String sqlQuery;
        if(byOpt.equals("userId")){
             sqlQuery = "SELECT * FROM users Where userId = ?";
        }else{
             sqlQuery = "SELECT * FROM users Where name = ?";
        }
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement = this.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, by);
//            preparedStatement.setString(2, by);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                this.userData.add(new UserData(
                        resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5)));
//                System.out.println(resultSet.getString(1)+ resultSet.getString(7)+
//                        resultSet.getString(4)+ resultSet.getString(5)+
//                        resultSet.getString(6)+ resultSet.getString(3));

            }

            return this.userData;

        } catch (SQLException throwables) {

            throwables.printStackTrace();
            return null;
        }
    }

    public void deleteUser(UserData userData) throws SQLException {
        PreparedStatement preparedStatement;
        String sqlQuery = "Delete from users  where userId = ?";
        // connection.createStatement().executeQuery(sqlQuery);
        preparedStatement = this.connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, userData.getUserId());
        preparedStatement.execute();

    }


}
