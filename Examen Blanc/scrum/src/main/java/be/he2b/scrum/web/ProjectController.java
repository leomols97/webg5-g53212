package be.he2b.scrum.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import be.he2b.scrum.business.ScrumService;

@Controller
public class ProjectController {

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @Autowired
    ScrumService scrumService;

    @GetMapping("/projects")
    public String showProjects(Model model) {
        model.addAttribute("projects", scrumService.getAllProjects());
        return "projects";
    }
}
