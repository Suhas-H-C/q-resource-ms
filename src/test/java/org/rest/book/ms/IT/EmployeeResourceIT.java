package org.rest.book.ms.IT;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import org.rest.book.ms.resource.EmployeeResourceTest;

@QuarkusIntegrationTest
class EmployeeResourceIT extends EmployeeResourceTest {
    // Execute the same tests but in packaged mode.
}