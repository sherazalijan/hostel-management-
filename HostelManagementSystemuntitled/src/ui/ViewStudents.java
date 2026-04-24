package ui;

import db.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewStudents {

    public ViewStudents() {

        JFrame frame = new JFrame("Students List");
        frame.setSize(600, 400);

        String[] cols = {"ID", "Name", "Email", "Phone"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);

        JTable table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);

        loadData(model);

        frame.add(scroll);
        frame.setVisible(true);
    }

    public void loadData(DefaultTableModel model) {

        try {
            Connection conn = DBConnection.connect();
            String query = "SELECT * FROM Student";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("student_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone")
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}