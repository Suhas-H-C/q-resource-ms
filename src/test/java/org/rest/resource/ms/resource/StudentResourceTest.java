package org.rest.resource.ms.resource;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.hamcrest.Matchers.*;
import static org.rest.resource.ms.util.StudentTestUtil.studentJohn;

@QuarkusTest
@TestTransaction
class StudentResourceTest {

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
                .body("name", equalTo("Kevin"))
                .body("standard", equalTo(2));
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
    void should_delete_student_when_Id_is_passed() {
        given()
                .when()
                .delete("/std/51")
                .then()
                .statusCode(204)
                .body(not(empty()));
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