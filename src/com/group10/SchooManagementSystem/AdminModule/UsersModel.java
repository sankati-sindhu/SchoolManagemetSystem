package com.group10.SchooManagementSystem.AdminModule;

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
                        resultSet.getString(1), resultSet.getString(7),
                        resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6), resultSet.getString(3)));
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

    @FXML
    public ObservableList<UserData> getSearchData(String by,String byOpt, String typeOpt){
        this.userData = FXCollections.observableArrayList();
        String sqlQuery = "SELECT * FROM users";
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.connection.prepareStatement(sqlQuery);
            //preparedStatement.setString(1, typeOpt);
            //preparedStatement.setString(2, String.valueOf(byOpt));
            //preparedStatement.setString(3, typeOpt);
            resultSet = preparedStatement.executeQuery();
            //resultSet = (ResultSet) connection.createStatement().executeQuery(sqlQuery);
            while(resultSet.next()){
                this.userData.add(new UserData(
                        resultSet.getString(1), resultSet.getString(7),
                        resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6), resultSet.getString(3)));
                System.out.println(resultSet.getString(1)+ resultSet.getString(7)+
                        resultSet.getString(4)+ resultSet.getString(5)+
                        resultSet.getString(6)+ resultSet.getString(3));

            }

            return this.userData;

        } catch (SQLException throwables) {

            throwables.printStackTrace();
            return null;
        }
    }

}
