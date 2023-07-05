package com.shpakalexandr.tykapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/auth/login")
    public String authLogin(Model model, String error, String logout) {
        return "/auth/login";
    }
}
