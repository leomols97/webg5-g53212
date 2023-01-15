package Chap15.jpa.DB.dto;

import javax.persistence.Id;
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
 * Cette classe a pour simple but de montrer un exemple d'utilisaiton d'une
 * relation 1-1 UNIDIRECTIONNELLE avec Student
 */
public class SchoolAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String post_code;
}