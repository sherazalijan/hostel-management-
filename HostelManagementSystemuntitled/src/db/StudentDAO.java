package db;

import models.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDAO {

    public static void insertStudent(Student s) {

        try {
            Connection conn = DBConnection.connect();

            String query = "INSERT INTO Student (name, email, phone) VALUES (?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, s.getName());
            pst.setString(2, s.getEmail());
            pst.setString(3, s.getPhone());

            pst.executeUpdate();

            System.out.println("Student Inserted Successfully 🚀");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}