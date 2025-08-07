package org.rest.resource.ms.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.jboss.logging.Logger;
import org.rest.resource.ms.model.Employee;
import org.rest.resource.ms.port.GreetPort;

import java.util.List;

import static java.util.Collections.emptyList;

@ApplicationScoped
public class EmployeeService {

    private final Logger log;
    private final GreetPort port;

    @Inject
    public EmployeeService(Logger log, GreetPort port) {
        this.log = log;
        this.port = port;
    }

    @Timeout(3000)
    @Retry(maxRetries = 2, delay = 1000)
    @Fallback(fallbackMethod = "fallBackEmployees")
    public List<Employee> allEmployees() {
        log.info("Calling greet-ms for employees");
        return port.allEmployees();
    }

    @Timeout(3000)
    @Retry(maxRetries = 2, delay = 1000)
    @Fallback(fallbackMethod = "fallBackEmployeeById")
    public Employee getEmployeeById(Integer id) {
        log.info("Calling greet-ms for employee by Id " + id);
        return port.employeeById(id);
    }

    public List<Employee> fallBackEmployees() {
        log.warn("Fallback method called for employees as greet-ms is not available/failed");
        return emptyList();
    }

    public Employee fallBackEmployeeById(Integer id) {
        log.warn("Fallback method called for employee as greet-ms is not available/failed with Id " + id);
        return null;
    }
}