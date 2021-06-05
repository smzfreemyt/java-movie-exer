package com.guiform;

import com.database.Movie;
import javafx.scene.SnapshotParametersBuilder;

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

    public void start() {
        this.initialize();
        this.populate();
    }

    public void populate() {
        String[] headers = { "col1", "col2"};
        String[] data = { "AA", "BB", "CC", "DD", "EE", "FF", "GG", "HH", "II", "JJ",
                "KK", "LL", "MM", "NN", "OO", "PP", "QQ", "RR" };
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(headers);

        ArrayList<String> ar = new ArrayList<String>();
        for (int i = 0; i < data.length; i++) {
            ar.add(data[i]);
        }

        for (int i = 0; i < (ar.size() / 2); i++) {
            model.addRow(new Object[] { String.valueOf(ar.get(2 * i)),
                    String.valueOf(ar.get((2 * i) + 1)) });
        }

        tableResult.setModel(model);
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
