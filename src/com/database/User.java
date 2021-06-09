package com.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User extends Database{
    private int id;
    private String password;
    private String username;
    private int favoriteNumber;

    protected final String TABLE_NAME = "users";

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
}
