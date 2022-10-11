package com.example.pae.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pae.model.Course;

@Service
public class Pae {

    List<Course> coursesList = new ArrayList<Course>();

    public Pae() {
        Course intro = new Course("INT", "Introduction", 10);
        Course math = new Course("MAT1", "Mathématiques 1", 3);
        Course dev1 = new Course("DEV1", "Développement 1", 10);
        coursesList.add(intro);
        coursesList.add(math);
        coursesList.add(dev1);
    }

    public List<Course> getCourses() {
        return coursesList;
    }

    public void addCourse(Course course) {
        coursesList.add(course);
    }
}