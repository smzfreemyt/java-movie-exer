package com.guiform;

import javax.swing.*;
import java.awt.*;

public class App  extends JFrame {
    private JButton submitButton;
    private JPanel panelMain;
    private JTextField textField1;
    private JLabel labelSearch;

    public App(String title) {
        super(title);
        this.initialize();
    }

    public void initialize() {
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(600, 300));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
