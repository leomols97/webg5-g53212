package Chap15.jpa.DB.dto;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class StudentDTO {

    @Id
    @NotBlank(message = "Ce champ ne peut pas être vide")
    // @GeneratedValue(strategy = GenerationType.IDENTITY) // mis en commentaire
    // car, sinon, on ne peut pas créer un étudiant avec un matricule donné
    private int matricule;

    @NotBlank(message = "Ce champ ne peut pas être vide")
    private String name;

    @NotNull(message = "Ce champ ne peut pas être null")
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @NotNull(message = "Ce champ ne peut pas être null")
    @Enumerated(EnumType.STRING)
    private Section section;
}