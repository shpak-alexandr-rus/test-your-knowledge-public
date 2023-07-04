package com.shpakalexandr.tykapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestsController {

    @GetMapping("/tests")
    public String getTests() {
        return "tests";
    }
}
