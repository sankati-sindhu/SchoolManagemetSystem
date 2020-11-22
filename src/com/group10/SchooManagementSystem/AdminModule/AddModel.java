package com.group10.SchooManagementSystem.AdminModule;

import com.group10.SchooManagementSystem.Data.StudentData;
import com.group10.SchooManagementSystem.Data.UserData;
import com.group10.SchooManagementSystem.databaseUtil.ConnectDb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddModel {
    Connection connection;

    public AddModel(){
        ConnectDb connectDb = new ConnectDb();
        this.connection = connectDb.getConnection();
    }

    public void addUser(UserData userData) throws SQLException {
        PreparedStatement preparedStatement;
        String sqlQuery = "Insert into users (userid, password, type, mail, phone, name) Values (?, ?, ?, ?, ?, ?) ;";
       // connection.createStatement().executeQuery(sqlQuery);
        preparedStatement = this.connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, userData.getUserId());
        preparedStatement.setString(2, "Frfs");
        preparedStatement.setString(3, userData.getUserType());
        preparedStatement.setString(4, userData.getMail());
        preparedStatement.setString(5, userData.getPhone());
        preparedStatement.setString(6, userData.getName());
        preparedStatement.execute();
        this.connection.close();
    }

    public void addStudent(StudentData studentData){
        PreparedStatement preparedStatement = null;
        String sqlQuery = "Insert into students (studentId, section, class) Values (?, ?, ?) ;";
        try {
            preparedStatement = this.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, studentData.getUserId());
            preparedStatement.setString(2, studentData.getSection());
            preparedStatement.setString(3, studentData.getGrade());
            preparedStatement.execute();
            addUser(studentData);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                this.connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
    public  void addTeacher(){

    }

    public void deleteUser(){

    }
    public void deleteStudent(){

    }
    public void deleteTeacher(){

    }

    public void updateUser(){

    }
    public void updateStudent(){

    }
}
