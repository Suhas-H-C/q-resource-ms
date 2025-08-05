package org.rest.resource.ms.mocks;

import io.quarkus.test.Mock;
import jakarta.enterprise.context.ApplicationScoped;
import org.rest.resource.ms.model.Employee;
import org.rest.resource.ms.port.GreetPort;

import java.util.Arrays;
import java.util.List;

@Mock
@ApplicationScoped
public class MockGreetPort implements GreetPort {

    @Override
    public String greeting(String userName) {
        return "";
    }

    @Override
    public List<Employee> allEmployees() {
        return Arrays.asList(
                new Employee(1, "Employee1"),
                new Employee(2, "Employee2"));
    }

    @Override
    public Employee employeeById(int id) {
        return new Employee(1, "Employee1");
    }
}