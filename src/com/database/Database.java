package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * June 4, 2021
 * @author Samuel Amador
 */
public class Database {
    private final String dbConn = "jdbc:mysql://localhost:3306/moviedb";
    private final String driver = "com.mysql.jdbc.Driver";
    private final String dbName = "root";
    private final String dbPass = "";
    private Connection conn;

    public Database() {
        try {
            Class.forName(this.driver);
            this.conn = DriverManager.getConnection(this.dbConn, this.dbName, this.dbPass);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void create(){
        try {
            PreparedStatement query = this.conn.prepareStatement("INSERT INTO movies(`title`,`details`,`favorite`)" +
                                                                     "VALUES(?, ?, ?)");
            query.setString(1, "This is title");
            query.setString(2, "This is details");
            query.setInt(3, 1);
            query.execute();
            System.out.println("Inserted Successfully");
        } catch (Exception e) {
            System.out.println("Error Insert : " + e);
        }
    }
}
