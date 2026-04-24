package ui;

import javax.swing.*;
import java.awt.*;

public class Dashboard {

    public Dashboard() {

        JFrame frame = new JFrame("Hostel Management System");
        // Increased height slightly to accommodate the extra button
        frame.setSize(700, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        // CHANGED: GridLayout is now 7 rows instead of 6
        panel.setLayout(new GridLayout(7, 1, 10, 10));
        panel.setBackground(new Color(44, 62, 80));

        JLabel title = new JLabel("HOSTEL DASHBOARD", SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 22));

        JButton studentBtn = new JButton("Student Management");
        JButton roomBtn = new JButton("Room Management");
        JButton paymentBtn = new JButton("Payment Management");
        JButton complaintBtn = new JButton("Complaint Management");
        // NEW BUTTON: System Reports
        JButton reportBtn = new JButton("System Reports");
        JButton exitBtn = new JButton("Exit");

        // Added reportBtn to the styling array
        JButton[] buttons = {studentBtn, roomBtn, paymentBtn, complaintBtn, reportBtn, exitBtn};

        for (JButton b : buttons) {
            b.setText(b.getText()); // forces text refresh (important fix)
            b.setFont(new Font("Arial", Font.BOLD, 16));
            b.setForeground(Color.BLACK);
            b.setBackground(Color.WHITE);
            b.setFocusPainted(false);
            b.setOpaque(true);
            b.setBorderPainted(false);
        }

        exitBtn.setBackground(new Color(231, 76, 60));
        exitBtn.setForeground(Color.WHITE);

        panel.add(title);
        panel.add(studentBtn);
        panel.add(roomBtn);
        panel.add(paymentBtn);
        panel.add(complaintBtn);
        panel.add(reportBtn); // Added to panel
        panel.add(exitBtn);

        // Actions
        studentBtn.addActionListener(e -> new StudentPanel());
        roomBtn.addActionListener(e -> new RoomForm());
        paymentBtn.addActionListener(e -> new PaymentForm());
        complaintBtn.addActionListener(e -> new ComplaintForm());
        // NEW ACTION: Opens the reports table
        reportBtn.addActionListener(e -> new ReportUI());

        exitBtn.addActionListener(e -> frame.dispose());

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}