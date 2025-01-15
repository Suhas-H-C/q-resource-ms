package org.rest.book.ms.port;

import io.smallrye.graphql.client.typesafe.api.GraphQLClientApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.NonNull;
import org.eclipse.microprofile.graphql.Query;

@GraphQLClientApi(configKey = "greet-ms")
public interface GreetPort {

    @Query("greet")// name of the query on the external service
    String greeting(@NonNull @Name("name") String userName); // name of the parameter on the external service and constraints
}