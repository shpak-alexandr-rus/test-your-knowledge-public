/**
 * ToDo: Добавить описание
 */
package com.shpakalexandr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /**
     * ToDo: Добавить описание
     * @return
     */
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
