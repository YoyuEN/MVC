package com.yoyuen.controller;

import com.yoyuen.dao.UserDao;
import com.yoyuen.entity.User;
import com.yoyuen.springmvc.SequenceGenerator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class UserController {
    @Autowired
    private UserDao userDao;

    private static final Log logger = LogFactory.getLog(UserController.class);

    @RequestMapping(value = "/regist-user2", method = RequestMethod.POST)
    public String saveUser(@RequestParam(value = "username") String username,
                           @RequestParam(value = "password") String password,
                           @RequestParam(value = "sex") String sex,
                           @RequestParam(value = "address") String address,
                           @RequestParam(value = "birthday", required = false) String birthdayStr,
                           @RequestParam(value = "usertype") String usertype,
                           Model model) {
        logger.info("调用saveUser()方法");

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setAddress(address);
        newUser.setSex(sex);

        if (birthdayStr != null && !birthdayStr.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date birthday = dateFormat.parse(birthdayStr);
                newUser.setBirthday(birthday);
            } catch (ParseException e) {
                logger.error("日期解析错误: " + e.getMessage());
                model.addAttribute("error", "日期格式不正确");
                return "errorPage"; // 返回错误页面
            }
        } else {
            newUser.setBirthday(null); // 如果生日为空，设置为null
        }

        newUser.setUsertype(usertype);
        model.addAttribute("user", newUser);
        System.out.println(newUser);
        userDao.addUser(newUser);
        return "showUser";
    }

    @PostMapping(value = "/regist-user3")
    public String loginUser(User user, Model model) {
        logger.info("用户登录");
        System.out.println(user);
        model.addAttribute("user", user);
        // 这里可以添加登录验证逻辑
        return "showUser";
    }

    @RequestMapping(value = "/regist-user4")
    public String inputUser(Integer id,
                            String username,
                            String password,
                            String sex,
                            String address,
                            String usertype,
                            @RequestParam(value = "birthday", required = false) String birthdayStr,
                            Model model) {
        logger.info("调用saveUser()");

        User newUser = new User();
        newUser.setId(id != null ? id : SequenceGenerator.getNextSequence());
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setAddress(address);
        newUser.setSex(sex);

        if (birthdayStr != null && !birthdayStr.isEmpty()) {
            try {
                Date birthday = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(birthdayStr).getTime());
                newUser.setBirthday(birthday);
            } catch (ParseException e) {
                logger.error("日期解析错误: " + e.getMessage());
                model.addAttribute("error", "日期格式不正确");
                return "errorPage"; // 返回错误页面
            }
        } else {
            newUser.setBirthday(null); // 如果生日为空，设置为null
        }

        newUser.setUsertype(usertype);
        model.addAttribute("user", newUser);
        return "showUser";
    }
}