package models;

public class Student {

    private int studentId;
    private String name;
    private String email;
    private String phone;
    private Integer roomId; // can be null

    // ✅ 1. SIMPLE CONSTRUCTOR (MOST IMPORTANT - fixes your error)
    public Student(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.roomId = null;
    }

    // ✅ 2. INSERT WITH ROOM
    public Student(String name, String email, String phone, Integer roomId) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.roomId = roomId;
    }

    // ✅ 3. FULL CONSTRUCTOR (FOR UPDATE / FETCH)
    public Student(int studentId, String name, String email, String phone, Integer roomId) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.roomId = roomId;
    }

    // 🔹 GETTERS
    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getRoomId() {
        return roomId;
    }

    // 🔹 SETTERS
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }
}