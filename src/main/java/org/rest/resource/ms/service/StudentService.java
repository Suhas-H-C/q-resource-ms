package org.rest.resource.ms.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;
import org.rest.resource.ms.entity.Student;
import org.rest.resource.ms.exception.StudentNotFoundException;

import java.util.List;

import static java.util.Objects.isNull;

@ApplicationScoped
public class StudentService {

    private final Logger log;

    @Inject
    public StudentService(Logger log) {
        this.log = log;
    }

    public List<Student> allStudents() {
        log.info("fetching all students");
        return Student.listAll();
    }

    public Student getStudentById(Integer id) {
        log.info("fetching student by id " + id);
        Student student = Student.findById(id);
        if (isNull(student)) {
            throw new StudentNotFoundException("No data found for provided id " + id);
        }
        return student;
    }

    @Transactional
    public boolean persist(Student artist) {
        log.info("persisting student...");
        Student.persist(artist);
        return true;
    }

    @Transactional
    public boolean remove(Integer id) {
        if (isNull(Student.findById(id))) {
            throw new StudentNotFoundException("No data found for provided id " + id);
        } else {
            return Student.deleteById(id);
        }
    }
}