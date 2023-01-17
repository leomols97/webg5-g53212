package Chap15.jpa.DB.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Chap15.jpa.DB.dto.Student;
import Chap15.jpa.Repositories.CourseRepository;
import Chap15.jpa.Repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentDAO {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    public Student findStudentByMatricule(String StudentMatricule) {
        return studentRepository.findById(StudentMatricule).orElse(null);
    }

    public Optional<Student> findStudentByMatriculeOPTIONAL(String StudentMatricule) {
        return studentRepository.findById(StudentMatricule);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> findStudentsByCourseId(String courseId) {
        return studentRepository.findStudentsByCourseId(courseId);
    }

    public void addCourseToStudent(String matricule, String courseId) {
        studentRepository.addCourseToStudent(matricule, courseId);
    }

    public void deleteStudentByMatricule(String studentMatricule) {
        studentRepository.deleteById(studentMatricule);
    }

    public List<Student> findByNameContainingIgnoreCase(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
    }
}
