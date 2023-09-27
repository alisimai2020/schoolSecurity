package com.school.OnlineSchool.Student;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface StudentServiceImp {
List<Student> getAllStudent();

void deleteStudent(Long id);

Student createStudent (Student student);

Student updateStudent(Student student);

Optional<Student> findStudentById(Long id);
}
