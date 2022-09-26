package com.example.pae.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.pae.business.pae;
import com.example.pae.model.Course;

@Controller
public class CourseController {

    @Autowired
    pae pae;

    @GetMapping("/courses")
    public String getCourses(Model model) {
        System.out.println("ioyboihb");
        List<Course> coursesList = pae.getCourses();
        model.addAttribute("coursesList", coursesList);
        return "courses";
    }
}