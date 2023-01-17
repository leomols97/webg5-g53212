package Chap15.jpa.web;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;

import Chap15.jpa.DB.dto.Course;
import Chap15.jpa.DB.dto.Student;
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
        model.addAttribute("studentsList", studentService.getStudents());
        // Créer un cours par défaut pour permettre de l'utiliser lors de l'ajout d'un
        // cours dans le formulaire d'ajout dans l'HTML
        model.addAttribute("student", new Student());
        model.addAttribute("coursesList", courseService.getCourses());
        return "students";
    }

    @PostMapping("/students/add")
    public String addStudent(@Valid @ModelAttribute(name = "student") Student student,
            @Valid @RequestParam("courses") List<Course> courses, Errors errors, Model model) {
        if (errors.hasErrors()) {
            // Les 2 lignes suivantes sont pcq il faut redonner la liste des cours au modèle
            // car on recharge la page
            model.addAttribute("studentsList", studentService.getStudents());
            return "students";
        } else {
            // Eviter qu'un student ne soit ajouté 2 fois
            // On cherche les ids de tous les students et on check si l'id du student à
            // ajouter est déjà présent dans la DB
            Optional<Student> existingStudent = studentService.findStudentByMatriculeOPTIONAL(student.getMatricule());
            if (existingStudent.isPresent()) {
                student = existingStudent.get();
            } else {
                studentService.addStudent(student);
            }

            // Eviter qu'un cours ne soit ajouté 2 fois
            // On cherche les ids de tous les cours de l'étudiant à ajouter et on
            // compare avec l'id des cours à ajouter
            List<Course> coursesOfThisStudent = courseService.findCoursesForThisStudent(student.getMatricule());
            for (Course course : courses) {
                if (!coursesOfThisStudent.contains(course)) {
                    courseService.addStudentToCourse(student.getMatricule(), course.getId());
                }
            }
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

    @GetMapping("/students/filter")
    public List<Student> filterStudents(@RequestParam String name) {
        return studentService.filterStudentsByName(name);
    }
}
