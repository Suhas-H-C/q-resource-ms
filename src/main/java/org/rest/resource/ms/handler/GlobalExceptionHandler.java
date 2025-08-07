package org.rest.resource.ms.handler;

import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;
import org.rest.resource.ms.exception.ArtistNotFoundException;
import org.rest.resource.ms.exception.StudentNotFoundException;

public class GlobalExceptionHandler {

    @ServerExceptionMapper
    public Response handleArtistNotFoundException(ArtistNotFoundException e) {
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(e.getMessage())
                .build();
    }

    @ServerExceptionMapper
    public Response handleStudentNotFoundException(StudentNotFoundException e) {
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(e.getMessage())
                .build();
    }
}