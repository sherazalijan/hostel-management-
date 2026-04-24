package ui;

import db.ReportDAO;

import javax.swing.*;
import java.awt.*;

public class ReportUI {

    public ReportUI() {
        JFrame frame = new JFrame("System Reports");
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        // Top Panel for Buttons
        JPanel topPanel = new JPanel();
        JButton financialBtn = new JButton("Financial Report (3-Table Join)");
        JButton occupancyBtn = new JButton("High Occupancy (Aggregation)");

        topPanel.add(financialBtn);
        topPanel.add(occupancyBtn);

        // Center Panel for Table
        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);

        // Add to Frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Button Actions - Load data from DAO into the Table
        financialBtn.addActionListener(e -> {
            table.setModel(ReportDAO.getFinancialReport());
        });

        occupancyBtn.addActionListener(e -> {
            table.setModel(ReportDAO.getHighOccupancyRooms());
        });

        frame.setVisible(true);
    }
}