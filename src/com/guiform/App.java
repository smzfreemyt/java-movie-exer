package com.guiform;

import com.database.Movie;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
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
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID","Movie Title","Details"},0);
        model.addRow(new Object[] {"wow", "this", "test"});
        ArrayList<Object> obj = this.movie.getAll();
        int total = obj.size();
        for (int x=0; x < total; x ++) {
            Object[] data = obj.toArray();
            Object[] row = {data[0], data[1], data[2]};
            model.addRow(row);
        }
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
