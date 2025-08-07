package org.rest.resource.ms.IT;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import org.rest.resource.ms.resource.BookResourceTest;

@QuarkusIntegrationTest
class BookResourceIT extends BookResourceTest {
    // Execute the same tests but in packaged mode.
}