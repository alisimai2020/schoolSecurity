package com.school.OnlineSchool.Course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.OnlineSchool.Exception.StudentNotFoundException;
@Service
public class CourseService  implements CourseServiceImp{

    @Autowired
    private CourseRepository courseRepository;
    @Override
    public void deleteCourse(String coursecode) {
       Optional<Course> coursedelete = findCourseByID(coursecode);
        coursedelete.ifPresent(course ->courseRepository.deleteById(coursecode) );
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
      return courseRepository.save(course);
    }

    @Override
    public Optional<Course> findCourseByID(String coursecode) {
        return  Optional.ofNullable(courseRepository.findById(coursecode)) 
       .orElseThrow(() -> new StudentNotFoundException("No course found with the coursecode : "+ coursecode));
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }
    
}
