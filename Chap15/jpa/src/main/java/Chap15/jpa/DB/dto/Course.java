package Chap15.jpa.DB.dto;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Range;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course {

    @Id
    private String id;
    private String title;
    @Range(min = 1, max = 10, message = "Le matricule doit être un nombre compris entre 1 et 10 compris !")
    private String ECTS;

    // @ManyToMany(mappedBy = "course", cascade = CascadeType.ALL)
    // // @JoinColumn(name = "students")
    // private List<Student> students;

    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();
}