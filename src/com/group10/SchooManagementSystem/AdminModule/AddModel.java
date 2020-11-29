package com.group10.SchooManagementSystem.AdminModule;

import com.group10.SchooManagementSystem.Data.StudentData;
import com.group10.SchooManagementSystem.Data.TeachersData;
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
        String sqlQuery = "INSERT INTO users (userId, name, \n" +
                "mail, phone, usertype, password)\n" +
                "VALUES (?, ?, ?, ?, ?, ? );";
       // connection.createStatement().executeQuery(sqlQuery);
        preparedStatement = this.connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, userData.getUserId());
        preparedStatement.setString(2, userData.getName());
        preparedStatement.setString(3, userData.getMail());
        preparedStatement.setString(4, userData.getPhone());
        preparedStatement.setString(5, userData.getUserType());
        preparedStatement.setString(6, userData.getUserId()+"@"+userData.getName());
        preparedStatement.execute();
//        this.connection.close();
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
        }

    }
    public  void addTeacher(TeachersData teachersData){
        PreparedStatement preparedStatement = null;
        String sqlQuery = "Insert into teachers (teacherId, section, class, department) Values (?, ?, ?, ?) ;";
        try {
            preparedStatement = this.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, teachersData.getUserId());
            preparedStatement.setString(2, teachersData.getSection());
            preparedStatement.setString(3, teachersData.getGrade());
            preparedStatement.setString(4, teachersData.getDepartment());
            preparedStatement.execute();
            addUser(teachersData);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        finally {
//            try {
//                this.connection.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }

    }
    public void  addPermission(String userId, String grade, String section){
        PreparedStatement preparedStatement = null;
        String sqlQuery = "Insert into permissions (userId, section, class) Values (?, ?, ?) ;";
        try {
            preparedStatement = this.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, section);
            preparedStatement.setString(3, grade);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        finally {
//            try {
//                this.connection.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }

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
