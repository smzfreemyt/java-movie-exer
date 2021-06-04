package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Map;

/**
 * June 4, 2021
 * @author Samuel Amador
 */
public class Database{
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String dbName = "moviedb";
    private static final String dbUser = "root";
    private static final String dbPass = "";
    private final String dbConn = "jdbc:mysql://localhost:3306/" + dbName;
    protected Connection conn;

    /**
     * Constructor
     */
    public Database() {
        try {
            Class.forName(driver);
            this.conn = DriverManager.getConnection(this.dbConn, dbUser, dbPass);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    /**
     * Insert into Table
     * @param table
     * @param fields
     * @param values
     */
    public void insert(String table, ArrayList<String> fields, Map<Integer, Object> values)
    {
        try {
            Table tbl = new Table(fields, values);
            PreparedStatement query = this.conn.prepareStatement("INSERT INTO " + table +
                    "("+ tbl.getFields() + ")" +
                    "VALUES(" + tbl.getValuesUnknown() + ")");
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
