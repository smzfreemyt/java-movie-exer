package com.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @author Samuel Amador
 */
public class Movie extends Database{

    protected final String TABLE_NAME = "movies";
    private final ArrayList<String>  fields = new ArrayList<>(
            Arrays.asList("title", "details", "favorite")
    );
    private Object[] autoTitle = {"Automatic Movie title", "Another Automatic Added", "More Added title", "The Lion King", "The Lion Queen", "Zumba"};
    private Object[] autoDetail = {"Automatic details added", "Another details automatic", "More details automatic",
                                    "Come and see new detail", "What did you add?", "Automatic added!"};

    public Movie() {
        this.currentTable = TABLE_NAME;
    }

    public void create(){
        try {
            Map<Integer, Object> values = new HashMap<>();
            Random rand = new Random();
            int ctrDetail = rand.nextInt(autoDetail.length) ;
            int ctrTitle = rand.nextInt(autoTitle.length);
            values.put(1, autoTitle[ctrTitle]);
            values.put(2, autoDetail[ctrDetail]);
            values.put(3, "Yes");
            System.out.println("movie??");
            this.insert("movies", this.fields, values);
        } catch (Exception e) {
            System.out.println("Error Movie create: " + e.getMessage());
        }
    }

    public void setDefaultFields() {
        this.tableClass.setSelectFields("id, title, favorite");
    }

    public ResultSet allMovies () throws SQLException {
        this.setDefaultFields();
        return this.getResultQuery();
    }

    public ResultSet searchTitle(String text, String fav) throws SQLException {
        this.setDefaultFields();
        if (fav != null) {
            this.tableClass.setWhere("favorite", "=", "'" + fav + "'");
        }
        this.tableClass.setWhere("title", "LIKE", "'%" + text + "%'"); // no security yet. Will update when there is enough time.
        return this.getResultQuery();
    }

    public ResultSet findMovie(int id) throws SQLException {
        this.tableClass.setSelectFields("id, title, details, favorite");
        this.tableClass.setWhere("id", "=", id);
        return this.getResultQuery();
    }

    public void addToFavorite(int id) throws  SQLException{
        this.updateQuery("favorite='Yes'", id);
    }
}
