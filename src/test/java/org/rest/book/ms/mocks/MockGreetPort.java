package org.rest.book.ms.mocks;

import io.quarkus.test.Mock;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.rest.book.ms.dto.GreetRequest;
import org.rest.book.ms.dto.GreetResponse;
import org.rest.book.ms.port.GreetPort;

@Mock
@RestClient
public class MockGreetPort implements GreetPort {

    @Override
    public GreetResponse greetings(GreetRequest request) {
        return new GreetResponse(new GreetResponse.Greet("Hello from book-ms REST"));
    }
}