package org.rest.resource.ms.mocks;

import io.quarkus.test.Mock;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.rest.resource.ms.model.IsbnNumber;
import org.rest.resource.ms.port.NumberPort;

// This class is a mock implementation of the NumberPort interface.
@Mock
@RestClient
public class MockNumberPort implements NumberPort {
    @Override
    public IsbnNumber getIsbnNumber() {
        IsbnNumber isbnNumber = new IsbnNumber();
        isbnNumber.setIsbn13("13-1234567890123");
        return isbnNumber;
    }
}