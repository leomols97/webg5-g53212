package Chap15.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Chap15.jpa.DB.dao.CourseDAO;
import Chap15.jpa.DB.dto.Course;

@Service
public class CourseService {

    @Autowired
    CourseDAO courseDAO;

    public CourseService() {
    }

    public Course findCourseById(String courseId) {
        return courseDAO.findCourseById(courseId);
    }

    public List<Course> getCourses() {
        return courseDAO.getAllCourses();
    }

    public Course addCourse(Course course) {
        return courseDAO.saveCourse(course);
    }

    public void addStudentToCourse(String matricule, String courseId) {
        courseDAO.addStudentToCourse(matricule, courseId);
    }

    public List<Course> findCoursesForThisStudent(String matricule) {
        return courseDAO.findCoursesForThisStudent(matricule);
    }
}