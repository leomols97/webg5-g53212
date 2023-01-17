package Chap15.jpa.DB.dao;

import java.util.List;

import Chap15.jpa.DB.dto.Course;

public interface CourseInterface {

    /**
     * get all the courses from the database
     *
     * @return the list of courses found
     */
    List<Course> getAllCourses();

    /**
     * return the course by giving the idof the course
     *
     * @param courseId the id of the course to be found
     * @return the course found
     */
    Course findCourseById(int courseId);

    /**
     * add a course to the database
     *
     * @param course the course to be added to the database
     * @return the course added to the database
     */
    Course saveCourse(Course course);

    /**
     * delete the course from the database using the course id
     *
     * @param courseId the id of the course to be deleted
     */
    void deleteCourseById(int courseId);

    /**
     * add a student to a course using the student's matricule and the course's id
     * and save it to the table course_student
     *
     * @param matricule
     * @param courseId
     */
    public void addStudentToCourse(String matricule, String courseId);

    /**
     * find the courses of a student
     *
     * @param matricule the matricule of the student
     * @return the list of courses found
     */
    public List<Course> findCoursesForThisStudent(String matricule);
}