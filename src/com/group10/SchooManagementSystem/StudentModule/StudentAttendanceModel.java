package com.group10.SchooManagementSystem.StudentModule;

import com.group10.SchooManagementSystem.Data.Attendance;
import com.group10.SchooManagementSystem.Data.StudentData;
import com.group10.SchooManagementSystem.Data.UserData;
import com.group10.SchooManagementSystem.databaseUtil.ConnectDb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentAttendanceModel {
    Connection connection;
    private ObservableList<Attendance> attendances;
    public StudentAttendanceModel(){
        ConnectDb connectDb = new ConnectDb();
        this.attendances = FXCollections.observableArrayList();
        this.connection = connectDb.getConnection();
    }

    @FXML
    public ObservableList<Attendance> loadAttendance(StudentData studentData) throws SQLException {
        this.attendances = FXCollections.observableArrayList();
        String sqlQuery = "SELECT * FROM attendance where userId = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, studentData.getUserId());
        ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();;
            while(resultSet.next()){
                this.attendances.add(new Attendance(
                        resultSet.getString(2), resultSet.getString(1),
                        resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(3)));
            }
            return this.attendances;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

}
