package Chap15.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Chap15.jpa.DB.dao.StudentDAO;
import Chap15.jpa.DB.dto.Student;

@Service
public class StudentService {

    @Autowired
    StudentDAO studentDAO;

    public StudentService() {
    }

    public List<Student> getStudents() {
        return studentDAO.getAllStudents();
    }

    public Student addStudent(Student student) {
        return studentDAO.saveStudent(student);
    }
}