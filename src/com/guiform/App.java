package com.guiform;

import com.database.Movie;
import com.database.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App  extends JFrame {
    private JPanel panelMain;
    private JButton submitButton;
    private JTextField textSearchInput;
    private JLabel lblSearch;
    private JTable tableResult;
    private JTextField textUsername;
    private JTextField textPassword;
    private JTextField textFavorite;
    private JButton addUserButton;

    private GuiDisplay guiDisplay = new GuiDisplay();
    private User user = new User();

    private int selectedId;

    public App(String title) {
        super(title);
        this.performListener();
    }

    public void performListener() {
        addUserButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] data = {textUsername.getText(), textPassword.getText(), textFavorite.getText()};
                user.create(data);
                JOptionPane.showMessageDialog(null, "Successfully added!");
                try {
                    guiDisplay.showResultInJTable(user.allUsers(), tableResult);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

    public void start() throws SQLException {
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(700, 500));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // mas maayu nga naay padding
        panelMain.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        // initialize JTable display
        this.guiDisplay.showResultInJTable(this.user.allUsers(), this.tableResult);
    }
}
