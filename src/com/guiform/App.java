package com.guiform;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App  extends JFrame {
    private JButton submitButton;
    private JPanel panelMain;
    private JTextField textSearchInput;
    private JLabel labelSearch;
    private JList list1;
    private JTextField textSearch;
    private JTabbedPane tabbedPane1;
    private JTable tableList;

    public App(String title) {
        super(title);
        this.initialize();

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textSearchInput.getText());
            }
        });
    }

    public void initialize() {
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(600, 500));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        panelMain.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
    }

}
