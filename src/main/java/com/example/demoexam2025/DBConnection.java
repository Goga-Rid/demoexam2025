package com.example.demoexam2025;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Данные для подключения к БД
    String url = "jdbc:postgresql://localhost:5432/demoexam2025";
    String user = "postgres";
    String password = "0000";

    // Метод для получения подключения к базе данных
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}