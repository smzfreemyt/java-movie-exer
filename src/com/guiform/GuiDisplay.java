package com.guiform;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Locale;

public class GuiDisplay extends JFrame {

    public void showResultInJTable(ResultSet rs, JTable table) {
        try {
            DefaultTableModel tableModel = new DefaultTableModel();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel.addColumn(metaData.getColumnLabel(columnIndex).toUpperCase(Locale.ROOT));
            }
            Object[] row = new Object[columnCount];
            while (rs.next()) {
                for (int i = 0; i < columnCount; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                tableModel.addRow(row);
            }
            table.setModel(tableModel);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
