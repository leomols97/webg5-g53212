package Chap15.jpa.DB.dto;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
    // car, sinon, on ne peut pas créer un étudiant avec un matricule donné
    // @Min(10000)
    // @Max(99999)
    // @Pattern(regexp = "^\\d{5}$")
    // @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Id
    @NotBlank(message = "Ce champ ne peut pas être vide")
    @Digits(message = "Number should contain 5 digits.", fraction = 0, integer = 5)
    private Integer matricule;

    @NotBlank(message = "Ce champ ne peut pas être vide")
    private String name;

    @NotNull(message = "Ce champ ne peut pas être null")
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @NotNull(message = "Ce champ ne peut pas être null")
    @Enumerated(EnumType.STRING)
    private Section section;
}