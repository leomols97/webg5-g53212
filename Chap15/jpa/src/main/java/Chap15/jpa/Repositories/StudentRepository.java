package Chap15.jpa.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import Chap15.jpa.DB.dto.Student;

public interface StudentRepository extends CrudRepository<Student, String> {
    @Query("SELECT s FROM Student s JOIN s.courses sc WHERE sc.id = :courseId")
    List<Student> findStudentsByCourseId(@Param("courseId") String courseId);
}
