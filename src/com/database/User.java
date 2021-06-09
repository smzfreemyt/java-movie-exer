package com.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class User extends Database{
    private int id;
    private String password;
    private String username;
    private int favoriteNumber;

    protected final String TABLE_NAME = "users";
    private final ArrayList<String> fields = new ArrayList<>(
            Arrays.asList("username", "password", "favorite_number")
    );

    public User() {
        this.currentTable = TABLE_NAME;
    }

    public ResultSet allUsers () throws SQLException {
        this.setDefaultFields();
        return this.getResultQuery();
    }

    public void setDefaultFields() {
        this.tableClass.setSelectFields("id, username, password, favorite_number");
    }

    public void create(Object[] data){
        try {
            Map<Integer, Object> values = new HashMap<>();
            values.put(1, data[0]);
            values.put(2, data[1]);
            values.put(3, 3);
            this.insert(TABLE_NAME, this.fields, values);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
