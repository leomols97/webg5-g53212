package Chap15.jpa.DB.dao;

import java.util.List;

import Chap15.jpa.DB.dto.Course;

public interface CourseInterface {

    List<Course> getAllCourses();

    Course findCourseById(int courseId);

    Course saveCourse(Course course);

    void deleteCourseById(int courseId);
}