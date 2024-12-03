package com.yoyuen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private int id;
    private String username;
    private String password;
    private String sex;
    private String usertype;
    private Date birthday;
    private String address;
}
