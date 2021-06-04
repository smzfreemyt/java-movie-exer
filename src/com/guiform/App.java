package com.guiform;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JButton submitButton;
    private JPanel panelMain;

    public App() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "wow");
            }
        });
    }

    public JPanel getPanelMain() {
        return panelMain;
    }
}
