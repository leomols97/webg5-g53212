package Chap15.jpa.DB.dto;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;

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

    // @GeneratedValue(strategy = GenerationType.IDENTITY) // mis en commentaire
    // car, sinon, on ne peut pas créer un
    // étudiant avec un matricule donné
    @Range(min = 10000, max = 99999)
    @Size(min = 4, max = 5, message = "Le matricule doit être composé de 5 chiffres")
    // @Pattern(regexp = "^\\d{5}$")
    // @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Id
    private Integer matricule;

    @NotBlank(message = "Ce champ ne peut pas être vide")
    @NotNull(message = "Ce champ ne peut pas être null")
    private String name;

    @NotNull(message = "Ce champ ne peut pas être null")
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @NotNull(message = "Ce champ ne peut pas être null")
    @Enumerated(EnumType.STRING)
    private Section section;
}