package com.group10.SchooManagementSystem.TeacherModule;

import com.group10.SchooManagementSystem.Data.Attendance;
import com.group10.SchooManagementSystem.Data.UserData;
import com.group10.SchooManagementSystem.databaseUtil.ConnectDb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class AttendanceModel {
    Connection connection;
    private ObservableList<Attendance> attendances;
    public AttendanceModel(){
        ConnectDb connectDb = new ConnectDb();
        this.connection = connectDb.getConnection();
    }

    @FXML
    public ObservableList<Attendance> loadStudentData(String date, String section, String grade, String id) {
        this.attendances = FXCollections.observableArrayList();
        System.out.println("Fsgsf");
        String sqlQuery = "SELECT name, userId FROM users INNER JOIN students ON users.userId=students.studentId and students.section = 'd' and  students.class = '6'";

        ResultSet resultSet = null;
        try {
            resultSet = (ResultSet) connection.createStatement().executeQuery(sqlQuery);
            while(resultSet.next()){
                System.out.println("Fsgsf");
                Attendance attendance = new Attendance(
                        date, resultSet.getString(2),
                        id, resultSet.getString(1));
                this.attendances.add(attendance);
//                addAttendance(attendance);
                System.out.println(date+ resultSet.getString(2)+
                        id+ resultSet.getString(1));

            }
            return this.attendances;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

    public void addAttendance(Attendance attendance) throws SQLException {
        if(uniqExists(attendance)){
            String sqlQuery = "INSERT INTO attendance (date, userId, status, giverId, name)\n" +
                    "VALUES (? , ?, ? , ?, ? );";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, attendance.getDate());
            preparedStatement.setString(2, attendance.getUserId());
            preparedStatement.setString(3, attendance.getStatus());
            preparedStatement.setString(4, attendance.getGiverId());
            preparedStatement.setString(5, attendance.getName());
            preparedStatement.execute();
        }

    }

    public Boolean uniqExists(Attendance attendance) throws SQLException {
        String sqlQuery = "SELECT If (Count(*) > 0 , TRUE, FALSE) from attendance WHERE attendance.date = ? \n" +
                "and attendance.userId = ?; ;";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, attendance.getDate());
        preparedStatement.setString(2, attendance.getUserId());
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString(1).equals("0");
    }



}
