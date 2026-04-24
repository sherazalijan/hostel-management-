package ui;

import db.StudentDAO;
import models.Student;

public class Main {

    public static void main(String[] args) {

        Student s1 = new Student(
                "Ali Khan",
                "ali2@gmail.com",
                "03001234567"
        );

        StudentDAO.insertStudent(s1);
    }
}