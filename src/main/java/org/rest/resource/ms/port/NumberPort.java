package org.rest.resource.ms.port;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.rest.resource.ms.model.IsbnNumber;

@RegisterRestClient(configKey = "number-ms")
public interface NumberPort {

    @GET
    @Path("/v1/numbers")
    @Produces(MediaType.APPLICATION_JSON)
    IsbnNumber getIsbnNumber();
}