package org.rest.resource.ms.service;

import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;
import org.rest.resource.ms.exception.StudentNotFoundException;
import org.rest.resource.ms.pojo.Student;
import org.rest.resource.ms.repository.StudentRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.rest.resource.ms.util.StudentTestUtil.studentJohn;

class StudentServiceTest {

    private final Logger log = Logger.getLogger(StudentServiceTest.class);
    private final StudentRepository repository = mock(StudentRepository.class);
    private final StudentService service = new StudentService(log, repository);

    @Test
    void should_return_all_students() {
        when(repository.getStudents()).thenReturn(List.of(studentJohn()));
        List<Student> students = service.allStudents();
        assertFalse(students.isEmpty());
        assertEquals("John", students.getFirst().getName());
        verify(repository).getStudents();
    }

    @Test
    void should_return_student_when_Id_is_passed() {
        Integer studentId = 1;
        when(repository.getById(studentId)).thenReturn(studentJohn());
        Student student = service.getStudentById(studentId);
        assertNotNull(student);
        assertEquals("John", student.getName());
        verify(repository).getById(studentId);
    }

    @Test
    void should_throw_StudentNotFoundException_when_student_is_null() {
        Integer studentId = 1;
        when(repository.getById(studentId)).thenReturn(null);
        assertThrows(StudentNotFoundException.class,
                () -> service.getStudentById(studentId));
        verify(repository).getById(studentId);
    }

    @Test
    void should_persist_student() {
        doNothing().when(repository).save(refEq(studentJohn()));
        boolean response = service.persist(studentJohn());
        assertTrue(response);
        verify(repository).save(refEq(studentJohn()));
    }

    @Test
    void should_remove_student() {
        Integer studentId = 1;
        when(repository.getById(studentId)).thenReturn(studentJohn());
        when(repository.deleteStudent(refEq(studentJohn()))).thenReturn(true);
        boolean response = service.remove(studentId);
        assertTrue(response);
        verify(repository).getById(studentId);
        verify(repository).deleteStudent(refEq(studentJohn()));
    }
}