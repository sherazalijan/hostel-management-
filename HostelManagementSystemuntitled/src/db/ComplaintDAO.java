package db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ComplaintDAO {

    public static void addComplaint(int studentId, String desc) {

        try {
            Connection conn = DBConnection.connect();

            String query = "INSERT INTO Complaint (student_id, description) VALUES (?, ?)";

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, studentId);
            pst.setString(2, desc);

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}