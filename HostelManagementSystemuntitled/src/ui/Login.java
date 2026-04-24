package ui;

import db.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Admin Login");
        frame.setSize(450, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(44, 62, 80));

        JLabel title = new JLabel("LOGIN");
        title.setBounds(190, 20, 200, 30);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(80, 80, 100, 25);
        userLabel.setForeground(Color.WHITE);

        JTextField userField = new JTextField();
        userField.setBounds(170, 80, 180, 25);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(80, 120, 100, 25);
        passLabel.setForeground(Color.WHITE);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(170, 120, 180, 25);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(170, 170, 100, 30);
        loginBtn.setBackground(new Color(52, 152, 219));
        loginBtn.setForeground(Color.WHITE);

        panel.add(title);
        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(loginBtn);

        loginBtn.addActionListener(e -> {

            try {
                Connection conn = DBConnection.connect();

                String query = "SELECT * FROM Admin WHERE username=? AND password=?";

                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1, userField.getText());
                pst.setString(2, new String(passField.getPassword()));

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(frame, "Login Successful 🚀");
                    new Dashboard();
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Login ❌");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}