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
    private static final String DB_NAME = "jdbcexerdb";
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
    public void insert(String table, ArrayList<String> fields, Map<Integer, Object> values) throws SQLException {
        try {
            Table tbl = new Table(fields, values);
            this.conn.setAutoCommit(false);
            query = this.conn.prepareStatement("INSERT INTO " + table +
                    "("+ tbl.getFields() + ")" +
                    "VALUES(" + tbl.getValuesUnknown() + ")");
            for (Integer i: values.keySet()) {
                query.setObject(i, values.get(i));
            }
            query.execute();
            this.conn.commit(); //execute
            System.out.println("Inserted Successfully");
        } catch (SQLException e) {
            if (this.conn != null) {
                this.conn.rollback();
            }
            System.out.println("Error Insert : " + e.getMessage());
        }
    }

    /**
     * Return record from the database
     * @return ArrayList
     */
    public ResultSet getResultQuery() {
        try {
            String select = "select " + this.tableClass.getSelect() +" from ";
            String table = select.concat(this.currentTable);
            String sql   = table.concat(this.tableClass.getWhere());
            System.out.println(sql);
            query = this.conn.prepareStatement(sql);
            ResultSet result = query.executeQuery();
            this.tableClass.resetCustomQuery();
            return result;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        return null;
    }

    public void updateQuery(String data, int id) throws SQLException {
        try {
            String sql = "Update " + this.currentTable + " SET " + data + " WHERE id=" + id;
            this.conn.setAutoCommit(false);
            query = this.conn.prepareStatement(sql);
            query.execute();
            query.close();
            this.conn.commit();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
            if (this.conn != null) {
                this.conn.rollback();
            }
        }
    }

    public void delete(int id) {
        try {
            String sql = "Delete from " + this.currentTable + " where id=" + id;
            query = this.conn.prepareStatement(sql);
            query.execute();
            query.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
