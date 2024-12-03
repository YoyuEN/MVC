package com.yoyuen.dao;

import com.yoyuen.entity.User;
import com.yoyuen.util.DbTest;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UserDao {
    public boolean addUser(User user) {
        String sql = "insert into user values(?,?,?,?,?,?,?)";
        boolean n = false;
        try (
                Connection conn = DbTest.getConnection();
        ) {
            assert conn != null;
            try (PreparedStatement pstmt =conn.prepareStatement(sql);
                    ){
                pstmt.setInt(1, user.getId());
                pstmt.setString(2, user.getUsername());
                pstmt.setString(3, user.getPassword());
                pstmt.setString(4, user.getUsertype());
                pstmt.setString(5, user.getSex());
                java.util.Date utilDate = user.getBirthday();
                java.sql.Date sqlDate = (utilDate != null) ? new java.sql.Date(utilDate.getTime()) : null;
                pstmt.setString(6, String.valueOf(sqlDate));
                pstmt.setString(7, user.getAddress());
                n = pstmt.execute();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return n;
    }
}
