package org.rest.resource.ms.resource;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.graphql.Ignore;
import org.junit.jupiter.api.Test;
import org.rest.resource.ms.entity.Student;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
@TestTransaction
class StudentResourceTest {

    @Test
    void should_save_student() {
        Student std = new Student("John",3);
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(std)
                .when()
                .post("/std")
                .then()
                .statusCode(201)
                .body(notNullValue());
    }

    @Test
    void should_return_all_students() {
        given()
                .when()
                .get("/std")
                .then()
                .log()
                .all()
                .statusCode(200)
                .body(hasItems());
    }

    @Test
    void should_throw_exception_when_studentById_is_not_found() {
        given()
                .when()
                .delete("/std/501")
                .then()
                .log()
                .all()
                .statusCode(404)
                .body(not(empty()));
    }
}