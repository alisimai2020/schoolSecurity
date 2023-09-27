package com.school.OnlineSchool.Enrolment;


import java.util.List;

public interface EnrolmentServiceImp {
    List<Enrolment> getAllEnrolments();
    Enrolment getEnrolmentById(Long id);
    Enrolment createEnrolment(Enrolment enrolment);
    Enrolment updateEnrolment(Long id, Enrolment enrolment);
    void deleteEnrolment(Long id);
}
