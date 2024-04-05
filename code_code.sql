CREATE DATABASE IF NOT EXISTS quiz_v2;
USE quiz_v2;

CREATE USER IF NOT EXISTS 'quiz_taker'@'localhost' IDENTIFIED BY 'quiz_taker';
GRANT USAGE ON *.* TO `quiz_taker`@`localhost`;
GRANT SELECT, INSERT, UPDATE, DELETE ON quiz_v2.* TO 'quiz_taker'@`localhost`;

DROP TABLE IF EXISTS quiz;
CREATE TABLE quiz (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    duration INT -- Duration in seconds
);

DROP TABLE IF EXISTS question;
CREATE TABLE question (
    id INT AUTO_INCREMENT PRIMARY KEY,
    text VARCHAR(255) NOT NULL,
    category VARCHAR(100),
    correct_answer VARCHAR(255) NOT NULL,
    answer_option_1 VARCHAR(255) NOT NULL,
    answer_option_2 VARCHAR(255) NOT NULL,
    answer_option_3 VARCHAR(255) NOT NULL,
    answer_option_4 VARCHAR(255) NOT NULL,
    quiz_id INT, 
    FOREIGN KEY (quiz_id) REFERENCES quiz(id)
);

INSERT INTO quiz (title, description, duration)
VALUES ('My Quiz', 'This is a sample quiz', 60);

INSERT INTO question (text, category, correct_answer, answer_option_1, answer_option_2, answer_option_3, answer_option_4, quiz_id)
VALUES
('What is the name of Emma´s daughter?', 'Emma', 'Eloà', 'Emma', 'Eloà', 'Marie', 'Emilie', 1),
('What pet/s do Emma have?', 'Emma', 'Cat', 'Cat', 'Dog', 'Bird', 'Snake', 1),
('What does Emma study?', 'Emma', 'Computer Sciences', 'Graphic design', 'Multimedia Design', 'Computer Sciences', 'Web development', 1);