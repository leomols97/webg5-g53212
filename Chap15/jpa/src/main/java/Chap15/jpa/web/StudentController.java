package Chap15.jpa.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        System.out.println("StudentController.home()");
        return "students";
    }

    @GetMapping("/students")
    public String getStudents(Model model) {
        // Créer un cours par défaut pour permettre de l'utiliser lors de l'ajout d'un
        // cours dans le formulaire d'ajout dans l'HTML

        System.out.println("StudentsController.getStudents()");
        // StudentDTO student = new StudentDTO();
        // List<StudentDTO> students = pae.getStudents();
        return "students";
    }

    private int convertStringToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    @PostMapping("/addStudent")
    public String addStudent(@Valid @RequestParam("matricule") String matricule,
            @Valid @RequestParam("name") String name,
            @Valid @RequestParam("genre") Genre genre,
            @Valid @RequestParam("section") Section section,
            /* @ModelAttribute StudentDTO student, */ Model model) {
        System.out.println("matricule");
        System.out.println(matricule);

        int mat = convertStringToInt(matricule);
        if (mat == -1) {
            model.addAttribute("errorMessage", "Le matricule doit être un nombre entier valide !");
            return "form";
        }
        Genre genr = genre;
        if (genr == null) { // Malgré l'annotation @NotNull dans le DTO, je dois faire cette vérification
            model.addAttribute("errorMessage", "Le genre doit être sélectionné !");
            return "form";
        }
        Section sect = section;
        if (section == null) { // Malgré l'annotation @NotNull dans le DTO, je dois faire cette vérification
            model.addAttribute("errorMessage", "La section doit être sélectionnée !");
            return "form";
        }

        StudentDTO student = new StudentDTO(mat, name, genr, sect);
        studentRepository.save(student);
        return "redirect:/students";
    }
}
