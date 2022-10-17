package chap13.pae.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import chap13.pae.business.*;
import chap13.pae.model.*;

@Controller
public class CourseController {

    @Autowired
    Pae pae;

    @GetMapping("/courses")
    public String getCourses(Model model) {
        // Créer un cours par défaut pour permettre de l'utiliser lors de l'ajout d'un
        // cours dans le formulaire d'ajout dans l'HTML
        Course course = new Course("", "", 0);
        List<Course> coursesList = pae.getCourses();
        model.addAttribute("coursesList", coursesList);
        model.addAttribute("course", course);
        return "courses";
    }

    @PostMapping("/addCourse")
    public String addCourse(@ModelAttribute("course") Course course, Errors errors, Model model) {
        if (errors.hasErrors()) {
            // Les 2 lignes suivantes sont pcq il faut redonner la lsite des cours au modèle
            // car on recharge la page
            List<Course> coursesList = pae.getCourses();
            model.addAttribute("coursesList", coursesList);
            return "courses";
        }
        pae.addCourse(course);
        return "redirect:/courses";
    }
}