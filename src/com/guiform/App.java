package com.guiform;

import com.database.Movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App  extends JFrame {
    private JPanel panelMain;
    private JButton submitButton;
    private JTextField textSearchInput;
    private JLabel labelSearch;
    private JTabbedPane tabbedPane1;
    private JTable tableResult;

    private Movie movie = new Movie();
    private GuiDisplay guiDisplay = new GuiDisplay();

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
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(700, 500));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        panelMain.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        this.guiDisplay.showResultInJTable(this.movie.getAll(), this.tableResult);
    }
}
