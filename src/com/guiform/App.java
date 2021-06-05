package com.guiform;

import com.database.Movie;
import javafx.scene.SnapshotParametersBuilder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class App  extends JFrame {
    private JButton submitButton;
    private JPanel panelMain;
    private JTextField textSearchInput;
    private JLabel labelSearch;
    private JTabbedPane tabbedPane1;
    private JTable tableResult;

    private Movie movie = new Movie();

    public App(String title) {
        super(title);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textSearchInput.getText());
            }
        });
    }

    public void start(){
        this.initialize();
        this.populate(this.movie.getAll(), this.tableResult);
    }


    public void populate(ResultSet rs, JTable table){
        try {
            DefaultTableModel tableModel = new DefaultTableModel();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel.addColumn(metaData.getColumnLabel(columnIndex));
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

    public void initialize() {
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(700, 500));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        panelMain.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
    }

}
