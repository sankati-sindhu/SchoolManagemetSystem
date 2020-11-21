package com.group10.SchooManagementSystem.LoginModule;

import com.group10.SchooManagementSystem.databaseUtil.ConnectDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    Connection connection;
    public LoginModel(){
        ConnectDb connectDb = new ConnectDb();
        this.connection = connectDb.getConnection();
    }

    public boolean isConnected(){
        return this.connection!=null;
    }
    public boolean isLogin(String userId, String password, String type) throws Exception{
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sqlQuery = "SELECT * FROM users where userid = ? and password = ? and type = ?";
        try{
            preparedStatement = this.connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, type);
            resultSet = preparedStatement.executeQuery();

            Boolean bool;
            if(resultSet.next()){
                return true;
            }else {
                return false;
            }

        }catch (SQLException ex){
            return false;
        }
        finally {
            preparedStatement.close();
            resultSet.close();
        }



    }
}
