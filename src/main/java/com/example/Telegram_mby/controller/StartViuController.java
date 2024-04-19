package com.example.Telegram_mby.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class StartViuController {

    @GetMapping
    public String start() {
        return "start";
    }
}
