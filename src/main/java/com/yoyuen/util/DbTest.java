package com.yoyuen.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbTest {
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/product";
        String user = "root";
        String password = "242431";

        try {
            // 显式加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}