package com.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private final String dbConn = "jdbc:mysql://localhost:3306/moviedb";
    private final String driver = "com.mysql.jdbc.Driver";
    private final String dbName = "root";
    private final String dbPass = "";

    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(this.driver);
            con = DriverManager.getConnection(this.dbConn, this.dbName, this.dbPass);
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}
