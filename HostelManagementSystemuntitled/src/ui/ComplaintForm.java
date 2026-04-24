package ui;

import db.ComplaintDAO;

import javax.swing.*;
import java.awt.*;

public class ComplaintForm {

    public ComplaintForm() {

        JFrame frame = new JFrame("Complaint Module");
        frame.setSize(400, 250);
        frame.setLayout(new GridLayout(3, 2));

        JLabel idLabel = new JLabel("Student ID:");
        JLabel descLabel = new JLabel("Complaint:");

        JTextField idField = new JTextField();
        JTextArea descArea = new JTextArea();

        JButton submitBtn = new JButton("Submit");

        frame.add(idLabel);
        frame.add(idField);

        frame.add(descLabel);
        frame.add(descArea);

        frame.add(new JLabel());
        frame.add(submitBtn);

        submitBtn.addActionListener(e -> {

            int id = Integer.parseInt(idField.getText());
            String desc = descArea.getText();

            ComplaintDAO.addComplaint(id, desc);

            JOptionPane.showMessageDialog(frame, "Complaint Submitted 📝");

            idField.setText("");
            descArea.setText("");
        });

        frame.setVisible(true);
    }
}