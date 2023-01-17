package Chap15.jpa.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/courses")
    public String getCourses(Model model) {
        // Créer un cours par défaut pour permettre de l'utiliser lors de l'ajout d'un
        // cours dans le formulaire d'ajout dans l'HTML

        model.addAttribute("coursesList", courseService.getCourses());
        model.addAttribute("course", new Course());
        model.addAttribute("studentsList", studentService.getStudents());
        return "courses";
    }

    @PostMapping("courses/add")
    public String addCourse(@Valid @ModelAttribute(name = "course") Course course,
            @Valid @RequestParam("students") List<Student> students, Errors errors, Model model) {
        if (errors.hasErrors()) {
            // Les 2 lignes suivantes sont pcq il faut redonner la liste des cours au modèle
            // car on recharge la page
            model.addAttribute("listOfCourses", courseService.getCourses());
            return "courses";
        } else {
            // Eviter qu'un cours ne soit ajouté 2 fois
            // On cherche les ids de tous les cours et on compare avec l'id du cours à
            // ajouter
            System.out.println("AAA");
            List<Course> courses = courseService.getCourses();
            List<String> coursesIds = new ArrayList<>();
            for (Course c : courses)
                coursesIds.add(c.getId());
            if (!coursesIds.contains(course.getId()))
                courseService.addCourse(course);

            // Eviter qu'un étudiant ne soit ajouté 2 fois
            // On cherche les matricules de tous les étudiants du cours à ajouter et on
            // compare avec le matricule des étudiants à ajouter
            List<Student> studentsOfThisCourse = studentService.findStudentsByCourseId(course.getId());
            for (Student student : students) {
                if (!studentsOfThisCourse.contains(student)) {
                    studentService.addStudentToCourse(student.getMatricule(), course.getId());
                }
            }
        }
        return "redirect:/courses";
    }

    @GetMapping("/courses/{id}")
    public String getCourseDetails(@PathVariable String id, Model model) {
        Course course = courseService.findCourseById(id);
        List<Student> studentsInThisCourse = studentService.findStudentsByCourseId(id);
        if (course != null) {
            model.addAttribute("course", course);
            model.addAttribute("studentsInThisCourse", studentsInThisCourse);
        } else {
            return "erreur";
        }
        return "course";
    }
}