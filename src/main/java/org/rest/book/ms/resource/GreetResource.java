package org.rest.book.ms.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.rest.book.ms.service.GreetService;

@Path("/v1")
@Tag(name = "Greet Resource", description = "Greet Resource API")
public class GreetResource {

    @Inject
    private GreetService service;

    @GET
    @Path("/greet")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Greeting endpoint", description = "Greets the user with a message")
    public String hello(@QueryParam("name") String name) {
        return service.greet(name);
    }
}