package com.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    public ArrayList<Object> search() {
        this.tableClass.where("id", "=", 10);
        return this.getAll();
    }
}
