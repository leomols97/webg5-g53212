package Chap15.jpa.DB.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import Chap15.jpa.DB.dao.CourseDAO;
import Chap15.jpa.DB.dao.StudentDAO;
//import Chap15.jpa.business.*;
import Chap15.jpa.DB.dto.*;

@RestControllerAdvice
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class RestController {

    @Autowired
    CourseDAO courseDAO;

    @Autowired
    StudentDAO studentDAO;

    @GetMapping("/coursesList")
    public ResponseEntity<Iterable<CourseDTO>> coursesList() {
        return new ResponseEntity<>(courseDAO.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/studentsList")
    public ResponseEntity<Iterable<StudentDTO>> studentsList() {
        return new ResponseEntity<>(studentDAO.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/**")
    public String errorPage() {
        return "error";
    }
}