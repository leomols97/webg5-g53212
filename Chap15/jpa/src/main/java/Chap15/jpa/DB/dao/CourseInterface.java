package Chap15.jpa.DB.dao;

import java.util.List;

import Chap15.jpa.DB.dto.CourseDTO;

public interface CourseInterface {

    List<CourseDTO> getAllCourses();

    CourseDTO findCourseById(int courseId);

    CourseDTO saveCourse(CourseDTO course);

    void deleteCourseById(int courseId);
}