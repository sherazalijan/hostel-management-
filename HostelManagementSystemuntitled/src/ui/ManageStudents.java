package ui;

import db.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ManageStudents {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Manage Students");
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 2));

        JLabel idLabel = new JLabel("Student ID:");
        JLabel nameLabel = new JLabel("Name:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel phoneLabel = new JLabel("Phone:");

        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField phoneField = new JTextField();

        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        frame.add(idLabel);
        frame.add(idField);

        frame.add(nameLabel);
        frame.add(nameField);

        frame.add(emailLabel);
        frame.add(emailField);

        frame.add(phoneLabel);
        frame.add(phoneField);

        frame.add(updateBtn);
        frame.add(deleteBtn);

        // UPDATE STUDENT
        updateBtn.addActionListener(e -> {

            try {
                Connection conn = DBConnection.connect();

                String query = "UPDATE Student SET name=?, email=?, phone=? WHERE student_id=?";

                PreparedStatement pst = conn.prepareStatement(query);

                pst.setString(1, nameField.getText());
                pst.setString(2, emailField.getText());
                pst.setString(3, phoneField.getText());
                pst.setInt(4, Integer.parseInt(idField.getText()));

                pst.executeUpdate();

                JOptionPane.showMessageDialog(frame, "Student Updated!");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // DELETE STUDENT
        deleteBtn.addActionListener(e -> {

            try {
                Connection conn = DBConnection.connect();

                String query = "DELETE FROM Student WHERE student_id=?";

                PreparedStatement pst = conn.prepareStatement(query);

                pst.setInt(1, Integer.parseInt(idField.getText()));

                pst.executeUpdate();

                JOptionPane.showMessageDialog(frame, "Student Deleted!");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        frame.setVisible(true);
    }
}