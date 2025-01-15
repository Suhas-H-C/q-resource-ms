package org.rest.book.ms.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyString;

@QuarkusTest
public class GreetResourceTest {
    @Test
    void should_greet_user_when_triggered() {
        given()
                .queryParam("name", "book-ms")
                .when()
                .get("/v1/greet")
                .then()
                .statusCode(200)
                .body(emptyString());
    }

}