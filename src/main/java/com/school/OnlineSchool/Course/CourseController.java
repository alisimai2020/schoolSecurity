package com.school.OnlineSchool.Course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1/course")
@RestController
@RequiredArgsConstructor
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    private ResponseEntity<List<Course>> getAllCourse(){
        return ResponseEntity.ok(courseService.getAllCourse());
    }


    @PostMapping("/add")
    private ResponseEntity<Course> add(@RequestBody Course course){
        return new ResponseEntity<>(courseService.createCourse(course),CREATED);
    }
    
     
    @GetMapping("/{coursecode}")
    public Optional<Course> findCourse(@PathVariable("coursecode") String coursecode){
        return courseService.findCourseByID(coursecode);
    }

      @DeleteMapping("/delete/{cousecode}")
    public ResponseEntity<Course> AddCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.createCourse(course),OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Course> updatecourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.updateCourse(course), OK);
    }
}
