package main.java.chap13.pae.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import chap13.pae.business.*;
import chap13.pae.dto.*;

@Controller
public class TestController {

    @GetMapping("/test")
    public String test(Model model) {
        return "erreur";
    }
}