package Chap15.jpa.DB.dto;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

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
 * relation 1-1 BIDIRECTIONNELLE avec Student
 */
public class Internshipaddress {

    @Id
    private String name;
    private String street;
    private int number;
    private String city;
    private String post_code;

    @OneToOne
    @JoinColumn(name = "student_id") // student_id est la clé étrangère qui relie les tables INTERNSHIP_ADDRESS et
                                     // STUDENT
    private Student student;
}