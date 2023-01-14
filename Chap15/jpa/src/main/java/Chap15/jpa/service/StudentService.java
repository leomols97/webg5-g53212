package Chap15.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Chap15.jpa.DB.dao.StudentDAO;
import Chap15.jpa.DB.dto.StudentDTO;

@Service
public class StudentService {

    @Autowired
    StudentDAO studentDAO;

    public StudentService() {
    }

    public List<StudentDTO> getStudents() {
        return studentDAO.getAllStudents();
    }

    public StudentDTO addStudent(StudentDTO student) {
        return studentDAO.saveStudent(student);
    }
}