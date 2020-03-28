package lesson06.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @RequestMapping("/")
    public String showHomePage() {
        return "index";
    }

//    Вариант авторизации на уровне Метода
    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/onlyYou")
    @ResponseBody
    public String onlyYou() {
        return "Только пользователь с ролью ADMIN может обратиться к этому методу!";
    }
}
