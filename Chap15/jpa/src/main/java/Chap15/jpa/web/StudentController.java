package Chap15.jpa.web;

import java.beans.PropertyEditorSupport;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import Chap15.jpa.DB.dto.Student;
import Chap15.jpa.Repositories.CourseRepository;
import Chap15.jpa.Repositories.StudentRepository;
import Chap15.jpa.service.CourseService;
import Chap15.jpa.service.StudentService;

@Controller
public class StudentController {

    @Autowired
    CourseService courseService;

    @Autowired
    StudentService studentService;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("student", new Student());
        return "students";
    }

    @GetMapping("/students")
    public String getStudents(Model model) {
        // Créer un cours par défaut pour permettre de l'utiliser lors de l'ajout d'un
        // cours dans le formulaire d'ajout dans l'HTML
        model.addAttribute("student", new Student());
        return "students";
    }

    @PostMapping("/students/add")
    public String addStudent(@Valid @ModelAttribute(name = "student") Student student, Errors errors, Model model) {
        if (errors.hasErrors()) {
            // Les 2 lignes suivantes sont pcq il faut redonner la liste des cours au modèle
            // car on recharge la page
            List<Student> studentsList = studentService.getStudents();
            model.addAttribute("listOfStudents", studentsList);
            return "students";
        } else {
            studentRepository.save(student);
        }
        return "redirect:/students";
    }

    @GetMapping("/students/{matricule}")
    public String getCourseDetails(@PathVariable String matricule, Model model) {
        Optional<Student> student = studentRepository.findById(matricule);
        List<Student> coursesForThisStudent = courseRepository.findByStudent(matricule);
        if (student.isPresent()) {
            model.addAttribute("course", student.orElse(null)); // orElse(null) au cas où le cours n'existe pas
            model.addAttribute("coursesForThisStudent", coursesForThisStudent);
        } else {
            return "erreur";
        }
        return "course";
    }
}
