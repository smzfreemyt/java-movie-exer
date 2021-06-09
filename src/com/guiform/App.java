package com.guiform;

import com.database.Movie;
import com.database.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App  extends JFrame {
    private JPanel panelMain;
    private JButton searchButton;
    private JTextField textSearchInput;
    private JLabel lblSearch;
    private JTable tableResult;
    private JTextField textUsername;
    private JTextField textPassword;
    private JTextField textFavorite;
    private JButton addUserButton;

    private ResultSet rs;
    private GuiDisplay guiDisplay = new GuiDisplay();
    private User user = new User();

    private int selectedId;

    public App(String title) {
        super(title);
        this.performListener();
    }

    public void performListener() {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String input = textSearchInput.getText();
                    if (!input.isEmpty()) {
                        rs = user.findByUsername(input);
                    } else {
                        rs = user.allUsers();
                    }
                    guiDisplay.showResultInJTable(rs, tableResult);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

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

        tableResult.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    int row = tableResult.getSelectedRow();
                    Object id = tableResult.getModel().getValueAt(row, 0);
                    ResultSet rs = user.findUser((Integer) id);
                    if (rs.next()) {
                        selectedId = rs.getInt(1);
                        new ModalEntry(selectedId);
                    }

                   /* ResultSet rs = user.findUser((Integer) id);
                    if (rs.next()) {
                        selectedId = rs.getInt(1);
                        int dialogButton = JOptionPane.YES_NO_OPTION;
                        int dialogResult = JOptionPane.showConfirmDialog(null, "Delete id #" + selectedId + "?", "Title on Box", dialogButton);
                        if(dialogResult == 0) {
                            user.delete(selectedId);
                            JOptionPane.showMessageDialog(null, "Deleted successfully");
                            guiDisplay.showResultInJTable(user.allUsers(), tableResult);
                        }
                    }*/
                } catch (Exception err) {
                    System.out.println("Error: " + err.getMessage());
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
