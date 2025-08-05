package org.rest.resource.ms.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.jboss.logging.Logger;
import org.rest.resource.ms.port.GreetPort;

import static org.rest.resource.ms.util.BookConstants.FAULT_TOLERANT_GRAPHQL_RESPONSE;

@ApplicationScoped
public class GreetService {

    private final Logger log;
    private final GreetPort greetPort;

    @Inject
    public GreetService(Logger log, GreetPort greetPort) {
        this.log = log;
        this.greetPort = greetPort;
    }

    public String greet(String name) {
        log.info("Greeting request generating for " + name);
        return callGreetService(name);
    }

    @Timeout(3000)
    @Retry(maxRetries = 2, delay = 1000)
    @Fallback(fallbackMethod = "fallBackGreeting")
    public String callGreetService(String name) {
        log.info("Calling greet-ms for greeting message for " + name);
        return greetPort.greeting(name);
    }

    public String fallBackGreeting(String name) {
        log.warn("Fallback method called for greeting as greet-ms is not available/failed");
        return FAULT_TOLERANT_GRAPHQL_RESPONSE;
    }
}