package Chap15.jpa.DB.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Chap15.jpa.DB.dto.Course;
import Chap15.jpa.Repositories.CourseRepository;

import java.util.List;

@Repository
public class CourseDAO {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    public Course findCourseById(String courseId) {
        return courseRepository.findById(courseId).get();
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public void addStudentToCourse(String matricule, String courseId) {
        courseRepository.addStudentToCourse(matricule, courseId);
    }

    public List<Course> findCoursesForThisStudent(String matricule) {
        return courseRepository.findCoursesForThisStudent(matricule);
    }

    public void deleteCourseById(String courseId) {
        courseRepository.deleteById(courseId);
    }
}
