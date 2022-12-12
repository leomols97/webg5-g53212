package be.he2b.scrum.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import be.he2b.scrum.DTOS.ProjectDTO;
import be.he2b.scrum.business.ScrumService;
import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.extern.java.Log;

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

    @GetMapping("/projects/project/{projectName}")
    public String showProjectDetail(@PathVariable(name = "projectName") String projectName, Model model) {
        Collection<ProjectDTO> storiesForOneProject = scrumService.getProjectsStartingWith(projectName);
        model.addAttribute("storiesForOneProject", storiesForOneProject);
        return "projectDetails";
    }
}
