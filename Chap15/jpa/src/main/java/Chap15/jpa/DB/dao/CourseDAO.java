package Chap15.jpa.DB.dao;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import Chap15.jpa.DB.dto.Course;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseDAO {

    private EntityManager entityManager;

    public CourseDAO(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    // get all the courses from the database
    public List<Course> getAllCourses() {
        Query query = (Query) entityManager.createQuery("from Course");
        List<Course> courses = query.getResultList();

        return courses;
    }

    // return the course by giving id as input
    public Course findCourseById(int courseId) {
        Course course = entityManager.find(Course.class, courseId);
        return course;
    }

    // add the course to the database
    public Course saveCourse(Course course) {
        Course dbCourse = entityManager.merge(course);
        course.setId(dbCourse.getId());
        return course;
    }

    // delete the course from the database using course id
    public void deleteCourseById(int courseId) {
        Query query = (Query) entityManager.createQuery("delete from Course where id=:courseId");
        query.setParameter("courseId", courseId);
        query.executeUpdate();
    }
}
