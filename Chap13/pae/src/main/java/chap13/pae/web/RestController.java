package chap13.pae.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import chap13.pae.business.*;
import chap13.pae.model.*;

@RestControllerAdvice
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class RestController {

    @Autowired
    Pae pae;

    @GetMapping("/courseslist")
    public ResponseEntity<Iterable<Course>> coursesList() {
        return new ResponseEntity<>(pae.getCourses(), HttpStatus.OK);
    }

    @GetMapping("/**")
    public String errorPage() {
        return "erreur";
    }
}