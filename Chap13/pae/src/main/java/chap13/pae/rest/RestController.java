package chap13.pae.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import chap13.pae.business.*;
import chap13.pae.dto.*;

@RestControllerAdvice
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class RestController {

    @Autowired
    Pae pae;

    @GetMapping("/coursesList")
    public ResponseEntity<Iterable<CourseResponse>> coursesList() {
        return new ResponseEntity<>(pae.getCourses(), HttpStatus.OK);
    }

    // @GetMapping("/courseslist")
    // public List<Course> course() {
    // List<Course> coursesList = pae.getCourses();
    // return coursesList;
    // }

    @GetMapping("/**")
    public String errorPage() {
        return "erreur";
    }
}