package com.guiform;

import com.database.Movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class App  extends JFrame {
    private JPanel panelMain;
    private JButton submitButton;
    private JTextField textSearchInput;
    private JLabel labelSearch;
    private JTable tableResult;
    private JComboBox comboFavorite;
    private JLabel labelDetails;
    private JButton buttonInsert;
    private JButton buttonFavorite;

    private Movie movie = new Movie();
    private GuiDisplay guiDisplay = new GuiDisplay();

    private int selectedId;


    public App(String title) {
        super(title);
        this.activateListeners();
    }

    public void activateListeners() {
        buttonFavorite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movie.addToFavorite(selectedId);
                JOptionPane.showMessageDialog(null, "Added to favorite!");
                ResultSet rs = movie.searchTitle(textSearchInput.getText(), null);
                guiDisplay.showResultInJTable(rs, tableResult);
            }
        });
        buttonInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movie.create();
                JOptionPane.showMessageDialog(null, "Successfully added Automatically!");
                ResultSet rs = movie.searchTitle(textSearchInput.getText(), null);
                guiDisplay.showResultInJTable(rs, tableResult);
            }
        });
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

        tableResult.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    int row = tableResult.getSelectedRow();
                    Object id = tableResult.getModel().getValueAt(row, 0);
                    ResultSet rs = movie.findMovie((Integer) id);
                    if (rs.next()) {
                        panelMain.setLayout(null);
                        Dimension size = labelDetails.getPreferredSize();
                        labelDetails.setBounds(100, 100, 400, 400);
                        labelDetails.setText(rs.getString(3));
                        String isFav = rs.getString(4);
                        selectedId = rs.getInt(1);
                        System.out.println(selectedId);
                        if (isFav.equals("No")) {
                            buttonFavorite.setText("Add to Favorite");
                            buttonFavorite.setVisible(true);
                        } else {
                            buttonFavorite.setVisible(false);
                        }
                    }
                } catch (Exception error) {
                    System.out.println("Error" + error.getMessage());
                }
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

        buttonFavorite.setVisible(false);

        // initialize JTable display
        this.guiDisplay.showResultInJTable(this.movie.allMovies(), this.tableResult);
    }
}
