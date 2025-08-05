package org.rest.resource.ms.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.rest.resource.ms.model.Employee;
import org.rest.resource.ms.service.EmployeeService;

import java.util.List;

@Path("/v1/emp")
public class EmployeeResource {

    @Inject
    private EmployeeService service;

    @GET
    public List<Employee> allEmployees() {
        return service.allEmployees();
    }

    @GET
    @Path("/{id}")
    public Employee employeeById(@PathParam(value = "id") int id) {
        return service.getEmployeeById(id);
    }
}