package com.geekbrains.controllers;

import com.geekbrains.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// auth vk(соцсети)
// к следующему занятию: регистрация + много доп кода
//

@Controller
public class MainController {
    // https://getbootstrap.com/docs/4.1/getting-started/introduction/csrf

    @RequestMapping("/")
    public String showHomePage() {
        return "index";
    }

//    @GetMapping("/login")
//    public String showMyLoginPage() {
//        return "modern-login";
//    }
//
//    @RequestMapping("/hello")
//    public String test() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return "index";
//    }
//
    @Secured({"ROLE_USER"})
    @RequestMapping("/onlyYou")
    @ResponseBody
    public String onlyYou() {
        return "index";
    }
}
