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

    public List<Course> getCourses() {
        return courseDAO.getAllCourses();
    }

    public Course addCourse(Course course) {
        return courseDAO.saveCourse(course);
    }
}