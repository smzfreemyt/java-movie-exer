package com.database;

import java.sql.ResultSet;
import java.util.*;

/**
 * @author Samuel Amador
 */
public class Movie extends Database{

    protected final String TABLE_NAME = "movies";
    private final ArrayList<String>  fields = new ArrayList<>(
            Arrays.asList("title", "details", "favorite")
    );

    public Movie() {
        this.currentTable = TABLE_NAME;
    }

    public void create(){
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, "This is a title movie");
        values.put(2, "Another details");
        values.put(3, 1);
        this.insert("movies", this.fields, values);
    }

    public void setDefaultFields() {
        this.tableClass.setSelectFields("id, title, favorite");
    }

    public ResultSet allMovies () {
        this.setDefaultFields();
        return this.getResultQuery();
    }

    public ResultSet searchTitle(String text, String fav) {
        this.setDefaultFields();
        if (fav != null) {
            this.tableClass.setWhere("favorite", "=", "'" + fav + "'");
        }
        this.tableClass.setWhere("title", "LIKE", "'%" + text + "%'"); // no security yet. Will update when there is enough time.
        return this.getResultQuery();
    }
}
