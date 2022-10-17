package chap13.pae.model;

// import javax.validation.constraints.Min;
// import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Course {
    // @NotBlank(message = "L`ID du cours ne peut pas être vide !")
    String id;

    // @NotBlank(message = "Le titre du cours ne peut pas être vide !")
    String title;

    // @Min(value = 1, message = "Les ECTS doivent être de minimum 1 !")
    int ECTS;
}