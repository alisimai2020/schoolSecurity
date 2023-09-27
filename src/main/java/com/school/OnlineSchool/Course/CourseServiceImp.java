package com.school.OnlineSchool.Course;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface CourseServiceImp {
    
    void deleteCourse(String coursecode);
    Course createCourse(Course course);
    Course updateCourse(Course course);
    Optional<Course> findCourseByID(String coursecode);
    List<Course> getAllCourse();
}
