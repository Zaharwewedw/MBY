package com.example.Telegram_mby.controller;


import com.example.Telegram_mby.Service.UserServiceImpl;
import com.example.Telegram_mby.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {

    private UserServiceImpl userService;

    @GetMapping("/sayHello")
    public String getRestController() {
        return "hello Word";
    }

    @GetMapping("/person")
    public Person getRestControllerUser() {
        System.out.println(userService.getPersonDataBase(1L).get());
        return userService.getPersonDataBase(1L).get();
    }
}
