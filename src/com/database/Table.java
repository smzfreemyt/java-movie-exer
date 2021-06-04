package com.database;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Samuel Amador
 */
public class Table {

    private ArrayList<String> fields;
    private Map<Integer, Object> values;
    private String tblname;

    /**
     * @param fields
     * @param values
     */
    public Table(ArrayList<String> fields, Map<Integer, Object> values) {
        this.fields = fields;
        this.values = values;
    }

    /**
     * Overload with table name
     * @param fields
     * @param values
     * @param name
     */
    public Table(ArrayList<String> fields, Map<Integer, Object> values, String name) {
        this.fields = fields;
        this.values = values;
        this.tblname = name;
    }


    public String getFields() {
        return this.fields.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(","));
    }

    public String getValuesUnknown() {
        String result = "";
        for (String i: this.fields) {
            result += "?,";
        }
        return result.substring(0, result.length() - 1);
    }

}
