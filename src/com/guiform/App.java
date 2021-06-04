package com.guiform;

import com.database.Movie;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class App  extends JFrame {
    private JButton submitButton;
    private JPanel panelMain;
    private JTextField textSearchInput;
    private JLabel labelSearch;
    private JTabbedPane tabbedPane1;
    private JTable tableMovieList;

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

    public void start() {
        this.initialize();
        this.populate();
    }

    public void populate() {
//        DefaultTableModel model = new DefaultTableModel();
//        String[] columns = {"id", "Title", "Details"};
//        ArrayList<Object> all = this.movie.getAll();
//        model.addColumn(columns);
////        for (int rec=0; rec < all.size(); rec++) {
//        model.addRow(new Object[] {"Sam", "Amador", "test"});
////        }
//        tableMovieList.setModel(model);

        DefaultTableModel model = new DefaultTableModel(new Object[]{"Name","Symbol","Atomic Number"},0);
        Object[] rows = {"sam", "amador", "test"};
        Object[] row2 = {"second", "amador", "test"};
        model.addRow(rows);
        model.addRow(row2);
        tableMovieList.setModel(model);
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
