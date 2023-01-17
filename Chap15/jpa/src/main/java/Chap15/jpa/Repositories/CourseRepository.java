package Chap15.jpa.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import Chap15.jpa.DB.dto.Course;

public interface CourseRepository extends CrudRepository<Course, String> {
    @Query("SELECT c FROM Course c JOIN c.students cs WHERE cs.id = :matricule")
    List<Course> findCoursesForThisStudent(@Param("matricule") String matricule);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO STUDENT_COURSE (STUDENT_ID, COURSE_ID) VALUES (?,?)", nativeQuery = true)
    void addStudentToCourse(String matricule, String courseId);
}
