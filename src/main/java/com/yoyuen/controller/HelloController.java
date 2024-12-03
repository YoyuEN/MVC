package com.yoyuen.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {
    private static final Log logger =
            LogFactory.getLog(HelloController.class);
    @GetMapping(value = "/hello-mvc")
    public String showHomePage(Model model) {
        logger.info("控制器处理请求。");
        model.addAttribute("message", "欢迎学习Spring MVC框架!");
        return "hello";
    }
}