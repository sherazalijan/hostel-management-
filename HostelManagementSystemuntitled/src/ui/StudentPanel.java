package ui;

import db.ManageStudentDAO;
import models.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class StudentPanel {

    DefaultTableModel model;
    JTable table;

    JTextField idField, nameField, emailField, phoneField;

    public StudentPanel() {

        JFrame frame = new JFrame("Student Management Panel");
        frame.setSize(700, 500);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        // ===== TOP FORM =====
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        idField = new JTextField();
        nameField = new JTextField();
        emailField = new JTextField();
        phoneField = new JTextField();

        formPanel.add(new JLabel("ID:"));
        formPanel.add(idField);

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);

        formPanel.add(new JLabel("Phone:"));
        formPanel.add(phoneField);

        // ===== BUTTONS =====
        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        formPanel.add(addBtn);
        formPanel.add(updateBtn);

        // ===== TABLE =====
        String[] cols = {"ID", "Name", "Email", "Phone"};
        model = new DefaultTableModel(cols, 0);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        // ===== DELETE BUTTON BELOW =====
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(deleteBtn);

        // ===== ADD TO FRAME =====
        frame.add(formPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // ===== LOAD DATA =====
        loadTable();

        // ===== TABLE CLICK (AUTO FILL) =====
        table.getSelectionModel().addListSelectionListener(e -> {

            int row = table.getSelectedRow();

            if (row >= 0) {
                idField.setText(model.getValueAt(row, 0).toString());
                nameField.setText(model.getValueAt(row, 1).toString());
                emailField.setText(model.getValueAt(row, 2).toString());
                phoneField.setText(model.getValueAt(row, 3).toString());
            }
        });

        // ===== ADD =====
        addBtn.addActionListener(e -> {

            Student s = new Student(
                    nameField.getText(),
                    emailField.getText(),
                    phoneField.getText()
            );

            ManageStudentDAO.addStudent(s);
            refresh();
        });

        // ===== UPDATE =====
        updateBtn.addActionListener(e -> {

            Student s = new Student(
                    Integer.parseInt(idField.getText()),
                    nameField.getText(),
                    emailField.getText(),
                    phoneField.getText(),
                    null
            );

            ManageStudentDAO.updateStudent(s);
            refresh();
        });

        // ===== DELETE =====
        deleteBtn.addActionListener(e -> {

            int id = Integer.parseInt(idField.getText());

            ManageStudentDAO.deleteStudent(id);
            refresh();
        });

        frame.setVisible(true);
    }

    // LOAD DATA INTO TABLE
    public void loadTable() {

        model.setRowCount(0);

        List<Student> list = ManageStudentDAO.getAllStudents();

        for (Student s : list) {
            model.addRow(new Object[]{
                    s.getStudentId(),
                    s.getName(),
                    s.getEmail(),
                    s.getPhone()
            });
        }
    }

    // REFRESH TABLE
    public void refresh() {
        loadTable();
        idField.setText("");
        nameField.setText("");
        emailField.setText("");
        phoneField.setText("");
    }
}