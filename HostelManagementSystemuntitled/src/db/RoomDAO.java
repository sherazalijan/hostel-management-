package db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RoomDAO {

    // Add new room
    public static void addRoom(String roomNumber, int capacity) {

        try {
            Connection conn = DBConnection.connect();

            String query = "INSERT INTO Room (room_number, capacity, occupied) VALUES (?, ?, 0)";

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, roomNumber);
            pst.setInt(2, capacity);

            pst.executeUpdate();

            System.out.println("Room Added 🏠");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Assign student to room
    public static void assignRoom(int studentId, int roomId) {

        try {
            Connection conn = DBConnection.connect();

            // 1. update student
            String q1 = "UPDATE Student SET room_id=? WHERE student_id=?";
            PreparedStatement pst1 = conn.prepareStatement(q1);

            pst1.setInt(1, roomId);
            pst1.setInt(2, studentId);

            pst1.executeUpdate();

            // 2. increase occupied count
            String q2 = "UPDATE Room SET occupied = occupied + 1 WHERE room_id=?";
            PreparedStatement pst2 = conn.prepareStatement(q2);

            pst2.setInt(1, roomId);

            pst2.executeUpdate();

            System.out.println("Room Assigned ✅");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}