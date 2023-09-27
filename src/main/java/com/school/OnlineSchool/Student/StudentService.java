package com.school.OnlineSchool.Student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.school.OnlineSchool.Exception.StudentNotFoundException;
import com.school.OnlineSchool.User.User;

@Service
public class StudentService implements StudentServiceImp {

    @Autowired
    private StudentRepository studentRepository;
   //  @Autowired
   //  private UserRepository userRepository;


     @Autowired
   PasswordEncoder passwordEncoder;
    @Override
    public List<Student> getAllStudent() {
      return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(Long id) {
        Optional<Student> Deletestudent = findStudentById(id);
       Deletestudent.ifPresent(student -> studentRepository.deleteById(id));
    }

    @Override
    public Student createStudent(Student student) {


        Student studentSave = studentRepository.save(student);

        User user = new User();
        String encPsd = this.passwordEncoder.encode(studentSave.getLastName());
        
        user.setFirstName(studentSave.getFirstName());
        user.setLastName(student.getLastName());
        user.setEmail(studentSave.getEmail());
        user.setPassword(encPsd);
        user.setRole("ROLE_STUDENT");
        return studentSave;
    }

    @Override
    public Student updateStudent(Student student) {
      return studentRepository.save(student);
    }

    @Override
    public Optional<Student> findStudentById(Long id) {
       return  Optional.ofNullable(studentRepository.findById(id)) 
       .orElseThrow(() -> new StudentNotFoundException("No student found with the id : "+ id));
    }
    

}
