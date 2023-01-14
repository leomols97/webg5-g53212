package Chap15.jpa.web;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import Chap15.jpa.DB.dto.StudentDTO;
import Chap15.jpa.DB.dto.Genre;
import Chap15.jpa.DB.dto.Section;
import Chap15.jpa.Repositories.StudentRepository;
import Chap15.jpa.service.PaeService;

@Controller
public class StudentController {

    @Autowired
    PaeService pae;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("student", new StudentDTO());
        return "students";
    }

    @GetMapping("/students")
    public String getStudents(Model model) {
        // Créer un cours par défaut pour permettre de l'utiliser lors de l'ajout d'un
        // cours dans le formulaire d'ajout dans l'HTML

        System.out.println("StudentsController.getStudents()");
        model.addAttribute("student", new StudentDTO());
        return "students";
    }

    @PostMapping("/students/add")
    public String addStudent(
            // @Valid @RequestParam("matricule") String matricule,
            // @Valid @RequestParam("name") String name,
            // @Valid @RequestParam("genre") Genre genre,
            // @Valid @RequestParam("section") Section section,
            @Valid @ModelAttribute(name = "student") StudentDTO student) {
        // if (result.hasErrors()) {
        // System.out.println("Validation errors: " + result.getErrorCount());
        // } else {
        System.out.print("ERTHZERTHM");

        studentRepository.save(student);
        // }
        return "redirect:/students";
    }
}
