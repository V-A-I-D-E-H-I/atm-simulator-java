import java.sql.*;

// Step 1: Register the driver
public class Conn {

    // JDBC (Java Database Connectivity) connection
    // Step 2: Create connection
    // Step 3: Create statement
    // Step 4: Execute query
    // Step 5: Close connection

    Connection c;
    Statement s;

    // Constructor
    public Conn() {
        // exception handling
        try {

            // Step 2: Create connection
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "KaiyuriJinesh@123");
            // Notes: MySQL database commands:
            // 1. create database bankmanagementsystem(dbName);
            // 2. show databases;
            // 3. use bankmanagementsystem;

            // Step 3: Create statement
            s = c.createStatement();
            // Step 4: Execute query
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
