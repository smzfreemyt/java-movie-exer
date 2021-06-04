package com.database;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class Movie extends Database{

    private String[] fields = {"title", "details", "favorite"};

    public void create(){
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, "This is a title");
        values.put(2, "Another details");
        values.put(3, 1);
        this.insert("movies", this.fields, values);
    }
}
