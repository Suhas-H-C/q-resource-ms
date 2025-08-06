package org.rest.resource.ms.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.rest.resource.ms.entity.Student;
import org.rest.resource.ms.service.StudentService;

import java.util.List;

@Path("/std")
public class StudentResource {

    @Inject
    private StudentService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAllArtists() {
        return service.allStudents();
    }

    @GET
    @Path("/{id}")
    public Student getArtistById(@PathParam("id") Integer id) {
        return service.getStudentById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Student artist) {
        return Response
                .status(201)
                .entity(service.persist(artist))
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response remove(@PathParam("id") Integer id) {
        return Response
                .status(204)
                .entity(service.remove(id))
                .build();
    }
}