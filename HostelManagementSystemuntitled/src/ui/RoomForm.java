package ui;

import db.RoomDAO;

import javax.swing.*;
import java.awt.*;

public class RoomForm {

    public RoomForm() {

        JFrame frame = new JFrame("Room Management");
        frame.setSize(350, 250);
        frame.setLayout(new GridLayout(4, 2));

        JLabel roomLabel = new JLabel("Room No:");
        JLabel capLabel = new JLabel("Capacity:");
        JLabel studentLabel = new JLabel("Student ID:");

        JTextField roomField = new JTextField();
        JTextField capField = new JTextField();
        JTextField studentField = new JTextField();

        JButton addRoomBtn = new JButton("Add Room");
        JButton assignBtn = new JButton("Assign Room");

        frame.add(roomLabel);
        frame.add(roomField);

        frame.add(capLabel);
        frame.add(capField);

        frame.add(studentLabel);
        frame.add(studentField);

        frame.add(addRoomBtn);
        frame.add(assignBtn);

        // Add room
        addRoomBtn.addActionListener(e -> {
            RoomDAO.addRoom(roomField.getText(),
                    Integer.parseInt(capField.getText()));

            JOptionPane.showMessageDialog(frame, "Room Added 🏠");
        });

        // Assign room
        assignBtn.addActionListener(e -> {
            RoomDAO.assignRoom(
                    Integer.parseInt(studentField.getText()),
                    Integer.parseInt(roomField.getText())
            );

            JOptionPane.showMessageDialog(frame, "Room Assigned ✅");
        });

        frame.setVisible(true);
    }
}