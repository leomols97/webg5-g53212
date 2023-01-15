package Chap15.jpa.DB.dto;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
/**
 * Cette classe a pour simple but de montrer un exemple d'utilisation d'une
 * relation 1-N BIDIRECTIONNELLE avec Student
 */
public class Course {
    @Id
    private String id;
    private String title;
    private int ECTS;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}