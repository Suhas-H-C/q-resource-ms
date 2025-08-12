package org.rest.resource.ms.service;

import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;
import org.rest.resource.ms.port.GreetPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class GreetServiceTest {

    private final Logger log = Logger.getLogger(GreetServiceTest.class);
    private final GreetPort port = mock(GreetPort.class);
    private final GreetService service = new GreetService(log, port);
    private final static String userName = "John";

    @Test
    void should_greet_user_when_name_is_passed() {
        String expectedOutput = "Hello " + userName;
        when(port.greeting(userName)).thenReturn(expectedOutput);
        String actualResponse = service.callGreetService(userName);
        assertNotNull(actualResponse);
        assertEquals(expectedOutput, actualResponse);
        verify(port).greeting(userName);
    }

    @Test
    void should_call_fallBackMethod_when_greetPort_is_down() {
        String expectedOutput = "Hello Stranger";
        String actualResponse = service.fallBackGreeting(userName);
        assertNotNull(actualResponse);
        assertEquals(expectedOutput, actualResponse);
        verify(port, never()).greeting(userName);
    }
}