package Chap15.jpa.DB.dao;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Chap15.jpa.DB.dto.CourseDTO;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseDAO implements CourseInterface {

    private EntityManager entityManager;

    @Autowired
    public CourseDAO(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    // get all the courses from the database
    @Override
    public List<CourseDTO> getAllCourses() {
        Query query = (Query) entityManager.createQuery("from CourseDTO");
        List<CourseDTO> courses = query.getResultList();

        return courses;
    }

    // return the course by giving id as input
    @Override
    public CourseDTO findCourseById(int courseId) {
        CourseDTO course = entityManager.find(CourseDTO.class, courseId);
        return course;
    }

    // add the course to the database
    @Override
    public CourseDTO saveCourse(CourseDTO course) {
        CourseDTO dbCourse = entityManager.merge(course);
        course.setId(dbCourse.getId());
        return course;
    }

    // delete the course from the database using transaction id
    @Override
    public void deleteCourseById(int courseId) {
        Query query = (Query) entityManager.createQuery("delete from CourseDTO where id=:courseId");
        query.setParameter("courseId", courseId);
        query.executeUpdate();
    }
}
