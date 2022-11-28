package Chap15.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Chap15.jpa.DB.dao.CourseDAO;
import Chap15.jpa.DB.dto.CourseDTO;

@Service
public class PaeService {

    // List<CourseDTO> coursesList = new ArrayList<CourseDTO>();

    @Autowired
    CourseDAO courseDAO;

    public PaeService() {
        // CourseDTO intro = new CourseDTO("INT", "Introduction 1", 10);
        // CourseDTO math = new CourseDTO("MAT1", "Mathématiques 1", 3);
        // CourseDTO dev1 = new CourseDTO("DEV1", "Développement 1", 10);
        // coursesList.add(intro);
        // coursesList.add(math);
        // coursesList.add(dev1);
    }

    public List<CourseDTO> getCourses() {
        return courseDAO.getAllCourses();
    }

    // public void addCourse(CourseDTO course) {
    // coursesList.add(course);
    // }
}