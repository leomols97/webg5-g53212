package Chap15.jpa.DB.dao;

import java.util.List;

import Chap15.jpa.DB.dto.Student;

public interface StudentInterface {

    List<Student> getAllStudents();

    Student findStudentByMatricule(int StudentMatricule);

    Student saveStudent(Student Student);

    void deleteStudentByMatricule(int StudentMatricule);
}