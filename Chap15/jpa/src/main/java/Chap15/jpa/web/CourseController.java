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
public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    StudentService studentService;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/courses")
    public String getCourses(Model model) {
        // Créer un cours par défaut pour permettre de l'utiliser lors de l'ajout d'un
        // cours dans le formulaire d'ajout dans l'HTML

        Iterable<Course> courses = courseRepository.findAll();
        model.addAttribute("coursesList", courses);
        model.addAttribute("course", new Course());
        return "courses";
    }

    @PostMapping("/courses/add")
    public String addCourse(@Valid @ModelAttribute(name = "course") Course course, Errors errors, Model model) {
        if (errors.hasErrors()) {
            // Les 2 lignes suivantes sont pcq il faut redonner la liste des cours au modèle
            // car on recharge la page
            List<Course> coursesList = courseService.getCourses();
            model.addAttribute("listOfCourses", coursesList);
            return "courses";
        } else {
            courseRepository.save(course);
        }
        return "redirect:/courses";
    }

    @GetMapping("/courses/{id}")
    public String getCourseDetails(@PathVariable String id, Model model) {
        Optional<Course> course = courseRepository.findById(id);
        List<Student> studentsInThisCourse = studentRepository.findByCourse(id);
        if (course.isPresent()) {
            model.addAttribute("course", course.orElse(null)); // orElse(null) au cas où le cours n'existe pas
            model.addAttribute("studentsInThisCourse", studentsInThisCourse);
        } else {
            return "erreur";
        }
        return "course";
    }
}