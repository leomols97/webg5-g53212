package Chap15.jpa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import Chap15.jpa.DB.dto.CourseDTO;
import Chap15.jpa.service.PaeService;

@Controller
public class CourseController {

    @Autowired
    PaeService pae;

    @GetMapping("/courses")
    public String getCourses(Model model) {
        // Créer un cours par défaut pour permettre de l'utiliser lors de l'ajout d'un
        // cours dans le formulaire d'ajout dans l'HTML

        System.out.println("CourseController.getCourses()");
        CourseDTO course = new CourseDTO("", "", 0);
        List<CourseDTO> coursess = pae.getCourses();
        return "courses";
    }
}