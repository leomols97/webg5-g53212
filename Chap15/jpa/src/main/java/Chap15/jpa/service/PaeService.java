package Chap15.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Chap15.jpa.DB.dao.CourseDAO;
import Chap15.jpa.DB.dao.StudentDAO;
import Chap15.jpa.DB.dto.Course;
import Chap15.jpa.DB.dto.Student;

@Service
public class PaeService {

    // List<CourseDTO> coursesList = new ArrayList<CourseDTO>();

    @Autowired
    CourseDAO courseDAO;

    public PaeService() {
    }

    public List<Course> getCourses() {
        return courseDAO.getAllCourses();
    }
}