# Hostel Management System 🏨

A desktop-based application built for Database Management Systems (DBMS) Lab 04. This system transitions manual, paper-based hostel management into a centralized relational database, ensuring data integrity, real-time tracking, and automated reporting.

## 🛠️ Tech Stack
* **Frontend:** Java (Swing)
* **Backend Logic:** Java (JDBC)
* **Database:** MySQL
* **Architecture:** Client-Server (Desktop GUI connected to Local DB)

## 🚀 Core Features
1.  **Student Management:** Register, update, and remove student profiles.
2.  **Dynamic Room Allocation:** Assign students to rooms with strict `CHECK` constraints to prevent overbooking (capacity vs. occupied).
3.  **Financial Tracking:** Log and monitor student payments with `CASCADE` deletion safety nets.
4.  **Complaint Logging:** Allow admins to track student maintenance requests.
5.  **Automated Reporting:** Generate multi-table `JOIN` reports (Financial status) and `GROUP BY/HAVING` aggregations (High occupancy rooms).

## 🗄️ Database Schema
The database (`hostel_management`) consists of 5 normalized tables:
* `Admin`: Manages secure login credentials.
* `Room`: Tracks capacity and current occupancy.
* `Student`: Linked to rooms via Foreign Key (`ON DELETE SET NULL`).
* `Payment`: Financial logs linked to students (`ON DELETE CASCADE`).
* `Complaint`: Maintenance logs linked to students.

## ⚙️ Setup & Installation
1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/YourUsername/Hostel-Management-System.git](https://github.com/YourUsername/Hostel-Management-System.git)
    ```
2.  **Database Configuration:**
    * Open MySQL Workbench or your preferred SQL client.
    * Create a database named `hostel_management`.
    * Import the `hostel_management.sql` dump file provided in this repository to generate the tables and constraints.
3.  **Application Configuration:**
    * Open the project in your Java IDE (Eclipse, IntelliJ, etc.).
    * Ensure the MySQL JDBC Connector (`mysql-connector-java.jar`) is added to your project's build path.
    * Open `src/db/DBConnection.java` and verify the database URL, username (`root`), and password match your local MySQL configuration.
4.  **Launch:**
    * Run `src/ui/Login.java` to start the application. 
    * Default Admin Credentials: Username: `admin` | Password: `1234`
