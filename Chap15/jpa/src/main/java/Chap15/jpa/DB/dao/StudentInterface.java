package Chap15.jpa.DB.dao;

import java.util.List;

import Chap15.jpa.DB.dto.Student;

public interface StudentInterface {

    // get all the Students from the database
    List<Student> getAllStudents();

    /**
     * return the Student by giving id as input
     *
     * @param StudentMatricule the matricule of the Student to be found
     * @return the Student found
     */
    Student findStudentByMatricule(int StudentMatricule);

    /**
     * add the Student to the database
     *
     * @param Student the Student to be added to the database
     * @return the Student added to the database
     */
    Student saveStudent(Student Student);

    /**
     * delete the Student from the database using student matricule
     *
     * @param StudentMatricule the matricule of the Student to be deleted
     */
    void deleteStudentByMatricule(int StudentMatricule);

    /**
     * find the Students by a course they're enrolled in
     */
    public List<Student> findStudentsByCourseId(String courseId);

    /**
     * add a Student to a course using the Student's matricule and the course's id
     * and save it to the table course_student
     *
     * @param matricule the matricule of the Student to be added
     * @param courseId  the id of the course to be added to
     */
    public void addStudentToCourse(String matricule, String courseId);

    /**
     * find the Students by their name
     *
     * @param name a part of the name of the Student to be found
     * @return the list of Students found
     */
    public List<Student> findByNameContainingIgnoreCase(String name);
}