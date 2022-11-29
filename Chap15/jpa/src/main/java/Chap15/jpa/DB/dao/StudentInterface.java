package Chap15.jpa.DB.dao;

import java.util.List;

import Chap15.jpa.DB.dto.StudentDTO;

public interface StudentInterface {

    List<StudentDTO> getAllStudents();

    StudentDTO findStudentByMatricule(int StudentMatricule);

    StudentDTO saveStudent(StudentDTO Student);

    void deleteStudentByMatricule(int StudentMatricule);
}