package com.group10.SchooManagementSystem.TeacherModule;

import com.group10.SchooManagementSystem.Data.TeachersData;
import com.group10.SchooManagementSystem.Data.UserData;
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



    protected TeachersData getData() throws SQLException {
        PreparedStatement preparedStatement = null;
        String sqlQuery = "SELECT * \n" +
                "FROM users " +
                "INNER JOIN teachers\n" +
                "ON users.userId = teachers.teacherId where teachers.teacherId = ?;";
        preparedStatement = this.connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, this.userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
//        while(resultSet.next()){
//            System.out.println(resultSet.getString(1));
//        }
//        System.out.println(resultSet.getString("userId")+
//                resultSet.getString("name")+ resultSet.getString("mail")+
//                resultSet.getString("phone")+ resultSet.getString("usertype")+
//                resultSet.getString("class")+ resultSet.getString("section")+
//                resultSet.getString("department"));
            return new TeachersData(resultSet.getString(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4)
            ,resultSet.getString(9),resultSet.getString(8),resultSet.getString(10));
        }
//        protected TeachersData getPermissions(){
//
//        }

}

