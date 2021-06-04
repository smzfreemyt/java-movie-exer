package com.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

/**
 * June 4, 2021
 * @author Samuel Amador
 */
abstract public class Database{
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String dbName = "moviedb";
    private static final String dbUser = "root";
    private static final String dbPass = "";
    private final String dbConn = "jdbc:mysql://localhost:3306/" + dbName;
    private PreparedStatement query;

    protected Connection conn;
    protected String currentTable;

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
    public ArrayList<Object> getAll() {
        try {
            ArrayList<Object> resultList = new ArrayList<>();
            query = this.conn.prepareStatement("select * from " + this.currentTable);
            ResultSet result = query.executeQuery();
            ResultSetMetaData meta = result.getMetaData();
            int totalColumn = meta.getColumnCount();
            while(result.next()) {
                ArrayList<Object> obj = new ArrayList<>();
                for (int x = 1; x < totalColumn; x++) {
                    obj.add(result.getObject(x));
                }
                resultList.add(obj);
            }
            return resultList;
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return null;
    }
}
