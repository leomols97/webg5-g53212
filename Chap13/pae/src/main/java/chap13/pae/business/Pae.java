package chap13.pae.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import chap13.pae.dto.CourseResponse;

@Service
public class Pae {

    List<CourseResponse> coursesList = new ArrayList<CourseResponse>();

    public Pae() {
        CourseResponse intro = new CourseResponse("INT", "Introduction 1", 10);
        CourseResponse math = new CourseResponse("MAT1", "Mathématiques 1", 3);
        CourseResponse dev1 = new CourseResponse("DEV1", "Développement 1", 10);
        coursesList.add(intro);
        coursesList.add(math);
        coursesList.add(dev1);
    }

    public List<CourseResponse> getCourses() {
        return coursesList;
    }

    // public void addCourse(Course course) {
    // coursesList.add(course);
    // }
}