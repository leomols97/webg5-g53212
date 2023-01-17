package Chap15.jpa.DB.dto;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

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
 * relation 1-1 BIDIRECTIONNELLE avec Student
 */
public class InternshipAddress {

    @Id
    @NotNull(message = "Le nom de l'entreprise ne peut pas être null")
    @Size(min = 2, max = 50, message = "Le nom de l'entreprise doit avoir entre 2 et 50 caractères")
    private String name;

    @NotNull(message = "Le nom de la rue ne peut pas être null")
    @Size(min = 2, max = 50, message = "Le nom de la rue doit avoir entre 2 et 50 caractères")
    private String street;

    @NotNull(message = "Le numéro de la rue ne peut pas être null")
    @Range(min = 1, max = 9999, message = "Le numéro de la rue doit être compris entre 1 et 9999")
    private int number;

    @NotNull(message = "La ville ne peut pas être null")
    @Size(min = 2, max = 50, message = "Le nom de la ville doit avoir entre 2 et 50 caractères")
    private String city;

    @NotNull(message = "Le code postal ne peut pas être null")
    @Range(min = 1000, max = 99999, message = "Le code postal doit être compris entre 1000 et 9999")
    private int post_code;

    @OneToOne
    @JoinColumn(name = "student_id") // student_id est la clé étrangère qui relie les tables INTERNSHIP_ADDRESS et
                                     // STUDENT
    private Student student;
}