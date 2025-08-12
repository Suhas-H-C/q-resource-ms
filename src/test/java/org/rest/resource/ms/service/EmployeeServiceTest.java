package org.rest.resource.ms.service;

import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;
import org.rest.resource.ms.model.Employee;
import org.rest.resource.ms.port.GreetPort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.rest.resource.ms.util.EmployeeTestUtil.employeeJohn;

class EmployeeServiceTest {
    private final Logger log = Logger.getLogger(GreetServiceTest.class);
    private final GreetPort port = mock(GreetPort.class);
    private final EmployeeService service = new EmployeeService(log, port);

    @Test
    void should_return_employees() {
        when(port.allEmployees()).thenReturn(List.of(employeeJohn()));
        List<Employee> employees = service.allEmployees();
        assertNotNull(employees);
        assertEquals(1, employees.getFirst().id());
        verify(port).allEmployees();
    }

    @Test
    void should_return_emptyList_when_port_is_down() {
        List<Employee> employees = service.fallBackEmployees();
        assertNotNull(employees);
        assertTrue(employees.isEmpty());
        verify(port, never()).allEmployees();
    }

    @Test
    void should_return_employee_when_Id_is_passed() {
        int employeeId = 1;
        when(port.employeeById(employeeId)).thenReturn(employeeJohn());
        Employee employee = service.getEmployeeById(employeeId);
        assertNotNull(employee);
        assertEquals(1, employee.id());
        verify(port).employeeById(employeeId);
    }

    @Test
    void should_return_null_when_port_is_down() {
        int employeeId = 1;
        Employee employee = service.fallBackEmployeeById(employeeId);
        assertNull(employee);
        verify(port, never()).employeeById(employeeId);
    }
}