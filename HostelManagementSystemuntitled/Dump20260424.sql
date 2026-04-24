-- 1. Admin Table
CREATE TABLE `Admin` (
                         `admin_id` int NOT NULL AUTO_INCREMENT,
                         `username` varchar(50) NOT NULL,
                         `password` varchar(50) NOT NULL,
                         PRIMARY KEY (`admin_id`),
                         UNIQUE KEY `username` (`username`)
);

-- 2. Room Table
CREATE TABLE `Room` (
                        `room_id` int NOT NULL AUTO_INCREMENT,
                        `room_number` varchar(10) NOT NULL,
                        `capacity` int NOT NULL,
                        `occupied` int DEFAULT '0',
                        PRIMARY KEY (`room_id`),
                        UNIQUE KEY `room_number` (`room_number`),
                        CONSTRAINT `room_chk_1` CHECK ((`capacity` > 0)),
                        CONSTRAINT `room_chk_2` CHECK ((`occupied` >= 0))
);

-- 3. Student Table
CREATE TABLE `Student` (
                           `student_id` int NOT NULL AUTO_INCREMENT,
                           `name` varchar(100) NOT NULL,
                           `email` varchar(100) NOT NULL,
                           `phone` varchar(15) DEFAULT NULL,
                           `room_id` int DEFAULT NULL,
                           PRIMARY KEY (`student_id`),
                           UNIQUE KEY `email` (`email`),
                           KEY `room_id` (`room_id`),
                           CONSTRAINT `student_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `Room` (`room_id`) ON DELETE SET NULL ON UPDATE CASCADE
);

-- 4. Payment Table
CREATE TABLE `Payment` (
                           `payment_id` int NOT NULL AUTO_INCREMENT,
                           `student_id` int NOT NULL,
                           `amount` decimal(10,2) NOT NULL,
                           `payment_date` date DEFAULT (curdate()),
                           PRIMARY KEY (`payment_id`),
                           KEY `student_id` (`student_id`),
                           CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `Student` (`student_id`) ON DELETE CASCADE
);

-- 5. Complaint Table
CREATE TABLE `Complaint` (
                             `complaint_id` int NOT NULL AUTO_INCREMENT,
                             `student_id` int NOT NULL,
                             `description` text NOT NULL,
                             `status` varchar(20) DEFAULT 'Pending',
                             PRIMARY KEY (`complaint_id`),
                             KEY `student_id` (`student_id`),
                             CONSTRAINT `complaint_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `Student` (`student_id`) ON DELETE CASCADE
);