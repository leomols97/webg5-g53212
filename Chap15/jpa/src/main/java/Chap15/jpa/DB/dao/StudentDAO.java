package Chap15.jpa.DB.dao;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Chap15.jpa.DB.dto.Student;
import Chap15.jpa.DB.dto.Student;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    // get all the Students from the database
    // @Override
    public List<Student> getAllStudents() {
        Query query = (Query) entityManager.createQuery("from Student");
        List<Student> students = query.getResultList();

        return students;
    }

    // return the Student by giving id as input
    // @Override
    public Student findStudentByMatricule(int StudentMatricule) {
        Student Student = entityManager.find(Student.class, StudentMatricule);
        return Student;
    }

    // add the Student to the database
    // @Override
    public Student saveStudent(Student student) {
        Student dbStudent = entityManager.merge(student);
        student.setMatricule(dbStudent.getMatricule());
        return student;
    }

    // delete the Student from the database using student matricule
    // @Override
    public void deleteStudentByMatricule(int studentMatricule) {
        Query query = (Query) entityManager.createQuery("delete from Student where id=:studentMatricule");
        query.setParameter("studentMatricule", studentMatricule);
        query.executeUpdate();
    }
}
