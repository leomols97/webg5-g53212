package Chap15.jpa.DB.dto;

import javax.persistence.Id;
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
 * Cette classe a pour simple but de montrer un exemple d'utilisaiton d'une
 * relation 1-1 UNIDIRECTIONNELLE avec Student
 */
public class Schooladdress {

    @Id
    private String name;
    private String street;
    private int number;
    private String city;
    private String post_code;
}