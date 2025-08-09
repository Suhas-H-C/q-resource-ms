package org.rest.resource.ms.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;
import org.rest.resource.ms.exception.StudentNotFoundException;
import org.rest.resource.ms.pojo.Student;
import org.rest.resource.ms.repository.StudentRepository;

import java.util.List;

import static java.util.Objects.isNull;

@ApplicationScoped
public class StudentService {

    private final Logger log;
    private final StudentRepository repository;

    @Inject
    public StudentService(Logger log, StudentRepository studentRepository) {
        this.log = log;
        this.repository = studentRepository;
    }

    public List<Student> allStudents() {
        log.info("fetching all students");
        return repository.getStudents();
    }

    public Student getStudentById(Integer id) {
        log.info("fetching student by id " + id);
        Student student = repository.getById(id);
        if (isNull(student)) {
            throw new StudentNotFoundException("No data found for provided id " + id);
        }
        return student;
    }

    @Transactional
    public boolean persist(Student student) {
        log.info("persisting student...");
        repository.save(student);
        return true;
    }

    @Transactional
    public boolean remove(Integer id) {
        Student student = repository.getById(id);
        if (isNull(student)) {
            throw new StudentNotFoundException("No data found for provided id " + id);
        } else {
            log.info("Removing student with id " + id);
            return repository.deleteStudent(student);
        }
    }
}