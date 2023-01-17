package Chap15.jpa.DB.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.FetchType;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
public class Student {

    // @GeneratedValue(strategy = GenerationType.IDENTITY) // mis en commentaire
    // car, sinon, on ne peut pas créer un
    // étudiant avec un matricule donné
    @Id
    @Range(min = 10000, max = 99999, message = "Le matricule doit être un nombre compris entre 10000 et 99999 compris !")
    // @SequenceGenerator(name = "employee_id_seq", sequenceName =
    // "employee_id_seq", allocationSize = 1)
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
    // "employee_id_seq")
    private String matricule;

    @NotBlank(message = "Ce champ ne peut pas être vide !")
    @NotNull(message = "Ce champ ne peut pas être null !")
    private String name;

    @NotNull(message = "Vous avez oublié de sélectionner le genre de l'étudiant !")
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @NotNull(message = "Vous avez oublié de sélectionner la section de l'étudiant !")
    @Enumerated(EnumType.STRING)
    private Section section;

    // Test pour montrer une relation UNIDIRECTIONNELLE 1-1 vers l'entité
    // SchoolAddress.
    // Il n'y a pas de référence à l'entité Student dans l'entité Address
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "school_address") // school_address est la clé étrangère qui relie les tables STUDENT et
                                         // SCHOOLADDRESS
    private SchoolAddress school_address;

    // Test pour montrer une relation BIDIRECTIONNELLE 1-1 vers l'entité
    // Internshipaddress.
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL) // student est la clé étrangère qui relie les tables
                                                               // STUDENT et INTERNSHIPADDRESS
    private InternshipAddress internship_address;

    // @ManyToMany(mappedBy = "student", cascade = CascadeType.ALL)
    // private List<Course> courses;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    @JsonManagedReference
    @JsonIgnore // Pour éviter les erreurs de boucle infinie car Student appellerait la méthode
                // toString de Course qui appellerait la méthode toString de Student
    private List<Course> courses = new ArrayList<>();

    @Override
    public String toString() {
        return "Student [matricule=" + matricule + ", name=" + name + ", genre=" + genre + ", section=" + section + "]";
    }
}