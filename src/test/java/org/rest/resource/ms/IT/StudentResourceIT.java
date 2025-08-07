package org.rest.resource.ms.IT;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusIntegrationTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.hamcrest.Matchers.*;
import static org.rest.resource.ms.util.StudentTestUtil.studentJohn;

@QuarkusIntegrationTest
@TestTransaction
class StudentResourceIT
        // extends StudentResourceTest <- Commenting as it pulls all tests executing against prod configuration
        // Execute the same tests but in packaged mode.
{
    @Test
    void should_save_student() {
        given()
                .contentType(APPLICATION_JSON)
                .body(studentJohn())
                .when()
                .post("/std")
                .then()
                .statusCode(201)
                .body(equalTo("true"));
    }

    @Test
    void should_return_student_when_Id_is_passed() {
        given()
                .when()
                .get("/std/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("name", equalTo("John"))
                .body("standard", equalTo(5));
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