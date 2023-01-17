package Chap15.jpa.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import Chap15.jpa.DB.dto.Student;

public interface StudentRepository extends CrudRepository<Student, String> {
    @Query("SELECT s FROM Student s JOIN s.courses sc WHERE sc.id = :courseId")
    List<Student> findStudentsByCourseId(@Param("courseId") String courseId);

    // Sélectionne les étudiants ayant plus de ECTS que la valeur passée en
    // paramètre
    // @Query("SELECT student.* FROM students INNER JOIN student_course ON
    // student.matricule = student_course.student_id INNER JOIN courses ON
    // student_course.course_id = courses.id GROUP BY student.matricule HAVING
    // SUM(courses.ECTS) > :ECTS")
    // List<Student> findStudentsThatHaveMoreECTSThan(int ECTS);

    // Sélectionne les étudiants dont le nom contient la chaîne de caractères passée
    // en paramètre
    @Query("SELECT s FROM Student s WHERE s.name LIKE %:name%")
    List<Student> findByNameContainingIgnoreCase(String name);
}
