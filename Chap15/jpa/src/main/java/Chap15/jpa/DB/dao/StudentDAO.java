package Chap15.jpa.DB.dao;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Chap15.jpa.DB.dto.Student;
import Chap15.jpa.Repositories.CourseRepository;
import Chap15.jpa.Repositories.StudentRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDAO {

    private EntityManager entityManager;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    public StudentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    // get all the Students from the database
    public List<Student> getAllStudents() {
        // Query query = (Query) entityManager.createQuery("from Student");
        // List<Student> students = query.getResultList();
        // return students;
        return (List<Student>) studentRepository.findAll();
    }

    // return the Student by giving id as input
    public Student findStudentByMatricule(String StudentMatricule) {
        // Student Student = entityManager.find(Student.class, StudentMatricule);
        return studentRepository.findById(StudentMatricule).get();
    }

    // add the Student to the database
    public Student saveStudent(Student student) {
        // Student dbStudent = entityManager.merge(student);
        // student.setMatricule(dbStudent.getMatricule());
        // return student;

        return studentRepository.save(student);
    }

    public List<Student> findStudentsByCourseId(String courseId) {
        return studentRepository.findStudentsByCourseId(courseId);
    }

    public void addStudentToCourse(String matricule, String courseId) {
        courseRepository.addStudentToCourse(matricule, courseId);
    }

    // delete the Student from the database using student matricule
    public void deleteStudentByMatricule(String studentMatricule) {
        // Query query = (Query) entityManager.createQuery("delete from Student where
        // id=:studentMatricule");
        // query.setParameter("studentMatricule", studentMatricule);
        // query.executeUpdate();

        studentRepository.deleteById(studentMatricule);
    }
}
