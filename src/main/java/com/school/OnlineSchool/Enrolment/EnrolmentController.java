
package com.school.OnlineSchool.Enrolment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/enrolments")
@RequiredArgsConstructor
public class EnrolmentController {

 
    @Autowired
    private  EnrolmentService enrolmentService;


    @GetMapping
    public ResponseEntity<List<Enrolment>> getAllEnrolments() {
        List<Enrolment> enrolments = enrolmentService.getAllEnrolments();
        return new ResponseEntity<>(enrolments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enrolment> getEnrolmentById(@PathVariable Long id) {
        Enrolment enrolment = enrolmentService.getEnrolmentById(id);
        if (enrolment != null) {
            return new ResponseEntity<>(enrolment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Enrolment> createEnrolment(@RequestBody Enrolment enrolment) {
        Enrolment createdEnrolment = enrolmentService.createEnrolment(enrolment);
        return new ResponseEntity<>(createdEnrolment, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enrolment> updateEnrolment(@PathVariable Long id, @RequestBody Enrolment enrolment) {
        Enrolment updatedEnrolment = enrolmentService.updateEnrolment(id, enrolment);
        if (updatedEnrolment != null) {
            return new ResponseEntity<>(updatedEnrolment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrolment(@PathVariable Long id) {
        enrolmentService.deleteEnrolment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
