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
    private String name = "";
    private String whereStr = "";

    /**
     * Empty constructor
     */
    public Table() {}

    /**
     * @param fields
     * @param val
     */
    public Table(ArrayList<String> fields, Map<Integer, Object> val) {
        this.fields = fields;
        this.values = val;
    }

    /**
     * @return field1, field2, field3
     */
    public String getFields() {
        return this.fields.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(","));
    }

    /**
     * @return ?,?,?
     */
    public String getValuesUnknown() {
        String result = "";
        for (String i: this.fields) {
            result += "?,";
        }
        return result.substring(0, result.length() - 1);
    }

    /**
     * Can do where chaining. No security added YET. Will do later when there is time.
     * @return
     */
    public Table where(String field, String operator, Object value) {
        this.whereStr += field + operator + value;
        return this;
    }

    public String getWhere() {
        if (!this.whereStr.isEmpty()) {
            return " where " + this.whereStr;
        }
        return "";
    }

}
