package db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PaymentDAO {

    public static void addPayment(int studentId, double amount) {

        try {
            Connection conn = DBConnection.connect();

            String query = "INSERT INTO Payment (student_id, amount) VALUES (?, ?)";

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, studentId);
            pst.setDouble(2, amount);

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}