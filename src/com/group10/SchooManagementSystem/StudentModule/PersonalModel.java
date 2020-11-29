package com.group10.SchooManagementSystem.StudentModule;

import com.group10.SchooManagementSystem.Data.StudentData;
import com.group10.SchooManagementSystem.Data.TeachersData;
import com.group10.SchooManagementSystem.databaseUtil.ConnectDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonalModel {
    Connection connection;
    private String userId;

    public PersonalModel(String userId){
        this.userId = userId;
        ConnectDb connectDb = new ConnectDb();
        this.connection = connectDb.getConnection();
    }

    protected StudentData getData() throws SQLException {
        PreparedStatement preparedStatement = null;
        String sqlQuery = "SELECT * \n" +
                "FROM users " +
                "INNER JOIN students\n" +
                "ON users.userId = students.studentId where students.studentId = ?;";
        preparedStatement = this.connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, this.userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new StudentData(resultSet.getString(1), resultSet.getString(2),
                resultSet.getString(3), resultSet.getString(4)
                ,resultSet.getString(8),resultSet.getString(9));
    }
}
