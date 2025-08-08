package org.rest.resource.ms.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.rest.resource.ms.pojo.Student;

import java.util.List;

@ApplicationScoped
public class StudentRepository {

    @PersistenceContext(unitName = "std")
    EntityManager em;

    public void save(Student student) {
        em.persist(student);
    }

    public Student getById(Integer id) {
        return em.find(Student.class, id);
    }

    public List<Student> getStudents() {
        return em.createQuery("SELECT a FROM Student a", Student.class)
                .getResultList();
    }

    public boolean deleteStudent(Student std) {
        em.remove(std);
        return true;
    }
}