package com.example.pae.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pae.model.*;

@Service
public class pae {

    public List<Course> getCourses() {
        Course intro = new Course("INT", "Introduction", 10);
        Course math = new Course("MAT1", "Mathématiques 1", 3);
        Course dev1 = new Course("DEV1", "Développement 1", 10);
        List<Course> coursesList = new ArrayList<Course>();
        coursesList.add(intro);
        coursesList.add(math);
        coursesList.add(dev1);

        return coursesList;
    }
}