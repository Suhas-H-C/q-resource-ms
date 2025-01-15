package org.rest.book.ms.port;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.rest.book.ms.dto.GreetRequest;
import org.rest.book.ms.dto.GreetResponse;

@RegisterRestClient(configKey = "greet-ms")
@Path("/graphql")
public interface GreetPort {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    GreetResponse greetings(GreetRequest request);
}