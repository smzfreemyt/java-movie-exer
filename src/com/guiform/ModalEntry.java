package com.guiform;

import javax.swing.*;
import java.awt.*;

public class ModalEntry extends JFrame {
    private JButton updateButton;
    private JButton deleteButton;
    private JTabbedPane tabbedPane1;
    private JPanel panelMain;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public ModalEntry (int id){
        this.initialize();
    }

    public void initialize() {
        this.setTitle("User Details");
        this.setContentPane(panelMain);
        this.setPreferredSize(new Dimension(500, 400));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // mas maayu nga naay padding
        panelMain.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
    }

}
