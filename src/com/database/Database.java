package com.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

/**
 * June 4, 2021
 * @author Samuel Amador
 */
abstract public class Database {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_NAME = "moviedb";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";
    private static final String DB_CONN = "jdbc:mysql://localhost:3306/" + DB_NAME;
    private PreparedStatement query;

    protected Connection conn;
    protected String currentTable;
    protected Table tableClass = new Table();

    /**
     * Constructor
     */
    public Database() {
        try {
            Class.forName(DRIVER);
            this.conn = DriverManager.getConnection(DB_CONN, DB_USER, DB_PASS);
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
            query = this.conn.prepareStatement("INSERT INTO " + table +
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

    /**
     * Return record from the database
     * @return ArrayList
     */
    public ResultSet getResultQuery() {
        System.out.println(this.tableClass.getWhere());
        try {
            query = this.conn.prepareStatement("select " + this.tableClass.getSelect() +" from " +
                    this.currentTable + this.tableClass.getWhere());
            ResultSet result = query.executeQuery();
            this.tableClass.resetWhere();
            return result;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        return null;
    }

}
