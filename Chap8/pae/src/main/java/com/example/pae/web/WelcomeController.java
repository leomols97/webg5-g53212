package com.example.pae.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {
    @GetMapping("/welcome")
    public String greeting(@RequestParam String name, Model model) {
        List<String> userNameList = Arrays.asList("Jean", "Léopold");
        model.addAttribute("name", name);
        model.addAttribute("userNameList", userNameList);
        return "welcome";
    }
}