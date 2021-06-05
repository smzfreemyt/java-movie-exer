package com.database;

import java.util.*;

/**
 * @author Samuel Amador
 */
public class Movie extends Database{

    protected final String TABLE_NAME = "movies";
    private int id;
    private String title;

    private final ArrayList<String>  fields = new ArrayList<>(
            Arrays.asList("title", "details", "favorite")
    );

    public Movie() {
        this.currentTable = TABLE_NAME;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void create(){
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, "This is a title movie");
        values.put(2, "Another details");
        values.put(3, 1);
        this.insert("movies", this.fields, values);
    }

    public List<Object> search() {
        this.tableClass.where("id", "=", 2);
        return this.getAll();
    }
}
