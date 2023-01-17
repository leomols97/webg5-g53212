package Chap15.jpa.DB.dao;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Chap15.jpa.DB.dto.Course;
import Chap15.jpa.Repositories.CourseRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseDAO {

    // private EntityManager entityManager;

    @Autowired
    CourseRepository courseRepository;

    // public CourseDAO(EntityManager entityManager) {
    // this.entityManager = entityManager;

    // }

    // get all the courses from the database
    public List<Course> getAllCourses() {
        // Query query = (Query) entityManager.createQuery("from Course");
        // List<Course> courses = query.getResultList();
        // return courses;

        return (List<Course>) courseRepository.findAll();
    }

    // return the course by giving id as input
    public Course findCourseById(String courseId) {
        // Course course = entityManager.find(Course.class, courseId);
        // return course;
        return courseRepository.findById(courseId).get();
    }

    // add the course to the database
    public Course saveCourse(Course course) {
        // Course dbCourse = entityManager.merge(course);
        // course.setId(dbCourse.getId());
        // return course;
        return courseRepository.save(course);
    }

    // add the student to the course
    public void addStudentToCourse(String matricule, String courseId) {
        courseRepository.addStudentToCourse(matricule, courseId);
    }

    public List<Course> findCoursesForThisStudent(String matricule) {
        return courseRepository.findCoursesForThisStudent(matricule);
    }

    // delete the course from the database using course id
    public void deleteCourseById(String courseId) {
        // Query query = (Query) entityManager.createQuery("delete from Course where
        // id=:courseId");
        // query.setParameter("courseId", courseId);
        // query.executeUpdate();
        courseRepository.deleteById(courseId);
    }
}
