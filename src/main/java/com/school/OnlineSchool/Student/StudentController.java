package com.school.OnlineSchool.Student;

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

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getStudent(){
        return ResponseEntity.ok(studentService.getAllStudent());
        
    }

     @PostMapping("/add")
    public ResponseEntity<Student> add(@RequestBody Student student){
        return new ResponseEntity<>(studentService.createStudent(student), CREATED);
    }

    @GetMapping("/student/{id}")
    public Optional<Student> findStudent(@PathVariable("id") Long id){
        return studentService.findStudentById(id);
    }
     @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> AddStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.createStudent(student),OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> update(@RequestBody Student student){
        return new ResponseEntity<>(studentService.updateStudent(student), OK);
    }


       @GetMapping("/{id}")
    public Optional<Student> getById(@PathVariable("id") Long id){
        return studentService.findStudentById(id);
    }
    
}
