package be.he2b.scrum.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }
}
