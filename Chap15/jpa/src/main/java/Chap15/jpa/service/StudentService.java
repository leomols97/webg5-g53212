package Chap15.jpa.service;

import java.util.List;
import java.util.Optional;

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

    public Student findStudentByMatricule(String matricule) {
        return studentDAO.findStudentByMatricule(matricule);
    }

    public Optional<Student> findStudentByMatriculeOPTIONAL(String matricule) {
        return studentDAO.findStudentByMatriculeOPTIONAL(matricule);
    }

    public List<Student> getStudents() {
        return studentDAO.getAllStudents();
    }

    public Student addStudent(Student student) {
        return studentDAO.saveStudent(student);
    }

    public List<Student> findStudentsByCourseId(String courseId) {
        return studentDAO.findStudentsByCourseId(courseId);
    }

    public void addCourseToStudent(String matricule, String courseId) {
        studentDAO.addCourseToStudent(matricule, courseId);
    }

    public List<Student> filterStudentsByName(String name) {
        return studentDAO.findByNameContainingIgnoreCase(name);
    }

    public void updateStudent(Student student) {
        studentDAO.updateStudent(student);
    }
}