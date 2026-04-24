package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Student;

public class ManageStudentDAO {

    // ADD STUDENT
    public static void addStudent(Student s) {

        try {
            Connection conn = DBConnection.connect();

            String query = "INSERT INTO Student (name, email, phone, room_id) VALUES (?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, s.getName());
            pst.setString(2, s.getEmail());
            pst.setString(3, s.getPhone());
            pst.setObject(4, s.getRoomId()); // can be null

            pst.executeUpdate();

            System.out.println("Student Added ✅");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE STUDENT
    public static void updateStudent(Student s) {

        try {
            Connection conn = DBConnection.connect();

            String query = "UPDATE Student SET name=?, email=?, phone=?, room_id=? WHERE student_id=?";

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, s.getName());
            pst.setString(2, s.getEmail());
            pst.setString(3, s.getPhone());
            pst.setObject(4, s.getRoomId());
            pst.setInt(5, s.getStudentId());

            pst.executeUpdate();

            System.out.println("Student Updated ✏️");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE STUDENT
    public static void deleteStudent(int studentId) {

        try {
            Connection conn = DBConnection.connect();

            String query = "DELETE FROM Student WHERE student_id=?";

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, studentId);

            pst.executeUpdate();

            System.out.println("Student Deleted 🗑️");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // GET ALL STUDENTS (FOR TABLE UI)
    public static List<Student> getAllStudents() {

        List<Student> list = new ArrayList<>();

        try {
            Connection conn = DBConnection.connect();

            String query = "SELECT * FROM Student";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                Student s = new Student(
                        rs.getInt("student_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getObject("room_id") != null ? rs.getInt("room_id") : null
                );

                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}