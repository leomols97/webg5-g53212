package Chap15.jpa.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import Chap15.jpa.DB.dto.Course;
import Chap15.jpa.DB.dto.Student;

public interface CourseRepository extends CrudRepository<Course, String> {
    @Query("SELECT c FROM Course c JOIN c.students cs WHERE cs.id = :matricule")
    List<Student> findByStudent(@Param("matricule") String matricule);
}
