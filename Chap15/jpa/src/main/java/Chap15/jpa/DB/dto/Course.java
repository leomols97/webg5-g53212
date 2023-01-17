package Chap15.jpa.DB.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course {

    @Id
    @NotNull(message = "Le sigle du cours ne peut pas être null !")
    @NotEmpty(message = "Le sigle du cours ne peut pas être vide !")
    private String id;

    @NotNull(message = "Le titre du cours ne peut pas être null !")
    @NotEmpty(message = "Le titre du cours ne peut pas être vide !")
    private String title;

    @NotNull(message = "Le nombre d'ECTS ne peut pas être null !")
    @Range(min = 1, max = 10, message = "Le nombre d'ECTS doit être un nombre compris entre 1 et 10 compris !")
    private int ECTS;

    @NotEmpty(message = "Vous devez sélectionner au moins 1 étudiant !")
    @NotNull(message = "Vous devez sélectionner au moins 1 étudiant !")
    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    @JsonBackReference
    @JsonIgnore // Pour éviter les erreurs de boucle infinie car Course appellerait la méthode
                // toString de Student qui appellerait la méthode toString de Course
    private List<Student> students = new ArrayList<>();

    @Override
    public String toString() {
        return "Course [id=" + id + ", title=" + title + ", ECTS=" + ECTS + "]";
    }
}