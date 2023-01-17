package Chap15.jpa.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Chap15.jpa.DB.dto.Course;
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

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("student", new Student());
        return "students";
    }

    @GetMapping("/students")
    public String getStudents(Model model) {
        model.addAttribute("listOfStudents", studentService.getStudents());
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
            studentService.addStudent(student);
        }
        return "redirect:/students";
    }

    @GetMapping("/students/{matricule}")
    public String getCourseDetails(@PathVariable String matricule, Model model) {
        Student student = studentService.findStudentByMatricule(matricule);
        List<Course> coursesForThisStudent = courseService.findCoursesForThisStudent(matricule);
        if (student != null) {
            model.addAttribute("student", student);
            model.addAttribute("coursesForThisStudent", coursesForThisStudent);
        } else {
            return "erreur";
        }
        return "student";
    }
}
