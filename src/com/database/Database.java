package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * June 4, 2021
 * @author Samuel Amador
 */
public class Database{
    private final String dbConn = "jdbc:mysql://localhost:3306/moviedb";
    private final String driver = "com.mysql.jdbc.Driver";
    private final String dbName = "root";
    private final String dbPass = "";
    protected Connection conn;

    public Database() {
        try {
            Class.forName(this.driver);
            this.conn = DriverManager.getConnection(this.dbConn, this.dbName, this.dbPass);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void insert(String table, String[] fields, Map<Integer, Object> values)
    {
        try {
            PreparedStatement query = this.conn.prepareStatement("INSERT INTO " + table +"(`title`,`details`,`favorite`)" +
                    "VALUES(?, ?, ?)");
            for (Integer i: values.keySet()) {
                query.setObject(i, values.get(i));
            }
            query.execute();
            System.out.println("Inserted Successfully");
        } catch (Exception e) {
            System.out.println("Error Insert : " + e);
        }
    }

}
