
package com.school.OnlineSchool.Enrolment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrolmentService implements EnrolmentServiceImp {

   
    @Autowired
    private  EnrolmentRepository enrolmentRepository;


    @Override
    public List<Enrolment> getAllEnrolments() {
        return enrolmentRepository.findAll();
    }

    @Override
    public Enrolment getEnrolmentById(Long id) {
        Optional<Enrolment> optionalEnrolment = enrolmentRepository.findById(id);
        return optionalEnrolment.orElse(null);
    }

    @Override
    public Enrolment createEnrolment(Enrolment enrolment) {
        return enrolmentRepository.save(enrolment);
    }

    @Override
    public Enrolment updateEnrolment(Long id, Enrolment enrolment) {
        enrolment.setId(id);
        return enrolmentRepository.save(enrolment);
    }

    @Override
    public void deleteEnrolment(Long id) {
        enrolmentRepository.deleteById(id);
    }
}
