package com.example.SpingJPATest.Context;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Context {
    private String url = "jdbc:mysql://localhost:3306/Student";
    private String username = "root";
    private String password = "12#@12";

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
}
