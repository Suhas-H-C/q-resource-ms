package org.rest.book.ms.mocks;

import io.quarkus.test.Mock;
import jakarta.enterprise.context.ApplicationScoped;
import org.rest.book.ms.port.GreetPort;

@Mock
@ApplicationScoped
public class MockGreetPort implements GreetPort {

    @Override
    public String greeting(String userName) {
        return "";
    }
}