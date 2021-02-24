package com.example.BankApp.postgreConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PgConnection {
    private static final String url = "jdbc:postgresql://localhost:1996/BankDB";
    private static final String user = "postgres";
    private static final String password = "admin";

    public static Connection connect() throws SQLException {

            Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
