package com.group10.SchooManagementSystem.databaseUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDb {

    private static Connection connection = null;
    String dataBaseName = "mydb";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "yourpassword";

    public Connection getConnection()  {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(URL+this.dataBaseName, USERNAME, PASSWORD);
            return connection;
        }catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        if(connection == null){
            System.exit(1);
        }
        return connection;
    }

}
