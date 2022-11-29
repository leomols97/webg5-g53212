package Chap15.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Chap15.jpa.service.PaeService;

@Controller
public class StudentController {

    @Autowired
    PaeService pae;

    @GetMapping("/students")
    public String getStudents(Model model) {
        // Créer un cours par défaut pour permettre de l'utiliser lors de l'ajout d'un
        // cours dans le formulaire d'ajout dans l'HTML

        System.out.println("StudentsController.getStudents()");
        // StudentDTO student = new StudentDTO();
        // List<StudentDTO> students = pae.getStudents();
        return "students";
    }
}
