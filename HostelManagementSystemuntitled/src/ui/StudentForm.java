package ui;

import db.ManageStudentDAO;
import models.Student;

import javax.swing.*;
import java.awt.*;

public class StudentForm {

    public StudentForm() {

        JFrame frame = new JFrame("Student Management");
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 2));
        frame.setLocationRelativeTo(null);

        JLabel nameLabel = new JLabel("Name:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel phoneLabel = new JLabel("Phone:");

        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField phoneField = new JTextField();

        JButton addBtn = new JButton("Add Student");
        JButton viewBtn = new JButton("View All Students");

        // Layout
        frame.add(nameLabel);
        frame.add(nameField);

        frame.add(emailLabel);
        frame.add(emailField);

        frame.add(phoneLabel);
        frame.add(phoneField);

        frame.add(addBtn);
        frame.add(viewBtn);

        // ADD STUDENT
        addBtn.addActionListener(e -> {

            try {
                Student s = new Student(
                        nameField.getText(),
                        emailField.getText(),
                        phoneField.getText()
                );

                ManageStudentDAO.addStudent(s);

                JOptionPane.showMessageDialog(frame, "Student Added ✅");

                nameField.setText("");
                emailField.setText("");
                phoneField.setText("");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // 🔥 VIEW STUDENTS BUTTON
        viewBtn.addActionListener(e -> {
            new ViewStudents(); // opens table
        });

        frame.setVisible(true);
    }
}