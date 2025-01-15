package org.rest.book.ms.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.rest.book.ms.dto.GreetRequest;
import org.rest.book.ms.dto.GreetResponse;
import org.rest.book.ms.port.GreetPort;

import static org.rest.book.ms.util.GraphQlUtils.buildGreetingQuery;

@ApplicationScoped
public class GreetService {

    @Inject
    private Logger log;

    @RestClient
    private GreetPort greetPort;

    public String greet(String name) {
        log.info("Greeting request generating for " + name);
        GreetRequest.Variables variables = new GreetRequest.Variables(name);
        GreetRequest request = new GreetRequest(buildGreetingQuery(), variables);
        return callGreetService(request)
                .data()
                .greet();
    }

    @Timeout(3000)
    @Retry(maxRetries = 2, delay = 1000)
    @Fallback(fallbackMethod = "fallBackGreeting")
    public GreetResponse callGreetService(GreetRequest request) {
        log.info("Calling greet-ms for greeting message for " + request.variables().name());
        return greetPort.greetings(request);
    }

    public GreetResponse fallBackGreeting(GreetRequest request) {
        log.warn("Fallback method called for greeting as greet-ms is not available/failed");
        return new GreetResponse(new GreetResponse.Greet("Hello Stranger"));
    }
}