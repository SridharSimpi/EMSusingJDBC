# EMSusingJDBC
Developed a Employee Management System using JDBC , It is mandatory to connect with database to develop this project
If you needed you can download the mysql connector usign the below link 💕
https://repo1.maven.org/maven2/com/mysql/mysql-connector-j/8.3.0/mysql-connector-j-8.3.0.jar


DONT FORGET TO CREATE TABLE IN DATABASE
-------------------------------------------
 
CREATE DATABASE IF NOT EXISTS jdbc_project;
USE jdbc_project;

CREATE TABLE employee (
    id INT PRIMARY KEY,
    name VARCHAR(50)
);
