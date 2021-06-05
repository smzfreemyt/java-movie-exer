package com.guiform;

import com.database.Movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class App  extends JFrame {
    private JPanel panelMain;
    private JButton submitButton;
    private JTextField textSearchInput;
    private JLabel labelSearch;
    private JTabbedPane tabbedPane1;
    private JTable tableResult;
    private JComboBox comboFavorite;

    private Movie movie = new Movie();
    private GuiDisplay guiDisplay = new GuiDisplay();

    public App(String title) {
        super(title);
        this.activateListeners();
    }

    public void activateListeners() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = comboFavorite.getSelectedIndex();
                String fav = null;
                if (num > 0) {
                    fav = (num == 1) ? "Yes" : "No";
                }
                ResultSet rs = movie.searchTitle(textSearchInput.getText(), fav);
                guiDisplay.showResultInJTable(rs, tableResult);
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

        // mas maayu nga naay padding
        panelMain.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        // Unsa ni? :D :D
        comboFavorite.addItem("All");
        comboFavorite.addItem("Yes");
        comboFavorite.addItem("No");

        // initialize JTable display
        this.guiDisplay.showResultInJTable(this.movie.allMovies(), this.tableResult);
    }
}
