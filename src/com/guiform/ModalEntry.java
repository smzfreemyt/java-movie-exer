package com.guiform;

import com.database.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ModalEntry extends JFrame {
    private JButton updateButton;
    private JButton deleteButton;
    private JTabbedPane tabbedPane1;
    private JPanel panelMain;
    private JTextField textUsername;
    private JTextField textPassword;
    private JTextField textFavorite;

    private GuiDisplay guiDisplay = new GuiDisplay();
    private User user = new User();
    private App app;

    private ResultSet rsData;

    public ModalEntry (ResultSet rs) throws SQLException {
        this.rsData = rs;
        this.initialize();
        this.populate();
        this.performActions();
    }

    public void performActions() {
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<String, Object> data = new HashMap<>();
                data.put("username", textUsername.getText());
                data.put("password", textPassword.getText());
                data.put("favorite_number", textFavorite.getText());
                try {
                    user.updateQuery(data, rsData.getInt(1));
                    JOptionPane.showMessageDialog(null, "Successfully Updated user!");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedId = (Integer) rsData.getInt(1);
                    user.delete(selectedId);
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(null, "Delete id #" + selectedId + "?", "Title on Box", dialogButton);
                    if(dialogResult == 0) {
                        user.delete(selectedId);
                        JOptionPane.showMessageDialog(null, "Deleted successfully!");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

    public void populate() throws SQLException {
        this.textUsername.setText(this.rsData.getString(2));
        this.textPassword.setText(this.rsData.getString(3));
        this.textFavorite.setText(this.rsData.getString(4));
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
