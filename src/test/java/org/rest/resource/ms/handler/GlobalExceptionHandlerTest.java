package org.rest.resource.ms.handler;

import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;
import org.rest.resource.ms.exception.ArtistNotFoundException;
import org.rest.resource.ms.exception.StudentNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void should_return_response_when_ArtistNotFoundException_is_thrown(){
        Response expectedResponse = Response
                .status(Response.Status.NOT_FOUND)
                .entity("Artist not found")
                .build();
        ArtistNotFoundException artistNotFoundException = new ArtistNotFoundException("Artist not found");
        Response actualResponse = handler.handleArtistNotFoundException(artistNotFoundException);
        assertEquals(expectedResponse.getStatus(), actualResponse.getStatus());
        assertEquals(expectedResponse.getEntity().toString(), actualResponse.getEntity().toString());
    }

    @Test
    void should_return_response_when_StundetNotFoundException_is_thrown(){
        Response expectedResponse = Response
                .status(Response.Status.NOT_FOUND)
                .entity("Student not found")
                .build();
        StudentNotFoundException studentNotFoundException = new StudentNotFoundException("Student not found");
        Response actualResponse = handler.handleStudentNotFoundException(studentNotFoundException);
        assertEquals(expectedResponse.getStatus(), actualResponse.getStatus());
        assertEquals(expectedResponse.getEntity().toString(), actualResponse.getEntity().toString());
    }
}