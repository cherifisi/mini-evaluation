package org.example.minievaluation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    @GetMapping(name = "mini_evaluation", value = "/")
    public String welcome() {
        return "welcome";
    }
}
