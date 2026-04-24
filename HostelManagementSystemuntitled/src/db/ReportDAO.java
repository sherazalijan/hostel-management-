package db;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReportDAO {

    // 1. COMPLEX JOIN (Financial Report)
    public static DefaultTableModel getFinancialReport() {
        String[] cols = {"Student Name", "Room No", "Amount Paid", "Date"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);

        try {
            Connection conn = DBConnection.connect();
            String query = "SELECT s.name, r.room_number, p.amount, p.payment_date " +
                    "FROM Student s " +
                    "JOIN Room r ON s.room_id = r.room_id " +
                    "JOIN Payment p ON s.student_id = p.student_id";

            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("name"),
                        rs.getString("room_number"),
                        rs.getDouble("amount"),
                        rs.getDate("payment_date")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    // 2. AGGREGATION (High Occupancy Rooms)
    public static DefaultTableModel getHighOccupancyRooms() {
        String[] cols = {"Room Number", "Total Students"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);

        try {
            Connection conn = DBConnection.connect();
            String query = "SELECT r.room_number, COUNT(s.student_id) AS total_students " +
                    "FROM Room r " +
                    "JOIN Student s ON r.room_id = s.room_id " +
                    "GROUP BY r.room_number " +
                    "HAVING COUNT(s.student_id) > 1";

            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("room_number"),
                        rs.getInt("total_students")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
}